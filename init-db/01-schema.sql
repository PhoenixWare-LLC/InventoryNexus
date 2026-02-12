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
    id_viewable        integer                NOT NULL DEFAULT nextval('public."Order_OrderID_seq"'::regclass),
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
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT orders_id_viewable_key UNIQUE (id_viewable)
);

CREATE SEQUENCE public."Order_Item_ItemID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE CACHE 1;

CREATE TABLE public.order_item
(
    id_viewable         integer                NOT NULL DEFAULT nextval('public."Order_Item_ItemID_seq"'::regclass),
    "order_id_viewable" integer                NOT NULL,
    sku                 character varying(50)  NOT NULL,
    item_name           character varying(255) NOT NULL,
    quantity            integer                NOT NULL,
    base_price          numeric(10, 2)         NOT NULL,
    creation_timestamp  timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    fk_orderid          uuid,
    id                  uuid                            DEFAULT gen_random_uuid() NOT NULL,
    CONSTRAINT order_item_pkey PRIMARY KEY (id),
    CONSTRAINT order_items_id_viewable_key UNIQUE (id_viewable),
    CONSTRAINT fk_orderid FOREIGN KEY (fk_orderid) REFERENCES public.orders (id) NOT VALID
);

CREATE TABLE public.app_user
(
    id UUID NOT NULL DEFAULT gen_random_uuid(),
    email VARCHAR(100) NOT NULL,
    username VARCHAR(50) DEFAULT email,
    password VARCHAR(128) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT false,
    admin BOOLEAN NOT NULL DEFAULT false,
    mfa_type VARCHAR(50) NOT NULL DEFAULT 'email',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT CURRENT_USER
)

CREATE TABLE public.role
(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT CURRENT_USER
)

CREATE TABLE public.privilege
(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    resource_name VARCHAR(50) NOT NULL,
    read_privilege BOOLEAN NOT NULL DEFAULT false,
    write_privilege BOOLEAN NOT NULL DEFAULT false,
    update_privilege BOOLEAN NOT NULL DEFAULT false,
    delete_privilege BOOLEAN NOT NULL DEFAULT false,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(50) DEFAULT CURRENT_USER
)

CREATE TABLE public.role_privilege
(
    fk_role_id UUID NOT NULL,
    fk_privilege_id UUID NOT NULL,
    PRIMARY KEY (fk_role_id, fk_privilege_id),
    CONSTRAINT fk_role_privileges_role FOREIGN KEY (fk_role_id) REFERENCES public.role(id),
    CONSTRAINT fk_role_privileges_privilege FOREIGN KEY (fk_privilege_id) REFERENCES public.privilege
)

CREATE TABLE public.app_user_role
(
    fk_role_id UUID NOT NULL,
    fk_app_user_id UUID NOT NULL,
    PRIMARY KEY (fk_role_id, fk_user_id),
    CONSTRAINT fk_app_user_role_role FOREIGN KEY (fk_role_id) REFERENCES public.role(id),
    CONSTRAINT fk_app_user_role_app_user FOREIGN KEY (fk_user_id) REFERENCES public.app_user_role(id)
)

CREATE TABLE public.app_user_privilege
(
    fk_privilege_id UUID NOT NULL,
    fk_app_user_id UUID NOT NULL,
    PRIMARY KEY (fk_privilege_id, fk_app_user_id),
    CONSTRAINT fk_app_user_privilege_privilege FOREIGN KEY (fk_privilege_id) REFERENCES public.privilege(id),
    CONSTRAINT fk_app_user_privilege_app_user FOREIGN KEY (fk_app_user_id) REFERENCES public.app_user(id)
)


CREATE INDEX idx_user_roles_user_id ON public.app_user_role(fk_app_user_id);
CREATE INDEX idx_user_roles_role_id ON public.app_user_role(fk_role_id);
CREATE INDEX idx_role_privileges_role_id ON public.role_privilege(fk_role_id);
CREATE INDEX idx_user_privileges_user_id ON public.role_privilege(fk_privilege_id);

-- Optional: reset sequences to safe starting point (they'll auto-increment anyway)
SELECT setval('public."Order_OrderID_seq"', 30, false);
SELECT setval('public."Order_Item_ItemID_seq"', 1, false);