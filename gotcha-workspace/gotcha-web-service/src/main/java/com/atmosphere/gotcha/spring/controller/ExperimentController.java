package com.atmosphere.gotcha.spring.controller;

import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.atmosphere.gotcha.spring.constraints.PositiveLongArray;
import com.atmosphere.gotcha.spring.dto.ItemDTO;
import com.atmosphere.gotcha.spring.dto.ItemDTOExtra;
import com.atmosphere.gotcha.spring.entity.Item;
import com.atmosphere.gotcha.spring.exception.ResourceNotFoundException;
import com.atmosphere.gotcha.spring.service.ItemService;

@RestController
@RequestMapping(value="/exp")
@Validated
public class ExperimentController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private Environment environment;
	private MessageSource messageSource;
	
	@Autowired
	public ExperimentController(Environment environment, Mapper mapper, MessageSource messageSource) {
		this.environment=environment;
		this.messageSource = messageSource;
	}
	
	@RequestMapping
	public ResponseEntity<String> fallbackRequestHandler(WebRequest webRequest) {
		LOG.info("Fallback request handler request for path : "+webRequest);
		return new ResponseEntity<String>("Provide the correct request", HttpStatus.BAD_REQUEST);
    }
	
	//To change the language add request parameter and value as lang=en
	//http://localhost:8000/gotcha.web.service/exp/welcome?lang=en
	//http://localhost:8000/gotcha.web.service/exp/welcome?lang=de
	@RequestMapping(path ="/welcome")
	public String useOfMessageProperties() {
		return messageSource.getMessage("welcome.message", new Object[]{"Ganesh", LocaleContextHolder.getLocale().getLanguage(), LocaleContextHolder.getLocale().getDisplayLanguage()}, LocaleContextHolder.getLocale());
    }
	
	//Note:To use ItemIdToItemEntityConverter, @PathVariable itemDTO and method argument variable name itemDTO should be same
	@RequestMapping(path="/converter/{itemDTO}", method=RequestMethod.GET)
    public ResponseEntity<ItemDTOExtra> useOfconverter(@PathVariable ItemDTO itemDTO) throws Exception, IllegalArgumentException, ResourceNotFoundException {
		LOG.info("GET request for path '/exp/converter/converter/"+itemDTO.getId());
		
		ItemDTOExtra itemDTOExtra = new ItemDTOExtra ();
		itemDTOExtra = new ItemDTOExtra(itemDTO.getId(), itemDTO.getName(), itemDTO.getCategory());
		updateItemDTOExtraInformation(itemDTOExtra,true,"Fetched");
		LOG.info("GET request for path '/exp/converter/itemDTO' is completed");
		
		return new ResponseEntity<ItemDTOExtra>(itemDTOExtra, HttpStatus.FOUND);
    }
	
    //Look the streaming thing here
    //https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/streaming-response-body.html
    @RequestMapping(path="/stream/{delay}", method=RequestMethod.GET)
    public StreamingResponseBody requestStreaming(@PathVariable Integer delay) {

        return new StreamingResponseBody() {
            @Override
            public void writeTo (OutputStream out) throws IOException {
                for (int i = 0; i < 500; i++) {
                    out.write((Integer.toString(i) + " - ").getBytes());
                    out.flush();
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
  
	  private void updateItemDTOExtraInformation(ItemDTOExtra itemDTOExtra, Boolean imported, String message) {
	    	itemDTOExtra.setImported(imported);
	    	itemDTOExtra.setMessage(message);
	    	itemDTOExtra.setPort(new Integer(environment.getProperty("server.port")));
	    }
}
