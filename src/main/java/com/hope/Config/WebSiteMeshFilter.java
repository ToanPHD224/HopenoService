package com.hope.Config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter {
	 @Override
	    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
	        builder.addDecoratorPath("/*", "/WEB-INF/views/decorators/customers/customer.jsp");
	        builder.addDecoratorPath("/user/*", "/WEB-INF/views/decorators/users/users.jsp");
	        builder.addDecoratorPath("/admin/*", "/WEB-INF/views/decorators/admin/admin.jsp");
	           
	    }
}	
