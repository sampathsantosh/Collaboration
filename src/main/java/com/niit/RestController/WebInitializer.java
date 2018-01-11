package com.niit.RestController;

import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[]{WebResolver.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses(){
		return null;
	}
	@Override
	protected String[] getServletMappings(){
		return new String[]{"/"};
	}
	@Override
	protected Filter[] getServletFilters() {
		System.out.println("getServletFilters");
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
		return new Filter[] { characterEncodingFilter };
	}
}