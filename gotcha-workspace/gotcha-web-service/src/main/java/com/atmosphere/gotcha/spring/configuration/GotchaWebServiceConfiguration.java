package com.atmosphere.gotcha.spring.configuration;

import java.util.Locale;
import javax.annotation.PostConstruct;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.atmosphere.gotcha.spring.converter.ItemIdToItemDTOConverter;
import com.atmosphere.gotcha.spring.entity.Item;
import com.atmosphere.gotcha.spring.interceptor.RequestHandleInterceptorAdapter;
import com.atmosphere.gotcha.spring.service.ItemService;

@Configuration
@EnableAspectJAutoProxy
@EnableJpaAuditing
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.atmosphere.gotcha.spring" })
@EnableJpaRepositories(basePackages = { "com.atmosphere.gotcha.spring.repository" })
@EntityScan(basePackages = { "com.atmosphere.gotcha.spring.entity" })
public class GotchaWebServiceConfiguration implements WebMvcConfigurer {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Bean
	@Lazy
	public Mapper dozerBeanMapper() {
		return new DozerBeanMapper();
	}

	@Autowired
	private RequestHandleInterceptorAdapter requestHandleInterceptorAdapter;

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemIdToItemDTOConverter itemIdToItemDTOConverter;
	
	@PostConstruct
	public void initValue() {
		LOG.info("Inserting some item records in database");
		try {
			itemService.saveItem(new Item("watch", "Electornics"));
			itemService.saveItem(new Item("laptop", "Electornics"));
			itemService.saveItem(new Item("mobile", "Electornics"));
			itemService.saveItem(new Item("puppy", "Animal"));
			itemService.saveItem(new Item("car", "Vehicle"));
			itemService.saveItem(new Item("key", "Utility"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//For i18N support step 1/4
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	//For i18N support step 2/4
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestHandleInterceptorAdapter);
		//For i18N support step 3/4
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	//For i18N support step 4/4
	//For i18N validation support step 1/3
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/i18n/messages", "classpath:/i18n/validationMessages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(3600);
		return messageSource;
	}

	//For i18N validation support step 2/3
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean validatorBean = new LocalValidatorFactoryBean();
		validatorBean.setValidationMessageSource(messageSource());
		return validatorBean;
	}
	
	//For i18N validation support step 3/3
	@Override
	public Validator getValidator() {
		return validator();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(itemIdToItemDTOConverter);
	}
}
