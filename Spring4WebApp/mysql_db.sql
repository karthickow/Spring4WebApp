CREATE TABLE EMPLOYEE
(
    ID                INT(10) NOT NULL AUTO_INCREMENT,
    FIRSTNAME         VARCHAR(30),
    LASTNAME          VARCHAR(30),
    TELEPHONE         VARCHAR(15),
    EMAIL             VARCHAR(30)  NOT NULL,
    CREATED_DATE      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (ID),
    UNIQUE KEY (EMAIL)
);
