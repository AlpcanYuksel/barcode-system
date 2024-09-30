CREATE TABLE customers (
  id BINARY(16) NOT NULL,
  customer_name VARCHAR(45) NOT NULL,
  contact_phone VARCHAR(45) NOT NULL,
  contact_email VARCHAR(45) NOT NULL,
  address VARCHAR(45) NOT NULL,
  created_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX customer_name_unq (customer_name ASC) VISIBLE
);