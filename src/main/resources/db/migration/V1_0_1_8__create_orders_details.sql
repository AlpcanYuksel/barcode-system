CREATE TABLE order_details (
  id BINARY(16) NOT NULL,
  order_id BINARY(16) NOT NULL,
  product_id BINARY(16) NOT NULL,
  quantity DECIMAL NOT NULL,
  unit_price DECIMAL NOT NULL,
  total_price DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `det_or_or_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `det_prod_prod_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);