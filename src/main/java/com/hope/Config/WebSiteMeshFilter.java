package com.hope.Config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	 @Override
	    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
	        builder.addDecoratorPath("/*", "/WEB-INF/views/decorators/customers/customer.jsp");
	        builder.addDecoratorPath("/user", "/WEB-INF/views/decorators/customers/users.jsp");
	        builder.addDecoratorPath("/admin", "/WEB-INF/views/decorators/customers/admin.jsp");
	           
	    }
}	
