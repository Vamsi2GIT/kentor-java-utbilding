/**
 * Copyright (c) 2013 SLL. <http://sll.se>
 *
 * This file is part of Invoice-Data.
 *
 *     Invoice-Data is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Invoice-Data is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with Invoice-Data.  If not, see <http://www.gnu.org/licenses/lgpl.txt>.
 */

package se.kentor.lab.storagecell.app.listener;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import se.kentor.lab.storagecell.service.IStorageCellService;

/**
 * Initializes context when starting up Web application (see WEB-INF/web.xml).
 *  
 * @author Peter
 *
 */
public class ApplicationContextLoaderListener extends ContextLoaderListener {
    private static final Logger log = LoggerFactory.getLogger(ApplicationContextLoaderListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        log.info("======== Application :: Started ========");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
        log.info("======== Application :: Stopped ========");
    }


    public static final WebApplicationContext getWebRequest(final ServletContext sc) {
        return WebApplicationContextUtils.getWebApplicationContext(sc);
    }

    public static List<String> getActiveProfiles(final ServletContext sc) {
        return Arrays.asList(getWebRequest(sc).getEnvironment().getActiveProfiles());
    }

}
