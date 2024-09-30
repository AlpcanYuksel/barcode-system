package com.barcode.dataAccess;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.entities.concretes.ShortcutMenuItem;

public interface ShortcutMenuItemRepository extends JpaRepository<ShortcutMenuItem, UUID> {
	List<ShortcutMenuItem> findByShortcutMenuId(UUID id);

}
