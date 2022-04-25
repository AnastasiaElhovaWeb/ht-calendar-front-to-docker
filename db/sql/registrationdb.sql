CREATE TABLE manager
(
    id          bigserial PRIMARY KEY,
    email       varchar NOT NULL UNIQUE,
    password    varchar NOT NULL,
    created_at timestamptz not null
);