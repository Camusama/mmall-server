/**
 * Copyright 2017 www.kotei-info.com
 * 
 * All rights reserved.
 * 	
 */
package com.mmall.common.method.cache;
 


/**
 * �����ͼ��ҳ����
 * @author yangw786
 * 2017��7��19������11:52:22
 */
public class RegionMapCache extends DefaultCache {

	private static final String REGION_MAP_CACHE = "regionMapCache";

	/**
	 * д��REGION_MAP_CACHE����
	 *
	 * @param key
	 * @return
	 */
	public static void setRegionMap(User user, String regionType, Object value) {
		String key = getRegionMapKey(user, regionType);
		if (null != key && !key.equals(""))
			put(REGION_MAP_CACHE, key, value);
	}

	/**
	 * ��ȡ����������
	 *
	 * @param key
	 * @return
	 */
	public static Object getRegionMap(User user, String regionType) {
		String key = getRegionMapKey(user, regionType);
		return get(REGION_MAP_CACHE, key);
	}

	public static String getRegionMapKey(User user, String regionType) {
		String key = null;
        switch (user.OrgGrade) {
            case OrganizationGrade.Province:
                key = "Province";
                break;
            case OrganizationGrade.City:
                key = String.format("%d%s", user.regions[0].ParentID, regionType == "������" ? "GLQ" : "XZQ");
                break;
            case OrganizationGrade.County:
                if (user.regions.length == 1)
                    key = String.valueOf(user.regions[0].RegionID);
                break;
        }
        if (key != null)
            return String.format("%s%s", REGION_MAP_CACHE, key);
        else
            return key;
	}
}
