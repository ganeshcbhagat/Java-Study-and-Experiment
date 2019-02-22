package com.atmosphere.gotcha.spring.converter;

import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.atmosphere.gotcha.spring.dto.ItemDTO;
import com.atmosphere.gotcha.spring.entity.Item;
import com.atmosphere.gotcha.spring.exception.ResourceNotFoundException;
import com.atmosphere.gotcha.spring.service.ItemService;

@Component
public class ItemIdToItemDTOConverter implements Converter<String, ItemDTO> {

	private ItemService itemService;
	private Mapper mapper;
	
	@Autowired
	public ItemIdToItemDTOConverter(ItemService itemService, Mapper mapper) {
		this.itemService=itemService;
		this.mapper=mapper;
	}
	
	@Override
	public ItemDTO convert(String id) {
		ItemDTO itemDTO = new ItemDTO();
		Optional<Item> optionalItem;
			try {
				optionalItem = itemService.findById(new Long(id));
				if(optionalItem.isPresent()) {
					mapper.map(optionalItem.get(), itemDTO);
					return itemDTO;
				} else {
					throw new RuntimeException(new ResourceNotFoundException("Id"+id+" is not found while conversion.")) ;
				}
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Failed to convert item id to number",e) ;
			} catch (Exception e) {
				throw new RuntimeException(e) ;
			}
	}


}
