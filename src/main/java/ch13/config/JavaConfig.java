package ch13.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("ch13.*")
// 使用事务驱动管理器
@EnableTransactionManagement
public class JavaConfig implements TransactionManagementConfigurer {

    // 数据源
    private DataSource dataSource = null;

    /**
     * 配置数据源
     * @return 数据源
     */
    @Bean(name = "dataSource")
    public DataSource initDataSource(){
        if(dataSource != null){
            return dataSource;
        }

        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/ssm?characterEncoding=utf-8&serverTimezone=GMT%2B8");
        properties.setProperty("username", "test");
        properties.setProperty("password", "123456");
        properties.setProperty("maxActive", "200");
        properties.setProperty("maxIdle", "20");
        properties.setProperty("maxWait", "300000");

        try{
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch(Exception e){
            e.printStackTrace();
        }

        return dataSource;
    }

    /**
     * 配置JdbcTemplate
     * @return jdbcTemplate
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate initJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(initDataSource());
        return jdbcTemplate;
    }

    /**
     * 实现接口方法，返回数据库事务管理器
     * @return 数据库事务管理器
     */
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }
}
