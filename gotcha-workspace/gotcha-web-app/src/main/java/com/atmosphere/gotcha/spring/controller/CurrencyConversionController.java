package com.atmosphere.gotcha.spring.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atmosphere.gotcha.spring.bean.CurrencyConversionBean;
import com.atmosphere.gotcha.spring.proxy.CurrencyExchangeServiceProxy;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="This controller used for currency conversion")
public class CurrencyConversionController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	@HystrixCommand(fallbackMethod = "fallbackMethodIfConvertCurrencyFailed")
	@ApiImplicitParams({@ApiImplicitParam(name = "from", defaultValue="USD", required = true, dataType = "String", value = "from value"),
						@ApiImplicitParam(name = "to", defaultValue="INR", required = true, dataType = "String", value = "to value should always INR"),
						@ApiImplicitParam(name = "quantity", required = true, dataType = "BigDecimal", value = "quantity to convert")})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CurrencyConversionBean.class),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Failure")}) 
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		LOG.info("Retrieve Exchange Value using RestTemplate : from:"+from+" to:"+to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		if(response.getId()==-1) {
			RuntimeException exception = new RuntimeException("Currency exchange not found for "+from+" - "+to);
			LOG.error("Unable to find the currency exchange for from:"+from+" to:"+to, exception);
			throw exception;
		}
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	public CurrencyConversionBean fallbackMethodIfConvertCurrencyFailed(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		LOG.warn("Fallback method for convertCurrency");
		return new CurrencyConversionBean(-1L, from, to, new BigDecimal(0), quantity, quantity, 8000);
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	@HystrixCommand(fallbackMethod = "fallbackMethodIfConvertCurrencyFeignFailed")
	@ApiImplicitParams({@ApiImplicitParam(name = "from", defaultValue="USD", required = true, dataType = "String", value = "from value"),
		                @ApiImplicitParam(name = "to", defaultValue="INR", required = true, dataType = "String", value = "to value should always INR"),
		                @ApiImplicitParam(name = "quantity", required = true, dataType = "BigDecimal", value = "quantity to convert")})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CurrencyConversionBean.class),
	@ApiResponse(code = 401, message = "Unauthorized"),
	@ApiResponse(code = 403, message = "Forbidden"),
	@ApiResponse(code = 404, message = "Not Found"),
	@ApiResponse(code = 500, message = "Failure")})
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		LOG.info("Retrieve Exchange Value using Feign client : from:"+from+" to:"+to);
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		if(response.getId()==-1) {
			RuntimeException exception = new RuntimeException("Currency exchange not found for "+from+" - "+to);
			LOG.error("Unable to find the currency exchange for from:"+from+" to:"+to, exception);
			throw exception;
		}
		LOG.info("Response: {}", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	public CurrencyConversionBean fallbackMethodIfConvertCurrencyFeignFailed(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		LOG.warn("Fallback method for convertCurrencyFeign");
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		LOG.info("{}", response);
		return new CurrencyConversionBean(-1L, from, to, new BigDecimal(0), quantity, quantity, 80);
	}
}
