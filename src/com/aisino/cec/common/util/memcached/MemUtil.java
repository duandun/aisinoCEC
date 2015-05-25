package com.aisino.cec.common.util.memcached;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.alisoft.xplatform.asf.cache.IMemcachedCache;

/**
 * 用于mem操作的工具类，获取servletContext来获取mclient
 * @author jwh
 * @version 1.0
 */
public final class MemUtil {
	private static ServletContext servletContext;
	private static final String defaultClient = "mclient";

	private MemUtil() {

	}

	static {
		WebApplicationContext webApplicationContext = ContextLoader
				.getCurrentWebApplicationContext();
		servletContext = webApplicationContext.getServletContext();
	}

	public static IMemcachedCache getMemClient() {
		return getMemClient(defaultClient);
	}

	public static IMemcachedCache getMemClient(String clientName) {
		if (clientName == null || clientName.trim().length() == 0) {
			return null;
		}
		// 从配置文件读取memcached名称列表，以后实现

		IMemcachedCache client = null;
		try {
			client = (IMemcachedCache) servletContext.getAttribute(clientName);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
		return client;
	}

}
