package com.mmall.common.method.cache;

public class DictCache extends DefaultCache {
	
	private static final String Sys_CACHE = "activeSessionsCache";

	/**
	 * 写入SYS_CACHE缓存
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(Sys_CACHE, key, value);
	}

	/**
	 * 从缓存中移除
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(Sys_CACHE, key);
	}


	/**
	 * 获取缓存中数据
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(Sys_CACHE, key);
	}
}
