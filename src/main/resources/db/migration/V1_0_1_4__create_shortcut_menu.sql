CREATE TABLE shortcut_menu (
  id BINARY(16) NOT NULL,
  category_id BINARY(16) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT cate_menu_fk
    FOREIGN KEY (category_id)
    REFERENCES categories (id)
);