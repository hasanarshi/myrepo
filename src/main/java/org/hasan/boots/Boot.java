package org.hasan.boots;

import org.hasan.config.TheBeanConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Boot extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses() 
	{
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() 
	{
		// specify the DispatcherServlet which class is a configuration (bean factory)
		return new Class[]{TheBeanConfig.class};
	}

	@Override
	protected String[] getServletMappings() 
	{
		// specify the url those will be intercepted by DispatcherServlet
		return new String[]{"/"};
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) 
	{
		DispatcherServlet servlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
		
		// DispatcherServlet will throw exception if client url is wrong
		servlet.setThrowExceptionIfNoHandlerFound(true);
		
		return servlet;
	}
}
