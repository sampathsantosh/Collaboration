package com.niit.RestController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit")
public class WebResolver {
@Bean
public InternalResourceViewResolver getViewResolver()
{
	System.out.println("Resolver called");
	InternalResourceViewResolver iRVResolver=new InternalResourceViewResolver();
	iRVResolver.setPrefix("WEB-INF/jsp");
	iRVResolver.setSuffix(".jsp");
	return iRVResolver;
}
@Bean(name="multipartResolver")
public CommonsMultipartResolver getMultipartResolver()
{
	CommonsMultipartResolver commonResolver=new CommonsMultipartResolver();
	commonResolver.setMaxUploadSize(1000000);
	return commonResolver;
}
}