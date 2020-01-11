package com.zl.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author zl
 * 一个创建Bean对象的工厂
 * Bean:可重用组件
 * JavaBean:用java语言便携的可重用组件
 *  javabean>实体类
 *  它就是创建我们service和dao对象的
 *  第一个：需要配置文件来配置我们的service和dao
 *          配置的内容：唯一标示=全限定类名(key=value)
 *  第二个：通过读取配置文件中的配置内容，反射创建对象
 *
 *  配置文件可是xml或者properties
 */
public class BeanFactory {
    private static Properties properties;

    private static Map<String,Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        try {
            //实例化对象
            properties=new Properties();
            //获取properties文件的流对象
            InputStream in=BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);

            beans=new HashMap<String,Object>();
            //获取key
            Enumeration keys=properties.keys();

            while(keys.hasMoreElements()){
                String key=keys.nextElement().toString();
                String beanPath=properties.getProperty(key);
                Object value=Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

/*    public static Object getBean(String beanName) {
        try {
            Object bean;
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
            return bean;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }*/
}
