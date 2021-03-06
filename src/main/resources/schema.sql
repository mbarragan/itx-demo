DROP TABLE IF EXISTS T_FARE;

CREATE TABLE T_FARE
(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID INT NOT NULL,
    START_DATE TIMESTAMP NOT NULL,
    END_DATE TIMESTAMP NOT NULL,
    PRICE DOUBLE NOT NULL,
    PRIORITY INT NOT NULL,
    CURRENCY VARCHAR(3) NOT NULL,
    PRODUCT_ID INT NOT NULL
);