package com.barcode.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barcode.business.ShortcutMenuService;
import com.barcode.dto.PageResponse;
import com.barcode.dto.SuccessResponse;
import com.barcode.dto.shortcutMenu.CreateShortcutMenuRequest;
import com.barcode.dto.shortcutMenu.GetAllShortcutMenuResponse;
import com.barcode.dto.shortcutMenu.UpdateShortcutMenuRequest;

@RestController
@RequestMapping("api/v1/shortcutmenu")
public class ShortcutMenuController {

	@Autowired
	private ShortcutMenuService menuService;

	@PostMapping("/create")
	public SuccessResponse create(@RequestBody CreateShortcutMenuRequest request) {

		menuService.create(request);

		return new SuccessResponse();
	}

	@PutMapping("/update")
	public SuccessResponse update(@RequestBody UpdateShortcutMenuRequest request) {

		menuService.update(request);

		return new SuccessResponse();
	}

	@GetMapping("/getAll")
	public PageResponse<GetAllShortcutMenuResponse> getAll() {
		return menuService.getAll();
	}

}
