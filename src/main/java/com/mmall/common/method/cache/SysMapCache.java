package com.mmall.common.method.cache;

public class SysMapCache extends DefaultCache {
	
	private static final String SysMap_CACHE = "sysMapCache";

	/**
	 * д��SYS_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(SysMap_CACHE, key, value);
	}

	/**
	 * �ӻ������Ƴ�
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(SysMap_CACHE, key);
	}


	/**
	 * ��ȡ����������
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(SysMap_CACHE, key);
	}
}
