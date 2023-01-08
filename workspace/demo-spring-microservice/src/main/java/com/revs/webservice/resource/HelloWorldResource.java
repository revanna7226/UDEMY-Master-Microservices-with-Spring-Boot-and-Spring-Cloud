package com.revs.webservice.resource;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/gm")
	public String sayGoorMorning() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("greeting.message", null, "Default Message!", locale);
	}
	
}
