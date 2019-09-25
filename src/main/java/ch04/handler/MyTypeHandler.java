package ch04.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义字符串类型转换器
 */
public class MyTypeHandler implements TypeHandler<String> {

    Logger logger = Logger.getLogger(MyTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        logger.info("设置string参数[" + parameter + "]");
        // 在sql预处理语句中将第i个参数上的值设置成parameter的值
        ps.setString(i, parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        // 在ResultSet对象中取出当前行中指定列名的值，并将其转换成java中String类型
        String result = rs.getString(columnName);
        logger.info("读取string参数1 [" + result + "]");
        return result;
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        // 在ResultSet对象中取出当前行中指定列的值，并将其转换成java中String类型
        String result = rs.getString(columnIndex);
        logger.info("读取string参数2 [" + result + "]");
        return result;
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 在结果中取出当前行中指定列的值，并将其转换成java中String类型
        String result = cs.getString(columnIndex);
        return null;
    }
}
