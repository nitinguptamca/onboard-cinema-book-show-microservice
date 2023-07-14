DROP SCHEMA IF EXISTS customer CASCADE;

CREATE SCHEMA customer;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE customer.customers
(
    id uuid NOT NULL,
    email character varying COLLATE pg_catalog."default" ,
    firstname character varying COLLATE pg_catalog."default" ,
    lastname character varying COLLATE pg_catalog."default" ,
    mobile integer ,
    pincode integer NOT NULL,
    CONSTRAINT customers_pkey PRIMARY KEY (id)
);