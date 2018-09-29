package com.mmall.common.method.cache;

import com.mmall.common.method.SpringContext;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class DefaultCache {

	private static CacheManager cacheManager = ((CacheManager) SpringContext.getBean("cacheManager"));

	/**
	 * �������ơ�Ĭ��Ϊ�ա�Ϊ�յ�����£�ʹ�õ���defaultCache
	 */
	private static String cacheName;

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		DefaultCache.cacheName = cacheName;
	}

	/**
	 * д��SYS_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(cacheName, key, value);
	}

	public static void put(String cacheName, String key, Object value) {
		Element element = new Element(key, value);
		getCache(cacheName).put(element);
	}

	/**
	 * �ӻ������Ƴ�
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(cacheName, key);
	}

	public static void remove(String cacheName, String key) {
		getCache(cacheName).remove(key);
	}

	/**
	 * ��ȡ����������
	 *
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(cacheName, key);
	}

	public static Object get(String cacheName, String key) {
		Element element = getCache(cacheName).get(key);
		return element == null ? null : element.getObjectValue();
	}

	/**
	 * ���һ��Cache��û���򴴽�һ��
	 * 
	 * @param cacheName
	 * @return
	 */
	private static Cache getCache(String cacheName) {
		net.sf.ehcache.Cache cache = cacheManager.getCache(cacheName);
		if (null == cache) {
			cacheManager.addCache(cacheName);
			cache = cacheManager.getCache(cacheName);
			cache.getCacheConfiguration().setEternal(true);
		}
		return cache;
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}

}
