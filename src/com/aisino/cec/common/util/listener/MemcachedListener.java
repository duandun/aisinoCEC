package com.aisino.cec.common.util.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

public class MemcachedListener implements ServletContextListener{
    private ICacheManager<IMemcachedCache> manager;
    public static final String MANAGER="manager";
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if(manager!=null){
            manager.stop();
        } 
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
       manager = CacheUtil.getCacheManager(IMemcachedCache.class,  
               MemcachedCacheManager.class.getName());  
       manager.setConfigFile("memcached.xml");  
       manager.start();  
       
       ServletContext servletContext = event.getServletContext();
       servletContext.setAttribute("manager", manager);
       IMemcachedCache cache = manager.getCache("mclient"); 
       servletContext.setAttribute("mclient", cache);
    }

}
