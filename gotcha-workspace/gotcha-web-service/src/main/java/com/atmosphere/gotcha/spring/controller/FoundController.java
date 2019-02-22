package com.atmosphere.gotcha.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atmosphere.gotcha.spring.constraints.PositiveLongArray;
import com.atmosphere.gotcha.spring.dto.ItemDTO;
import com.atmosphere.gotcha.spring.dto.ItemDTOExtra;
import com.atmosphere.gotcha.spring.entity.Item;
import com.atmosphere.gotcha.spring.exception.ResourceNotFoundException;
import com.atmosphere.gotcha.spring.service.ItemService;

@RestController
@RequestMapping(value="/found")
@Validated
public class FoundController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private Environment environment;
	private Mapper mapper;
	private ItemService itemService;
	
	@Autowired
	public FoundController(Environment environment, Mapper mapper, ItemService itemService) {
		this.environment=environment;
		this.mapper=mapper;
		this.itemService=itemService;
	}
	
	//http://localhost:8000/gotcha.web.service/found/items?page=0&size=4&sort=id,asc
	@RequestMapping(path ="/items", method=RequestMethod.GET)
	public ResponseEntity<Page<ItemDTOExtra>> findAllItems(@Valid Pageable pageable) {
		LOG.info("GET request for path '/found/items' : pageable="+pageable);
		
		Page<Item> pageItem = itemService.findAllItems(pageable);
		List<ItemDTOExtra> itemDTOExtraList = new ArrayList<ItemDTOExtra>();
		pageItem.getContent().forEach(itemDB->{
			ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
			mapper.map(itemDB, itemDTOExtra);
			updateItemDTOExtraInformation(itemDTOExtra,true,"Fetched");
			itemDTOExtraList.add(itemDTOExtra);
		});
		Page<ItemDTOExtra> pageItemDTOExtra = new PageImpl<ItemDTOExtra>(itemDTOExtraList);
		mapper.map(pageItem, pageItemDTOExtra);
		
		LOG.info("GET request for path '/found/items' is completed");
		return new ResponseEntity<Page<ItemDTOExtra>>(pageItemDTOExtra, HttpStatus.FOUND);
    }

	//http://localhost:8000/gotcha.web.service/found/itemByName/watch
	@RequestMapping(path="/itemByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<List<ItemDTOExtra>> findByName(@PathVariable @Valid @Size(min=2, max=300) String name) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		LOG.info("GET request for path '/found/itemByName/"+name);
		
		List <Item> itemList = itemService.findByName(name);
		List <ItemDTOExtra> itemDTOListExtra = new ArrayList<ItemDTOExtra>();
		if(itemList!=null && itemList.isEmpty()==false) {
			itemList.forEach(itemDB -> {
				ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
				mapper.map(itemDB, itemDTOExtra);
				updateItemDTOExtraInformation(itemDTOExtra,true,"Fetched");
				itemDTOListExtra.add(itemDTOExtra);
			});
			LOG.info("GET request for path '/found/itemByName' is completed");
			return new ResponseEntity<List<ItemDTOExtra>>(itemDTOListExtra, HttpStatus.FOUND);
		} else {
			throw new ResourceNotFoundException("Name '"+name+"' is not found");
		}
    }
	
	//http://localhost:8000/gotcha.web.service/found/itemById/2
	@RequestMapping(path="/itemById/{id}", method=RequestMethod.GET)
    public ResponseEntity<ItemDTOExtra> findById(@PathVariable @Valid @Positive @Min(1) @Max(Long.MAX_VALUE) Long id) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		LOG.info("GET request for path '/found/itemById/"+id);
		Optional<Item> optionalItem = itemService.findById(id);
		ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
		if(optionalItem.isPresent()) {
			mapper.map(optionalItem.get(), itemDTOExtra);
			updateItemDTOExtraInformation(itemDTOExtra,true,"Fetched");
			LOG.info("GET request for path '/found/itemById' is completed");
			return new ResponseEntity<ItemDTOExtra>(itemDTOExtra, HttpStatus.FOUND);
		} else {
			throw new ResourceNotFoundException("Id '"+id+"' is not found");
		}
    }
	
	//http://localhost:8000/gotcha.web.service/found/item/save
	//Set header Content-Type=application/json
	@RequestMapping(path="/item/save", method=RequestMethod.POST)
    public ResponseEntity<ItemDTOExtra> saveItem(@RequestBody @Valid ItemDTO itemDTO) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		LOG.info("POST request for path '/found/item/save' : itemDTO="+itemDTO);
		
		Item item = new Item();
		if(itemDTO.getId()!=null) {
			itemDTO.setId(null);
		}
		mapper.map(itemDTO, item);
		itemService.saveItem(item);
		ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
		mapper.map(item, itemDTOExtra);
		updateItemDTOExtraInformation(itemDTOExtra,true,"Saved");
		
		LOG.info("POST request for path '/found/item/save' is completed");
		return new ResponseEntity<ItemDTOExtra>(itemDTOExtra, HttpStatus.CREATED);
    }

	//http://localhost:8000/gotcha.web.service/found/item/saveAll
	//Set header Content-Type=application/json
	@RequestMapping(path="/item/saveAll", method=RequestMethod.POST)
    public ResponseEntity<ItemDTOExtra[]> saveItemList(@RequestBody @Valid ItemDTO itemDTOList[]) {
		LOG.info("POST request for path '/found/item/saveAll' : itemDTOBulkList="+Arrays.deepToString(itemDTOList));
		
		ItemDTOExtra itemDTOExtraList[] = new ItemDTOExtra[itemDTOList.length];
		for(int index=0; index<itemDTOList.length; index++) {
			ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
			try {
				ResponseEntity<ItemDTOExtra> responseEntityItemDTOExtra = saveItem(itemDTOList[index]);
				itemDTOExtra = responseEntityItemDTOExtra.getBody();
				if(itemDTOExtra!=null) {
					updateItemDTOExtraInformation(itemDTOExtra,true,"Saved");
				} else {
					itemDTOExtra = new ItemDTOExtra();
					updateItemDTOExtraInformation(itemDTOExtra,false,"Unable to save this record, Please check it.");
				}
			} catch(Exception exception) {
				mapper.map(itemDTOList[index], itemDTOExtra);
				updateItemDTOExtraInformation(itemDTOExtra,false,exception.getMessage());
			}
			itemDTOExtraList[index] = itemDTOExtra;
		}
		
		LOG.info("POST request for path '/found/item/saveAll' is completed");
		return new ResponseEntity<ItemDTOExtra[]>(itemDTOExtraList, HttpStatus.CREATED);
    }
	
	//http://localhost:8000/gotcha.web.service/found/item/update
	//Set header Content-Type=application/json
    @RequestMapping(path="/item/update", method=RequestMethod.PUT)
    public ResponseEntity<ItemDTOExtra> updateItem(@RequestBody @Valid ItemDTO itemDTO) throws IllegalArgumentException, ResourceNotFoundException {
    	LOG.info("PUT request for path '/found/item/update' : itemDTO="+itemDTO);
    	
    	Item item = new Item();
    	mapper.map(itemDTO, item);
		item = itemService.updateItem(item);
		ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
		mapper.map(item, itemDTOExtra);
    	updateItemDTOExtraInformation(itemDTOExtra,true,"Updated");
    	
    	LOG.info("PUT request for path '/found/item/update' is completed");
    	return new ResponseEntity<ItemDTOExtra>(itemDTOExtra, HttpStatus.OK);
    }
    
	//http://localhost:8000/gotcha.web.service/found/item/updateAll
	//Set header Content-Type=application/json
    @RequestMapping(path="/item/updateAll", method=RequestMethod.PUT)
    public ResponseEntity<ItemDTOExtra[]> updateItemList(@RequestBody @Valid ItemDTO itemDTOList[]) {
    	LOG.info("PUT request for path '/found/item/updateAll' : itemDTOBulkList="+Arrays.deepToString(itemDTOList));
    	
    	ItemDTOExtra itemDTOExtraList[] = new ItemDTOExtra[itemDTOList.length];
    	for(int index=0; index<itemDTOList.length; index++) {
			ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
			try {
				ResponseEntity<ItemDTOExtra> responseEntityItemDTOExtra = updateItem(itemDTOList[index]);
				itemDTOExtra = responseEntityItemDTOExtra.getBody();
				if(itemDTOExtra!=null) {
					updateItemDTOExtraInformation(itemDTOExtra,true,"Updated");
				} else {
					itemDTOExtra = new ItemDTOExtra();
					updateItemDTOExtraInformation(itemDTOExtra,false,"Unable to update this record, Please check it.");
				}
			} catch(Exception exception) {
				mapper.map(itemDTOList[index], itemDTOExtra);
				updateItemDTOExtraInformation(itemDTOExtra,false,exception.getMessage());
			}
			itemDTOExtraList[index] = itemDTOExtra;
		}
    	
		LOG.info("PUT request for path '/found/item/updateAll' is completed");
		return new ResponseEntity<ItemDTOExtra[]>(itemDTOExtraList, HttpStatus.OK);
		
    }
    
    //http://localhost:8000/gotcha.web.service/found/item/delete/2
    @RequestMapping(path="/item/delete/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<ItemDTOExtra> deleteItem(@PathVariable @Valid @Positive @Min(1) @Max(Long.MAX_VALUE) Long id) throws Exception, IllegalArgumentException, ResourceNotFoundException {
    	LOG.info("DELETE request for path '/found/item/delete/"+id);
    	ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
    	Item item=null;
    	item = itemService.deleteItem(id);
		mapper.map(item, itemDTOExtra);
		updateItemDTOExtraInformation(itemDTOExtra,true,"Deleted");
		LOG.info("DELETE request for path '/found/item/delete/{id}' is completed");
		return new ResponseEntity<ItemDTOExtra>(itemDTOExtra, HttpStatus.OK);
    }
    
    //http://localhost:8000/gotcha.web.service/found/item/deleteAll
    @RequestMapping(path="/item/deleteAll", method=RequestMethod.DELETE)
    public ResponseEntity<ItemDTOExtra[]> deleteItemList(@RequestBody @Valid @PositiveLongArray() Long ids[]) {
    	LOG.info("DELETE request for path '/found/item/deleteAll' : ids="+Arrays.toString(ids));
    	ItemDTOExtra itemDTOBulkList[] = new ItemDTOExtra[ids.length];
    	
		for(int index=0; index<ids.length; index++) {
			ItemDTOExtra itemDTOExtra = new ItemDTOExtra();
			try {
				ResponseEntity<ItemDTOExtra> responseEntityItemDTOExtra = deleteItem(ids[index]);
				itemDTOExtra = responseEntityItemDTOExtra.getBody();
				if(itemDTOExtra!=null) {
					updateItemDTOExtraInformation(itemDTOExtra,true,"Deleted");
				} else {
					itemDTOExtra = new ItemDTOExtra();
					updateItemDTOExtraInformation(itemDTOExtra,false,"Unable to delete this record, Please check it.");
					itemDTOExtra.setId(ids[index]);
				}
			} catch(Exception exception) {
				itemDTOExtra.setId(ids[index]);
				itemDTOExtra.setImported(false);
				itemDTOExtra.setMessage(exception.getMessage());
			}
			itemDTOBulkList[index] = itemDTOExtra;
		}
		LOG.info("DELETE request for path '/found/item/deleteAll' is completed");
		return new ResponseEntity<ItemDTOExtra[]>(itemDTOBulkList, HttpStatus.OK);
    }
    
    private void updateItemDTOExtraInformation(ItemDTOExtra itemDTOExtra, Boolean imported, String message) {
    	itemDTOExtra.setImported(imported);
    	itemDTOExtra.setMessage(message);
    	itemDTOExtra.setPort(new Integer(environment.getProperty("server.port")));
    }
}
