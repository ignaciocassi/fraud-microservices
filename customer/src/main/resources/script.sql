-- Database: customer
CREATE DATABASE customer;

-- Table: public.customer

-- DROP TABLE IF EXISTS customer.public.customer;

CREATE TABLE IF NOT EXISTS customer.public.customer
(
    id bigint NOT NULL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS customer.public.customer
    OWNER to admin;

-- SEQUENCE: public.customer_id_sequence

-- DROP SEQUENCE IF EXISTS public.customer_id_sequence;

CREATE SEQUENCE IF NOT EXISTS customer.public.customer_id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY customer.id;

ALTER SEQUENCE public.customer_id_sequence
    OWNER TO admin;