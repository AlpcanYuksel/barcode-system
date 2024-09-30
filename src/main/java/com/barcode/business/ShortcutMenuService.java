package com.barcode.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barcode.core.utilities.config.mappers.ModelMapperService;
import com.barcode.dataAccess.ShortcutMenuRepository;
import com.barcode.dto.PageResponse;
import com.barcode.dto.shortcutMenu.CreateShortcutMenuRequest;
import com.barcode.dto.shortcutMenu.GetAllShortcutMenuResponse;
import com.barcode.dto.shortcutMenu.UpdateShortcutMenuRequest;
import com.barcode.entities.concretes.ShortcutMenu;

@Service
public class ShortcutMenuService {

	@Autowired
	private ShortcutMenuRepository menuRepository;

	@Autowired
	private ModelMapperService modelMapper;

	public ShortcutMenu create(CreateShortcutMenuRequest request) {

		ShortcutMenu shortcutMenu = modelMapper.forRequest().map(request, ShortcutMenu.class);

		return menuRepository.save(shortcutMenu);

	}

	public ShortcutMenu update(UpdateShortcutMenuRequest request) {

		ShortcutMenu shortcutMenu = modelMapper.forRequest().map(request, ShortcutMenu.class);

		return menuRepository.save(shortcutMenu);

	}

	public PageResponse<GetAllShortcutMenuResponse> getAll() {
		List<ShortcutMenu> shortcutMenus = menuRepository.findAll();

		int responseSize = shortcutMenus.size();

		List<GetAllShortcutMenuResponse> response = shortcutMenus.stream()
				.map(menu -> modelMapper.forResponse().map(menu, GetAllShortcutMenuResponse.class)).toList();

		return new PageResponse<GetAllShortcutMenuResponse>(responseSize, response);
	}

}
