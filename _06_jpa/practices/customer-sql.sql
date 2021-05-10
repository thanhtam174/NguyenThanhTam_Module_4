create database customers_managerment;

use customers_managerment;

DELIMITER //
CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
BEGIN
    INSERT INTO customers(firstName,lastName) VALUES (first_name,last_name);
END//
DELIMITER ;

insert into customer
values
(1,'Da Nang','sajsman@gmail.com','John');