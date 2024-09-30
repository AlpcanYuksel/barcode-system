package com.barcode.dto.shortcutMenuItem;

import java.util.UUID;

import lombok.Data;

@Data
public class CreateShortcutMenuItemRequest {

	private UUID shortcutMenuId;

	private UUID productId;

}
