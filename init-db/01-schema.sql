-- Cleaned schema for init (no pg_dump junk, no owner changes)

SET client_min_messages = warning;

CREATE SEQUENCE public."Order_OrderID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.orders (
                               id_viewable integer NOT NULL DEFAULT nextval('public."Order_OrderID_seq"'::regclass),
                               name character varying(255) NOT NULL,
                               street_1 character varying(255) NOT NULL,
                               street_2 character varying(255),
                               city character varying(100) NOT NULL,
                               state character varying(2) NOT NULL,
                               postal_code character varying(20) NOT NULL,
                               total numeric(10,2) NOT NULL,
                               creation_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
                               marketplace character varying(50),
                               shipped boolean,
                               fulfilled boolean,
                               tracking_number character varying(50),
                               status character varying(20),
                               id uuid DEFAULT gen_random_uuid() NOT NULL,
                               CONSTRAINT orders_pkey PRIMARY KEY (id),
                               CONSTRAINT orders_id_viewable_key UNIQUE (id_viewable)
);

CREATE SEQUENCE public."Order_Item_ItemID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.order_item (
                                   id_viewable integer NOT NULL DEFAULT nextval('public."Order_Item_ItemID_seq"'::regclass),
                                   "order_id_viewable" integer NOT NULL,
                                   sku character varying(50) NOT NULL,
                                   item_name character varying(255) NOT NULL,
                                   quantity integer NOT NULL,
                                   base_price numeric(10,2) NOT NULL,
                                   creation_timestamp timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                   fk_orderid uuid,
                                   id uuid DEFAULT gen_random_uuid() NOT NULL,
                                   CONSTRAINT order_item_pkey PRIMARY KEY (id),
                                   CONSTRAINT order_items_id_viewable_key UNIQUE (id_viewable),
                                   CONSTRAINT fk_orderid FOREIGN KEY (fk_orderid) REFERENCES public.orders(id) NOT VALID
);

CREATE TABLE public.users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE public.authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES public.users(username)
);

CREATE UNIQUE INDEX ix_auth_username on public.authorities (username, authority);

-- Optional: reset sequences to safe starting point (they'll auto-increment anyway)
SELECT setval('public."Order_OrderID_seq"', 30, false);
SELECT setval('public."Order_Item_ItemID_seq"', 1, false);