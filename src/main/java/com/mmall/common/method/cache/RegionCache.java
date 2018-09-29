package com.mmall.common.method.cache;

import net.sf.ehcache.CacheManager;

public class RegionCache extends DefaultCache{
	private static final String REGION_CACHE = "regionCache";
	/**
	 * д��SYS_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(REGION_CACHE, key, value);
	}

	/**
	 * �ӻ������Ƴ�
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(REGION_CACHE, key);
	}


	/**
	 * ��ȡ����������
	 *
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Object object = get(REGION_CACHE, key);
		return object;
	}
	/**
	 * ���
	 * @param cacheName
	 * @return
	 * @throws Exception
	 */
	public static boolean removeAllEhcache(String cacheName) throws Exception {  
         try {  
             CacheManager myManager = CacheManager.create();  
             myManager.removalAll();  
             return true;  
         } catch (Exception e) {  
             throw new Exception("remove cache " + cacheName + " failed!!!");  
         }  
    }  
}
