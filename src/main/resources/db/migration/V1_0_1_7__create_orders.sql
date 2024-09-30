CREATE TABLE orders (
  id BINARY(16) NOT NULL,
  customer_id BINARY(16) NULL,
  order_date DATETIME NOT NULL,
  order_price DECIMAL NOT NULL,
  payment_method ENUM('CASH', 'CREDIT_CARD') NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `or_cus_cus_fk`
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);