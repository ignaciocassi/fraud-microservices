-- Database:

CREATE DATABASE Notification;

-- Table: public.notification

-- DROP TABLE IF EXISTS public.notification;

CREATE TABLE IF NOT EXISTS notification
(
    notification_id INT NOT NULL,
    sent_at TIMESTAMP NOT NULL,
    to_customer_id INT NOT NULL,
    to_customer_email VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    message VARCHAR(255) NOT NULL,
    sender varchar(255) NOT NULL,
    CONSTRAINT notitification_pkey PRIMARY KEY (notification_id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.notification
    OWNER to admin;

-- SEQUENCE: public.notification

-- DROP SEQUENCE IF EXISTS public.notification_id_sequence;

CREATE SEQUENCE IF NOT EXISTS public.notification_id_sequence
    INCREMENT 50
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY notification.notification_id;

ALTER SEQUENCE public.notification_id_sequence
    OWNER TO admin;