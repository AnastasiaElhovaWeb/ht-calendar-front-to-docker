CREATE TABLE email
(
    id bigserial PRIMARY KEY,
    title varchar(255) NOT NULL
);

CREATE TABLE position
(
    id bigserial PRIMARY KEY,
    title varchar(255)
);

CREATE TABLE meeting
(
    id bigserial PRIMARY KEY,
    title varchar(255) NOT NULL,
    description varchar(4000),
    date_meeting_start timestamptz NOT NULL,
    date_meeting_end timestamptz NOT NULL,
    date_create timestamptz NOT NULL
);

CREATE TABLE interview
(
    id bigserial PRIMARY KEY,
    title varchar(255) NOT NULL,
    description varchar(4000),
    date_meeting_start timestamptz NOT NULL,
    date_meeting_end timestamptz NOT NULL,
    date_create timestamptz NOT NULL
);

CREATE TABLE address
(
    id bigserial PRIMARY KEY,
    city varchar(255) NOT NULL,
    street varchar(255) NOT NULL,
    house_number int NOT NULL,
    litera varchar(20) NOT NULL,
    building int NOT NULL,
    flat int NOT NULL
);

CREATE TABLE manager
(
    id serial PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    second_name varchar(255) NOT NULL,
    middle_name varchar(255) NOT NULL,
    position_id bigint NOT NULL,
    FOREIGN KEY (position_id) REFERENCES position (id)
);

CREATE TABLE applicant
(
    id serial PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    second_name varchar(255) NOT NULL,
    middle_name varchar(255) NOT NULL,
    interview_id bigint NOT NULL,
    address_id bigint NOT NULL,
    FOREIGN KEY (interview_id) REFERENCES interview (id),
    FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE manager_interview_link
(
    manager_id bigint NOT NULL,
    interview_id bigint NOT NULL,
    PRIMARY KEY (manager_id, interview_id),
    FOREIGN KEY (manager_id) REFERENCES manager (id),
    FOREIGN KEY (interview_id) REFERENCES interview (id)
);

CREATE TABLE manager_meeting_link
(
    manager_id bigint NOT NULL,
    meeting_id bigint NOT NULL,
    PRIMARY KEY (manager_id, meeting_id),
    FOREIGN KEY (manager_id) REFERENCES manager (id),
    FOREIGN KEY (meeting_id) REFERENCES meeting (id)
);

CREATE TABLE applicant_email_link
(
    applicant_id bigint NOT NULL,
    email_id bigint NOT NULL,
    PRIMARY KEY (applicant_id, email_id),
    FOREIGN KEY (applicant_id) REFERENCES applicant (id),
    FOREIGN KEY (email_id) REFERENCES email (id)
);



