DROP TABLE IF EXISTS metermodel;
DROP TABLE IF EXISTS metercategory;
DROP TABLE IF EXISTS meterline;

CREATE TABLE meterline(
    nameid text NOT NULL,
    PRIMARY KEY(nameid)
);

CREATE TABLE metercategory(
    nameid text NOT NULL,
    line_id text,
    PRIMARY KEY(nameid),
    FOREIGN KEY(line_id)
        REFERENCES meterline (nameid)
        ON DELETE CASCADE
);

CREATE TABLE metermodel(
    nameid text NOT NULL,
    category_id text,
    PRIMARY KEY(nameid),
    FOREIGN KEY(category_id)
        REFERENCES metercategory (nameid)
        ON DELETE CASCADE
);

INSERT INTO meterline (nameid)
VALUES
    ('Ares'),
    ('Cronos');

INSERT INTO metercategory (line_id, nameid)
VALUES
    ('Cronos', 'Cronos Old'),
    ('Cronos', 'Cronos L'),
    ('Cronos', 'Cronos NG'),
    ('Ares',   'Ares TB'),
    ('Ares',   'Ares THS');

INSERT INTO metermodel (category_id, nameid)
VALUES
    ('Cronos Old', 'Cronos 6001-A'),
    ('Cronos Old', 'Cronos 6003'),
    ('Cronos Old', 'Cronos 7023'),
    ('Cronos L',   'Cronos 6021L'),
    ('Cronos L',   'Cronos 7023L'),
    ('Cronos NG',  'Cronos 6001-NG'),
    ('Cronos NG',  'Cronos 6003-NG'),
    ('Cronos NG',  'Cronos 6021-NG'),
    ('Cronos NG',  'Cronos 6031-NG'),
    ('Cronos NG',  'Cronos 7021-NG'),
    ('Cronos NG',  'Cronos 7023-NG'),
    ('Ares TB',    'Ares 7021'),
    ('Ares TB',    'Ares 7031'),
    ('Ares TB',    'Ares 7023'),
    ('Ares THS',   'Ares 8023 15'),
    ('Ares THS',   'Ares 8023 200'),
    ('Ares THS',   'Ares 8023 2,5');