package com.barcode.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.business.ShortcutMenuItemService;
import com.barcode.dto.PageResponse;
import com.barcode.dto.SuccessResponse;
import com.barcode.dto.shortcutMenuItem.CreateShortcutMenuItemRequest;
import com.barcode.dto.shortcutMenuItem.GetAllShortcutMenuItemResponse;

@RestController
@RequestMapping("api/v1/shortcutmenuitem")
public class ShortcutMenuItemController {

	@Autowired
	private ShortcutMenuItemService itemService;

	@PostMapping("/create")
	public SuccessResponse create(@RequestBody CreateShortcutMenuItemRequest request) {
		itemService.create(request);

		return new SuccessResponse();
	}

	@GetMapping("/getShortcutMenuId")
	public PageResponse<GetAllShortcutMenuItemResponse> getShortcutMenuId(@RequestParam UUID id) {
		return itemService.getByShortcutMenuId(id);
	}

	@GetMapping("/getAll")
	public PageResponse<GetAllShortcutMenuItemResponse> getAll() {
		return itemService.getAll();
	}

}
