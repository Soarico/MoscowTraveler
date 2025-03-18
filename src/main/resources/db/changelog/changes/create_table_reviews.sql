CREATE TABLE  IF NOT EXISTS review (
    id BIGINT GENERATED PRIMARY KEY,
    userId BIGINT,
    sightName VARCHAR(255),
    rate INT,
    comment VARCHAR(255),
);