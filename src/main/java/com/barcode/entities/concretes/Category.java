package com.barcode.entities.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private UUID id;

	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category")
	private List<Product> products;

	@OneToOne(mappedBy = "category")
	private ShortcutMenu shortcutMenu;

}
