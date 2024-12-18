CREATE TABLE username (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE question (
    id BIGINT PRIMARY KEY,
    text VARCHAR(255),
    options VARCHAR(255),
    correct_answer VARCHAR(50)
);
