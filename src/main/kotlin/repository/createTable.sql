CREATE TABLE IF NOT EXISTS users (
    id SERIAl PRIMARY KEY,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    places JSON,
    reviews JSON
);

CREATE TABLE IF NOT EXISTS places (
    id SERIAl PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    photos JSON,
    reviews JSON
);

CREATE TABLE IF NOT EXISTS reviews (
    id SERIAl PRIMARY KEY,
    user_id SERIAl NOT NULL,
    place_id SERIAl NOT NULL,
    rating INT NOT NULL,
    comment TEXT NOT NULL,
);

CREATE TABLE IF NOT EXISTS photos (
    id SERIAl PRIMARY KEY,
    image_url TEXT NOT NULL,
    place_id SERIAl NOT NULL,
);
