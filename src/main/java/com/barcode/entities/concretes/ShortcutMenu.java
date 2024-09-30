package com.barcode.entities.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "shortcut_menu")
public class ShortcutMenu {

	@Id
	@GeneratedValue
	private UUID id;

	@OneToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "shortcutMenu")
	private List<ShortcutMenuItem> menuItems;

}
