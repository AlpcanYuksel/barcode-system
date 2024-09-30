package com.barcode.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barcode.entities.concretes.ShortcutMenu;

public interface ShortcutMenuRepository extends JpaRepository<ShortcutMenu, UUID> {

}
