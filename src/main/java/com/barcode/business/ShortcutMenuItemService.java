package com.barcode.business;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.core.utilities.config.mappers.ModelMapperService;
import com.barcode.dataAccess.ShortcutMenuItemRepository;
import com.barcode.dto.PageResponse;
import com.barcode.dto.shortcutMenuItem.CreateShortcutMenuItemRequest;
import com.barcode.dto.shortcutMenuItem.GetAllShortcutMenuItemResponse;
import com.barcode.entities.concretes.ShortcutMenuItem;

@Service
public class ShortcutMenuItemService {

	@Autowired
	private ShortcutMenuItemRepository itemRepository;

	@Autowired
	private ModelMapperService modelMapper;

	public ShortcutMenuItem create(CreateShortcutMenuItemRequest request) {
		ShortcutMenuItem menuItem = modelMapper.forRequest().map(request, ShortcutMenuItem.class);
		return itemRepository.save(menuItem);

	}

	public PageResponse<GetAllShortcutMenuItemResponse> getByShortcutMenuId(UUID id) {
		List<ShortcutMenuItem> menuItems = itemRepository.findByShortcutMenuId(id);

		int responseSize = menuItems.size();

		List<GetAllShortcutMenuItemResponse> response = menuItems.stream()
				.map(menuItem -> modelMapper.forResponse().map(menuItem, GetAllShortcutMenuItemResponse.class))
				.toList();

		return new PageResponse<GetAllShortcutMenuItemResponse>(responseSize, response);

	}

	public PageResponse<GetAllShortcutMenuItemResponse> getAll() {
		List<ShortcutMenuItem> menuItems = itemRepository.findAll();

		int responseSize = menuItems.size();

		List<GetAllShortcutMenuItemResponse> response = menuItems.stream()
				.map(menuItem -> modelMapper.forResponse().map(menuItem, GetAllShortcutMenuItemResponse.class))
				.toList();

		return new PageResponse<GetAllShortcutMenuItemResponse>(responseSize, response);

	}

}
