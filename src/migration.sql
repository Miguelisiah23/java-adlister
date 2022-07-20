USE adlister_db;
DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    username VARCHAR(100),
    email    VARCHAR(100),
    password VARCHAR(100)

);


DROP TABLE IF EXISTS ads;
CREATE TABLE ads
(
    id          INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_id     INT UNSIGNED                            NOT NULL,
    title       VARCHAR(250),
    description VARCHAR(300),
    FOREIGN KEY (user_id) REFERENCES users (id)
);
