package com.atmosphere.gotcha.spring.service;

import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.atmosphere.gotcha.spring.aspect.TrackExecutionDuration;
import com.atmosphere.gotcha.spring.entity.Item;
import com.atmosphere.gotcha.spring.exception.ResourceNotFoundException;
import com.atmosphere.gotcha.spring.repository.ItemRepository;

@Service
@Lazy
@Transactional
public class ItemService {

	private Mapper mapper;
	private ItemRepository itemRepository;
	
	@Autowired
	public ItemService(Mapper mapper, ItemRepository itemRepository) {
		this.mapper=mapper;
		this.itemRepository=itemRepository;
	}
	
	@Transactional(readOnly=true, propagation=Propagation.NESTED)
	@TrackExecutionDuration
	public Optional<Item> findById(Long id) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		return itemRepository.findById(id);
	}
	
	@Transactional(readOnly=true, propagation=Propagation.NESTED)
	@TrackExecutionDuration
	public List<Item> findByName(String name) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		return itemRepository.findByName(name);
	}
	
	@Transactional(readOnly=true)
	@TrackExecutionDuration
	public Page<Item> findAllItems(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={MethodArgumentNotValidException.class})
	@TrackExecutionDuration
	public Item saveItem(Item item)  throws Exception {
		return itemRepository.saveAndFlush(item);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={IllegalArgumentException.class, ResourceNotFoundException.class})
	@TrackExecutionDuration
	public Item updateItem(Item item) throws IllegalArgumentException, ResourceNotFoundException {
		return itemRepository.findById(item.getId()).map(itemDB-> {
			mapper.map(item, itemDB);
			return itemRepository.save(itemDB);
		}).orElseThrow(() -> new ResourceNotFoundException("Id: " + item.getId() + " is not found"));
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={IllegalArgumentException.class, ResourceNotFoundException.class})
	@TrackExecutionDuration
	public Item deleteItem(Long id) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		Item item = null;
			Optional<Item> itemOptional = itemRepository.findById(id);
			if(itemOptional.isPresent()) {
				item = itemOptional.get();
				itemRepository.delete(itemOptional.get());		
			} else {
				throw new ResourceNotFoundException("Id: " + id + " is not found");
			}
		return item;
	}

}