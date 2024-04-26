-- (1) Campus Table

DROP TABLE IF EXISTS campus;
CREATE TABLE campus (
    campus_id        INT              NOT NULL AUTO_INCREMENT,
    campus_name      VARCHAR(255)     NOT NULL,
    PRIMARY KEY(campus_id)
);

-- Initialize campus table
INSERT INTO campus (campus_name)
VALUES
    ('Online'),
    ('Boston'),
    ('Silicon Valley'),
    ('Seattle'),
    ('Oakland'),
    ('Vancouver'),
    ('Arlington'),
    ('Portland'),
    ('London'),
    ('Burlington'),
    ('Charlotte'),
    ('Miami'),
    ('Nahant'),
    ('Toronto');

-- (2) Professors Table

DROP TABLE IF EXISTS professors;
CREATE TABLE professors (
    professor_id      INT               NOT NULL AUTO_INCREMENT ,
    name              VARCHAR(255)      NOT NULL,
    campus_id         INT,
    rating            DECIMAL(3,2),
    PRIMARY KEY(professor_id)
);

-- (3) Reviews Table

DROP TABLE IF EXISTS reviews;
CREATE TABLE reviews (
    review_id         INT               NOT NULL AUTO_INCREMENT,
    course_id         INT               NOT NULL,
    professor_id      INT               NOT NULL,
    rating            INT               NOT NULL,
    comment           TEXT              NOT NULL,
    date_posted       DATETIME,
    PRIMARY KEY(review_id)
);

-- (4) Courses Table

DROP TABLE IF EXISTS courses;
CREATE TABLE courses(
    course_id         INT                NOT NULL AUTO_INCREMENT,
    course_name       VARCHAR(255)       NOT NULL,
    course_code       VARCHAR(255)       NOT NULL,
    professor_id      INT                NOT NULL,
    campus_id         INT                NOT NULL,
    rating            DECIMAL(3,2),
    PRIMARY KEY(course_id)
);