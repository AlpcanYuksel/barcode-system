package com.barcode.dto.shortcutMenu;

import java.util.UUID;

import lombok.Data;

@Data
public class UpdateShortcutMenuRequest {

	private UUID id;

	private UUID categoryId;

}
