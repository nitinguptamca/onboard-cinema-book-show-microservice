DROP SCHEMA IF EXISTS cinema CASCADE;

CREATE SCHEMA cinema;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--DROP TABLE IF EXISTS customer.customers CASCADE;

CREATE TYPE approval_status AS ENUM ('APPROVED', 'REJECTED');
CREATE TYPE payment_method AS ENUM ('CREDIT_CARD', 'DEBIT_CARD' ,'UPI','NET_BANKING','PAYPAL');
CREATE TYPE seat_type AS ENUM ('PREMIUM GLIDER' ,'FULL ROCKER' , 'SWING BACK/GLIDER' );

CREATE TABLE cinema.movie
(
    id uuid NOT NULL,
    title character varying COLLATE pg_catalog."default" NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    duration timestamp ,
    publishLanguage character varying COLLATE pg_catalog."default" NOT NULL,
    releaseDate Date NOT NULL,
    country character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT movie_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.show
(
    id uuid NOT NULL,
    showDate DATE NOT NULL,
    startTime timestamp NOT NULL,
    endTime timestamp NOT NULL,
    cinemaHallId UUID NOT NULL,
    movieId UUID NOT NULL,
    CONSTRAINT show_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.cinemaOwner
(
    id uuid NOT NULL,
    owner_email character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    mobile integer NOT NULL,
    pin_code integer NOT NULL,
    onboard_Date Date NOT NULL,
    address character varying COLLATE pg_catalog."default" NOT NULL,
    cinemaId not null,
    CONSTRAINT cinemaOwner_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.cinema
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    contact_number integer NOT NULL,
    pin_code integer NOT NULL,
    address character varying COLLATE pg_catalog."default" NOT NULL,
    totalCinemaHall integer;
    CONSTRAINT cinema_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.cinemaHall
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    TotalSeats integer,
    cinemaId UUID NOT_NULL;
    CONSTRAINT cinemaHall_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.cinemaHallSeat
(
    id integer NOT NULL,
    seatNumber integer not null,
    Type seat_type not null,
    TotalSeats integer,
    cinemaId UUID NOT_NULL;
    CONSTRAINT cinemaHall_pk PRIMARY KEY (id)
);


CREATE TABLE cinema.show_seat
(
    id uuid NOT NULL,
    status approval_status not null,
    price number,
    showSeatId integer not null,
    showId uuid not null,
    bookingId uuid not null,
    CONSTRAINT show_seatßß_pk PRIMARY KEY (id)
);



CREATE TABLE cinema.Booking
(
    id uuid NOT NULL,
    numberOfSeats integer not null,
    bookingTime TIMESTAMP not null,
    status approval_status NOT NULL,
    UserId uuid not null,
    showId uuid not null,
    CONSTRAINT cinemaHall_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.Payment
(
    id uuid NOT NULL,
    amount number NOT NULL,
    transactionTime TIMESTAMP not null,
    DiscountCouponId uuid not null,
    transactionId uuid not null,
    PaymentMethod  payment_method NOT NULL,
    CONSTRAINT cinemaHall_pk PRIMARY KEY (id)
);

-------------
--implement foreign key






