package org.hasan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// this class is a configuration
@Configuration

// specify the location of controllers and services and other resources
@ComponentScan(basePackages={"org.hasan.controllers","org.hasan.services"})

// specify the location of properties file
@PropertySource(value={"classpath:info.properties"})

// activate web-mvc, it is mandatory to avail the services of WebMvcConfigurer
// interface
@EnableWebMvc
public class TheBeanConfig implements WebMvcConfigurer
{
	@Bean // it is a bean
	public InternalResourceViewResolver viewResolver()
	{
		// specify the location and type (extension) of presentation logic
		return new InternalResourceViewResolver("/views/", ".jsp");
	}
	
	// specify the data-source
	DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("password"));
		return ds;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("/webpages/**","/images/**").
			addResourceLocations("/webpages/","/images/");
	}
	
	@Autowired // get the object of Environment interface from the spring
	private Environment env;
	
	@Bean(value="np1") // here the name of bean is np1
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate()
	{
		return new NamedParameterJdbcTemplate(dataSource());
	}

	@Bean(value="np2") // here the name of bean is np1
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate2()
	{
		return new NamedParameterJdbcTemplate(dataSource());
	}
}