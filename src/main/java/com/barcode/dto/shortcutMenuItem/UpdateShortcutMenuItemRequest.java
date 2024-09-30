package com.barcode.dto.shortcutMenuItem;

import java.util.UUID;

import lombok.Data;

@Data
public class UpdateShortcutMenuItemRequest {

	private UUID id;

	private UUID shortcutMenuId;

	private UUID productId;

}
