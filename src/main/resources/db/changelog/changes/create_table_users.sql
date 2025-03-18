CREATE TABLE  IF NOT EXISTS users (
    id BIGINT GENERATED PRIMARY KEY,
    username VARCHAR(255),
    token VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
);