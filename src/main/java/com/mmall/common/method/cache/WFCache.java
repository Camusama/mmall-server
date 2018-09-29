package com.mmall.common.method.cache;

public class WFCache extends DefaultCache {

	private static final String WF_CACHE = "workFlowCache";

	/**
	 * д��SYS_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(WF_CACHE, key, value);
	}

	/**
	 * �ӻ������Ƴ�
	 *
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(WF_CACHE, key);
	}


	/**
	 * ��ȡ����������
	 *
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		Object object = get(WF_CACHE, key);
		remove(key);
		return object;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @param key
	 * @return
	 */
	public static Object getData(String key) {
		Object object = get(WF_CACHE, key);
		return object;
	}

}
