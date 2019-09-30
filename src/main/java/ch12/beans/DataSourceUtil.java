package ch12.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class DataSourceUtil {

    public static DataSource getDataSource(){
        ApplicationContext act = new ClassPathXmlApplicationContext("ch12/beans/Bean.xml");
        return (DataSource) act.getBean("dataSource");
    }

    public static void main(String[] args){
        DataSource dataSource = DataSourceUtil.getDataSource();
    }

}
