USE RateMyProfessor;

set global local_infile=true;

-- Load date into professors table
LOAD DATA LOCAL INFILE '/Users/xinruiyi/Documents/GitHub/rate-my-prof/csv/Professor.csv'
INTO TABLE professors
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(professor_id,name, campus_id);

-- Load data into reviews table
LOAD DATA LOCAL INFILE '/Users/xinruiyi/Documents/GitHub/rate-my-prof/csv/Comments_final_matched.csv'
INTO TABLE reviews
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(course_id,professor_id,rating,comment,date_posted);

-- Load data into courses table
LOAD DATA LOCAL INFILE '/Users/xinruiyi/Documents/GitHub/rate-my-prof/csv/courses_final_woName.csv'
INTO TABLE courses
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(course_name, course_code,campus_id,professor_id);

-- Update the rating of courses and professors
UPDATE courses
SET rating = (SELECT AVG(rating) FROM reviews WHERE course_id = courses.course_id);
UPDATE professors
SET rating = (SELECT AVG(rating)
FROM reviews
WHERE reviews.professor_id = professors.professor_id);