CREATE TABLE product (
  id BINARY(16) NOT NULL,
  barcode VARCHAR(45) NOT NULL,
  product_name VARCHAR(45) NOT NULL,
  purchase_price DECIMAL NOT NULL,
  unit_price DECIMAL NOT NULL,
  quantity DECIMAL NOT NULL,
  critical_count INT NOT NULL,
  created_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' NOT NULL,
  inactive_date DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX barcode_unq (barcode ASC) VISIBLE
  );