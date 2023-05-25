CREATE TABLE IF NOT EXISTS cargo
(
    id     SERIAL PRIMARY KEY ,
    name   VARCHAR(200) NOT NULL ,
    type   VARCHAR(200) NOT NULL ,
    weight INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS cargoShip
(
    id     SERIAL PRIMARY KEY ,
    name   VARCHAR(200) NOT NULL ,
    cargoId INTEGER,
    FOREIGN KEY (cargoId)  REFERENCES cargo (id)
);

CREATE TABLE IF NOT EXISTS crane
(
    id     SERIAL PRIMARY KEY ,
    type   VARCHAR(200) NOT NULL
);
CREATE TABLE IF NOT EXISTS schedule
(
    id     SERIAL PRIMARY KEY ,
    date   DATE NOT NULL ,
    time TIME NOT NULL,
    cargoShipId INTEGER NOT NULL,
    cargoId INTEGER NOT NULL,
    parkingPeriod VARCHAR(200) NOT NULL,
    FOREIGN KEY (cargoShipId)  REFERENCES cargoShip (id) ,
    FOREIGN KEY (cargoId)  REFERENCES cargo (id)
);