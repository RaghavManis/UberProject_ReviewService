CREATE TABLE booking
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NOT NULL,
    updated_at     datetime NULL,
    review_id      BIGINT NULL,
    driver_id      BIGINT NULL,
    passenger_id   BIGINT NULL,
    status         ENUM('SCHEDULED','CANCELLED','CAB_ARRIVED','ASSIGNING_DRIVER','IN_RIDE','COMPLETED') NULL,
    start_time     datetime NULL,
    end_time       datetime NULL,
    total_distance INT      NOT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE bookingreview
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime NULL,
    content    VARCHAR(255) NOT NULL,
    rating DOUBLE NOT NULL,
    CONSTRAINT pk_bookingreview PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NULL,
    name       VARCHAR(255) NULL,
    license    VARCHAR(255) NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE passenger
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE passenger_review
(
    id             BIGINT NOT NULL,
    passenger_name VARCHAR(255) NULL,
    CONSTRAINT pk_passengerreview PRIMARY KEY (id)
);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES bookingreview (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGERREVIEW_ON_ID FOREIGN KEY (id) REFERENCES bookingreview (id);