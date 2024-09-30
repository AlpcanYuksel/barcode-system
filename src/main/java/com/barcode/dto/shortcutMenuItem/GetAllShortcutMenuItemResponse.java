package com.barcode.dto.shortcutMenuItem;

import java.util.UUID;

import lombok.Data;

@Data
public class GetAllShortcutMenuItemResponse {

	private UUID id;

	private UUID shortcutMenuId;

	private String productName;

	private String barcode;

}
