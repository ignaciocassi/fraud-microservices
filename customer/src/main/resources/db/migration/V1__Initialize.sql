CREATE TABLE postgres.public.customer
(
    id bigint NOT NULL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    );

ALTER TABLE IF EXISTS postgres.public.customer
    OWNER to admin;

CREATE SEQUENCE postgres.public.customer_id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY customer.id;

ALTER SEQUENCE postgres.public.customer_id_sequence
    OWNER TO admin;