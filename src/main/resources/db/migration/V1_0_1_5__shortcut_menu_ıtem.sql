CREATE TABLE shortcut_menu_item (
  id BINARY(16) NOT NULL,
  shortcut_menu_id BINARY(16) NOT NULL,
  product_id BINARY(16) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT `short_menu_fk`
    FOREIGN KEY (`shortcut_menu_id`)
    REFERENCES shortcut_menu (id),
  CONSTRAINT `prod_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES product (id)
);