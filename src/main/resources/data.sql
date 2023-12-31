

CREATE TABLE IF NOT EXISTS authors (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name text,
    email text
);

--CREATE TABLE IF NOT EXISTS users (
--    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--    author_id INTEGER NOT NULL,
--    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
--);

CREATE TABLE IF NOT EXISTS posts (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title text,
    text text,
    author_id INTEGER NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
);


INSERT INTO authors (name, email) VALUES ('name1', 'name1@email.ru1');
INSERT INTO authors (name, email) VALUES ('name2', 'name1@email.ru2');
INSERT INTO authors (name, email) VALUES ('name3', 'name1@email.ru3');

INSERT INTO posts (title, text, author_id) VALUES ('title1', 'text1', 1);
INSERT INTO posts (title, text, author_id) VALUES ('title2', 'text2', 2);
INSERT INTO posts (title, text, author_id) VALUES ('title3', 'text3', 3);