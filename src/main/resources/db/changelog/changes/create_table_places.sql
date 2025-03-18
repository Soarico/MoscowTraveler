CREATE TABLE  IF NOT EXISTS places (
    id BIGINT GENERATED PRIMARY KEY,
    sightName VARCHAR(255),
    photo VARCHAR(255),
    placeInRating INT,
    averageRate DOUBLE,
    description VARCHAR(255),
);