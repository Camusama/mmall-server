package com.mmall.common.method.cache;

public class UserCache extends DefaultCache {

	private static final String USER_CACHE = "userCache";

	/**
	 * д��SYS_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(USER_CACHE, key, value);
	}

	/**
	 * �ӻ������Ƴ�
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(USER_CACHE, key);
	}


	/**
	 * ��ȡ����������
	 * 
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(USER_CACHE, key);
	}


}
