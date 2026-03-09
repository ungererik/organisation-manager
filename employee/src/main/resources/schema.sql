CREATE TABLE company
(

    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(255) NOT NULL ,
    scope_of_activities VARCHAR(255) NOT NULL


);



CREATE TABLE employee
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL UNIQUE,
    salary DOUBLE NOT NULL,
    company_id BIGINT NOT NULL ,

    CONSTRAINT fk_employee_company
        FOREIGN KEY (company_id)
            REFERENCES company (id)


);