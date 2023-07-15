DROP SCHEMA IF EXISTS cinema CASCADE;

CREATE SCHEMA cinema;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
--DROP TABLE IF EXISTS customer.customers CASCADE;

CREATE TYPE ApprovalStatus AS ENUM ('PENDING', 'PAID', 'APPROVED', 'CANCELLING', 'CANCELLED','REJECTED');
CREATE TYPE PaymentMethod AS ENUM ('CREDIT_CARD', 'DEBIT_CARD' ,'UPI','NET_BANKING','PAYPAL');
CREATE TYPE SeatType AS ENUM ('PREMIUM_GLIDER' ,'FULL_ROCKER' , 'SWING_BACK' );

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
    ownerEmail character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    mobile integer NOT NULL,
    pinCode integer NOT NULL,
    onboardDate Date NOT NULL,
    address character varying COLLATE pg_catalog."default" NOT NULL,
    cinemaId uuid not null,
    CONSTRAINT cinemaOwner_pk PRIMARY KEY (id)
);


CREATE TABLE cinema.cinema
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    contact_number integer NOT NULL,
    pinCode integer NOT NULL,
    address character varying COLLATE pg_catalog."default" NOT NULL,
    totalCinemaHall integer,
    CONSTRAINT cinema_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.cinemaHall
(
    id uuid NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    TotalSeats integer,
    cinemaId UUID NOT NULL,
    CONSTRAINT cinemaHall_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.cinemaHallSeat
(
    id integer NOT NULL,
    seatNumber integer not null,
    Type seatType not null,
    totalSeats integer,
    cinemaHallId UUID NOT NULL,
    CONSTRAINT cinemaHallSeat_pk PRIMARY KEY (id)
);


CREATE TABLE cinema.showSeat
(
    id uuid NOT NULL,
    seatType SeatType not null,
    price numeric(10,2),
    showSeatId integer not null,
    showId uuid not null,
    bookingId uuid not null,
    CONSTRAINT show_seat_pk PRIMARY KEY (id)
);



CREATE TABLE cinema.Booking
(
    id uuid NOT NULL,
    numberOfSeats integer not null,
    bookingTime TIMESTAMP not null,
    status approval_status NOT NULL,
    UserId uuid not null,
    showId uuid not null,
    CONSTRAINT Booking_pk PRIMARY KEY (id)
);

CREATE TABLE cinema.Payment
(
    id uuid NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    transactionTime TIMESTAMP not null,
    DiscountCouponId uuid not null,
    transactionId uuid not null,
    paymentMethod  PaymentMethod NOT NULL,
    CONSTRAINT Payment_pk PRIMARY KEY (id)
);

-------------
--implement foreign key

ALTER TABLE cinema.show
    ADD CONSTRAINT "FK_cinemaHallId" FOREIGN KEY (cinemaHallId)
    REFERENCES cinema.cinemaHall (id) ,
    ADD CONSTRAINT "FK_movieId" FOREIGN KEY (movieId)
    REFERENCES cinema.movie(id)
    MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;

ALTER TABLE cinema.cinemaOwner
    ADD CONSTRAINT "FK_cinemaId" FOREIGN KEY (cinemaId)
    REFERENCES cinema.cinema(id)
    MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;

ALTER TABLE cinema.cinemaHall
    ADD CONSTRAINT "FK_cinemaId" FOREIGN KEY (cinemaId)
    REFERENCES cinema.cinema(id)
    MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;

ALTER TABLE cinema.cinemaHallSeat
    ADD CONSTRAINT "FK_cinemaHall" FOREIGN KEY (cinemaHallId)
    REFERENCES cinema.cinemaHall(id)
    MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;

ALTER TABLE cinema.showSeat
    ADD CONSTRAINT "FK_cinemaHallSeat" FOREIGN KEY (showSeatId)
    REFERENCES cinema.cinemaHallSeat(id),
    ADD CONSTRAINT "FK_showId" FOREIGN KEY (showId)
    REFERENCES cinema.show(id),
    ADD CONSTRAINT "FK_booking" FOREIGN KEY (bookingId)
    REFERENCES cinema.Booking(id)
    MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;


ALTER TABLE cinema.Booking
    ADD CONSTRAINT "FK_showId" FOREIGN KEY (showId)
    REFERENCES cinema.show(id)
    MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;





