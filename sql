CREATE DATABASE SpringTest2 DEFAULT CHARACTER SET utf8;
CREATE USER 'st2user'@'localhost' IDENTIFIED BY 'st2pass';
GRANT ALL PRIVILEGES ON SpringTest2.* to 'st2user'@'localhost';

//create table
CREATE TABLE SpringTest2.test (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(252) NOT NULL
    
);

//insert employee
INSERT INTO SpringTest2.test(name) VALUES ("testOne");