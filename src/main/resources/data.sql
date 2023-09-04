DROP TABLE IF EXISTS metermodel;
DROP TABLE IF EXISTS metercategory;
DROP TABLE IF EXISTS meterline;

CREATE TABLE meterline(
    id SMALLSERIAL NOT NULL ,
    name text NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE metercategory(
    id SMALLSERIAL NOT NULL ,
    name text NOT NULL,
    line_id SMALLSERIAL,
    PRIMARY KEY(id),
    FOREIGN KEY(line_id)
        REFERENCES meterline (id)
        ON DELETE CASCADE
);

CREATE TABLE metermodel(
   id SMALLSERIAL NOT NULL ,
   name text NOT NULL,
   category_id SMALLSERIAL,
   PRIMARY KEY(id),
   FOREIGN KEY(category_id)
       REFERENCES metercategory (id)
       ON DELETE CASCADE
);

INSERT INTO meterline (name)
VALUES
    ('Ares'),
    ('Cronos');

INSERT INTO metercategory (line_id, name)
VALUES
    (2, 'Cronos Old'),
    (2, 'Cronos L'),
    (2, 'Cronos NG'),
    (1, 'Ares TB'),
    (1, 'Ares THS');

INSERT INTO metermodel (category_id, name)
VALUES
    (1,'Cronos 6001-A'),
    (1, 'Cronos 6003'),
    (1, 'Cronos 7023'),
    (2, 'Cronos 6021L'),
    (2, 'Cronos 7023L'),
    (3, 'Cronos 6001-NG'),
    (3, 'Cronos 6003-NG'),
    (3, 'Cronos 6021-NG'),
    (3, 'Cronos 6031-NG'),
    (3, 'Cronos 7021-NG'),
    (3, 'Cronos 7023-NG'),
    (4, 'Ares 7021'),
    (4, 'Ares 7031'),
    (4, 'Ares 7023'),
    (5, 'Ares 8023 15'),
    (5, 'Ares 8023 200'),
    (5, 'Ares 8023 2,5');