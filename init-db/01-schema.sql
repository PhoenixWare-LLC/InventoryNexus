-- Cleaned schema for init (no pg_dump junk, no owner changes)

SET
client_min_messages = warning;

CREATE SEQUENCE public."Order_OrderID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE public.orders
(
    name               character varying(255) NOT NULL,
    street_1           character varying(255) NOT NULL,
    street_2           character varying(255),
    city               character varying(100) NOT NULL,
    state              character varying(2)   NOT NULL,
    postal_code        character varying(20)  NOT NULL,
    total              numeric(10, 2)         NOT NULL,
    creation_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    marketplace        character varying(50),
    shipped            boolean,
    fulfilled          boolean,
    tracking_number    character varying(50),
    status             character varying(20),
    id                 uuid                            DEFAULT gen_random_uuid() NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE public."Order_Item_ItemID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE public.product
(
    id UUID NOT NULL PRIMARY KEY DEFAULT gen_random_uuid(),
    product_type VARCHAR(50) NOT NULL,
    sku VARCHAR(50) NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    cost NUMERIC(10,2) NOT NULL,
    upc INTEGER NOT NULL,
    gs1 INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) NOT NULL DEFAULT CURRENT_USER,
    modified_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(50) NOT NULL DEFAULT CURRENT_USER
);


CREATE TABLE public.order_item
(
    sku                 character varying(50)  NOT NULL,
    item_name           character varying(255) NOT NULL,
    quantity            integer                NOT NULL,
    base_price          numeric(10, 2)         NOT NULL,
    creation_timestamp  timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    fk_order_id          uuid,
    id                  uuid                            DEFAULT gen_random_uuid() NOT NULL,
    fk_product_id uuid NOT NULL,
    CONSTRAINT fk_order_item_product_id FOREIGN KEY (fk_product_id) REFERENCES public.product(id),
    CONSTRAINT order_item_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_id FOREIGN KEY (fk_order_id) REFERENCES public.orders (id) NOT VALID
);



CREATE TABLE public.app_user
(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(128) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT false,
    admin BOOLEAN NOT NULL DEFAULT false,
    mfa_type VARCHAR(50) NOT NULL DEFAULT 'email',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT CURRENT_USER
);

CREATE TABLE public.role
(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT CURRENT_USER
);

CREATE TABLE public.privilege
(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    resource_name VARCHAR(50) NOT NULL,
    read_privilege BOOLEAN NOT NULL DEFAULT false,
    write_privilege BOOLEAN NOT NULL DEFAULT false,
    update_privilege BOOLEAN NOT NULL DEFAULT false,
    delete_privilege BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT CURRENT_USER
);

CREATE TABLE public.role_privilege
(
    fk_role_id UUID NOT NULL,
    fk_privilege_id UUID NOT NULL,
    PRIMARY KEY (fk_role_id, fk_privilege_id),
    CONSTRAINT fk_role_privileges_role FOREIGN KEY (fk_role_id) REFERENCES public.role(id),
    CONSTRAINT fk_role_privileges_privilege FOREIGN KEY (fk_privilege_id) REFERENCES public.privilege(id)
);

CREATE TABLE public.app_user_role
(
    fk_role_id UUID NOT NULL,
    fk_app_user_id UUID NOT NULL,
    PRIMARY KEY (fk_role_id, fk_app_user_id),
    CONSTRAINT fk_app_user_role_role FOREIGN KEY (fk_role_id) REFERENCES public.role(id),
    CONSTRAINT fk_app_user_role_app_user FOREIGN KEY (fk_app_user_id) REFERENCES public.app_user(id)
);

CREATE TABLE public.app_user_privilege
(
    fk_privilege_id UUID NOT NULL,
    fk_app_user_id UUID NOT NULL,
    PRIMARY KEY (fk_privilege_id, fk_app_user_id),
    CONSTRAINT fk_app_user_privilege_privilege FOREIGN KEY (fk_privilege_id) REFERENCES public.privilege(id),
    CONSTRAINT fk_app_user_privilege_app_user FOREIGN KEY (fk_app_user_id) REFERENCES public.app_user(id)
);


CREATE INDEX idx_user_roles_user_id ON public.app_user_role(fk_app_user_id);
CREATE INDEX idx_user_roles_role_id ON public.app_user_role(fk_role_id);
CREATE INDEX idx_role_privileges_role_id ON public.role_privilege(fk_role_id);
CREATE INDEX idx_user_privileges_user_id ON public.role_privilege(fk_privilege_id);

-- Optional: reset sequences to safe starting point (they'll auto-increment anyway)
SELECT setval('public."Order_OrderID_seq"', 30, false);
SELECT setval('public."Order_Item_ItemID_seq"', 1, false);