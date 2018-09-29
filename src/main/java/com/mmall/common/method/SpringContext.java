package com.mmall.common.method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware,DisposableBean {
	
	    private static ApplicationContext applicationContext;
	    /**
	     * ȡ�ô洢�ھ�̬�����е�ApplicationContext.
	     */
	    @Override
	    public void setApplicationContext(ApplicationContext context)
	            throws BeansException {
	        try {
	            applicationContext=context;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * �Ӿ�̬����applicationContext��ȡ��Bean, �Զ�ת��Ϊ����ֵ���������.
	     */
	    public static <T> T getBean(String name){
	        return (T) applicationContext.getBean(name);
	    }
	    public static String[] getBeanNamesForType(Class<?> type){
	        return applicationContext.getBeanNamesForType(type);
	    }
	    /**
	     * ʵ��DisposableBean�ӿ�, ��Context�ر�ʱ����̬����.
	     */
	    @Override
	    public void destroy() throws Exception {
	        applicationContext = null;
	    }

}
