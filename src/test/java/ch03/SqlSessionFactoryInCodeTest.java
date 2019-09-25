package ch03;

import ch03.mapper.RoleMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


/**
 * 使用代码创建SqlSessionFactory
 */
public class SqlSessionFactoryInCodeTest {

    public static void main(String[] args){

        // 数据库连接池信息
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUsername("test");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
        dataSource.setDefaultAutoCommit(false);
        // 采用MyBatis的JDBC事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        // 创建Configuration对象
        Configuration configuration = new Configuration(environment);
        // 注册一个MyBatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("roles", ch03.pojo.Role.class);
        // 加入一个映射器
        configuration.addMapper(RoleMapper.class);
        // 使用SqlSessionFactoryBuilder构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

    }

}
