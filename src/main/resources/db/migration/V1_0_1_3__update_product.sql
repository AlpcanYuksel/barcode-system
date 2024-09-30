ALTER TABLE product add category_id BINARY(16),
ADD CONSTRAINT fk_category
FOREIGN KEY (category_id)
REFERENCES categories(id);
