package ch12.tradition;

import ch10.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleTest {

    public Role getRole(long id){
        Role role = null;
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            // 预编译SQL
            ps = con.prepareStatement("select id, role_name, note from t_role where id = ?");
            // 设置参数
            ps.setLong(1, id);
            // 执行SQL
            rs = ps.executeQuery();
            // 组装返回pojo
            while(rs.next()){
                role = new Role();
                role.setId(rs.getLong(1));
                role.setRoleName(rs.getString(2));
                role.setNote(rs.getString(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            ConnectionUtil.close(con, ps, rs);
        }
        return role;
    }

    public static void main(String[] args){
        RoleTest test = new RoleTest();
        Role role = test.getRole(1);
        System.out.println(role);
    }
}
