CREATE TABLE IF NOT EXISTS public.fraud
(
    id bigint NOT NULL,
    created_at TIMESTAMP NOT NULL,
    customer_id bigint NOT NULL,
    email character varying NOT NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.fraud
    OWNER to admin;

CREATE SEQUENCE IF NOT EXISTS public.fraud_id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY fraud.id;

ALTER SEQUENCE public.fraud_id_sequence
    OWNER TO admin;

CREATE TABLE IF NOT EXISTS public.fraud_check_history
(
    id INT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    customer_id INT NOT NULL,
    is_fraudster bool not null,
    CONSTRAINT fraud_check_history_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.fraud_check_history
    OWNER to admin;

CREATE SEQUENCE IF NOT EXISTS public.fraud_check_history_id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY fraud_check_history.id;

ALTER SEQUENCE public.fraud_check_history_id_sequence
    OWNER TO admin;