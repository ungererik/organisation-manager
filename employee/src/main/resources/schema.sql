CREATE TABLE company
(

    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(255),
    scope_of_activities VARCHAR(255)


);



CREATE TABLE employee
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255),
    email      VARCHAR(255),
    salary DOUBLE,
    company_id BIGINT,

    CONSTRAINT fk_employee_company
        FOREIGN KEY (company_id)
            REFERENCES company (id)


);