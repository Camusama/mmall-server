package com.mmall.common.method.cache;

public class SysCache extends DefaultCache {
	
	private static final String Sys_CACHE = "sysCache";

	/**
	 * д��SYS_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(Sys_CACHE, key, value);
	}

	/**
	 * �ӻ������Ƴ�
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(Sys_CACHE, key);
	}


	/**
	 * ��ȡ����������
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(Sys_CACHE, key);
	}
}
