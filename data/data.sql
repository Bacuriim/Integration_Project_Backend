DROP TABLE IF EXISTS model_table;
DROP TABLE IF EXISTS category_table;
DROP TABLE IF EXISTS line_table;

CREATE TABLE lineup_table(
     name text NOT NULL,
     PRIMARY KEY(name)
);

CREATE TABLE category_table(
    name text NOT NULL,
    lineup_id text,
    PRIMARY KEY(name),
    FOREIGN KEY(lineup_id)
        REFERENCES lineup_table (name)
        ON DELETE CASCADE
);

CREATE TABLE model_table(
    name text NOT NULL,
    category_id text,
    PRIMARY KEY(name),
    FOREIGN KEY(category_id)
        REFERENCES category_table (name)
        ON DELETE CASCADE
);

INSERT INTO lineup_table (name)
VALUES
    ('Ares'),
    ('Cronos');

INSERT INTO category_table (lineup_id, name)
VALUES
    ('Cronos', 'Cronos Old'),
    ('Cronos', 'Cronos L'),
    ('Cronos', 'Cronos NG'),
    ('Ares',   'Ares TB'),
    ('Ares',   'Ares THS');

INSERT INTO model_table(category_id, name)
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