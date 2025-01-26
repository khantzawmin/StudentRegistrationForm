-- Create the student table
CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    age INT NOT NULL,
    course VARCHAR(255),
    date_of_birth DATE,
    gender VARCHAR(255),
    name VARCHAR(255)
);

-- Insert data into the student table
INSERT INTO student (name, age, course, gender, date_of_birth, address) VALUES
('Khant Zaw', 24 , 'Java', 'Male','2000-03-13','246 Phoehla St, Yangon'),
('Hsu Hsu', 23 ,'Python', 'Female', '2001-05-23', '123 Myaynigone St, Mandalay');


