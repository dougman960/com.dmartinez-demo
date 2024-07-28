DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES
(
    brand_id VARCHAR(255) NOT NULL,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list VARCHAR(255) NOT NULL,
    product_id VARCHAR(255) NOT NULL,
    priority INTEGER,
    price NUMERIC(19,2),
    curr VARCHAR(255)
);