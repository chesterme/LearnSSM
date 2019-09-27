package ch04.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

/**
 * 自定义对象工厂
 * mybatis会使用对象工厂来创建结果集实例
 */
public class MyObjectFactory extends DefaultObjectFactory{

    private static final long serialVersionUID = 2398571423004161112L;
    private static Logger log = Logger.getLogger(MyObjectFactory.class);
    private Object temp = null;

    @Override
    public void setProperties(Properties properties){
        super.setProperties(properties);
        log.info("初始化参数：[" + properties.toString() + "]");
    }

    @Override
    public <T> T create(Class<T> type){
        T result = super.create(type);
        log.info("创建对象：" + result.toString());
        log.info("是否和上次创建的是同一个对象：[" + (temp == result) + "]");
        return result;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs){
        T result = super.create(type, constructorArgTypes, constructorArgs);
        log.info("创建对象：" + result.toString());
        temp = result;
        return result;
    }

    @Override
    public <T> boolean isCollection(Class<T> type){
        return super.isCollection(type);
    }

}
