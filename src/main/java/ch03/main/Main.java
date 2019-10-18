package ch03.main;

import ch03.mapper.RoleMapper;
import ch03.pojo.Role;
import ch03.utils.SqlSessionFactoryUtils;
import ch05.bean.PageParams;
import ch05.bean.RoleParams;
import ch03.mapper.RoleMapper;
import ch03.pojo.Role;
import ch03.utils.SqlSessionFactoryUtils;
import ch05.bean.PageParams;
import ch05.bean.RoleParams;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        Logger log = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());

            Map<String, Object> parameterMap = new HashMap<>();
            parameterMap.put("roleName", "张三");
            parameterMap.put("note", "计算机专业学生");
            List<Role> roles = roleMapper.findRolesByMap(parameterMap);
            for(int i = 0; i < roles.size(); i++){
                System.out.println("roleName：" + roles.get(i).getRoleName() + ", note: " + roles.get(i).getNote());
            }

            roles = roleMapper.findRolesByAnnotation("张三", "计算机专业学生");
            for(int i = 0; i < roles.size(); i++){
                System.out.println("roleName：" + roles.get(i).getRoleName() + ", note: " + roles.get(i).getNote());
            }

            roles = roleMapper.findRolesByBean(new RoleParams("张三", "计算机专业学生"));
            for(int i = 0; i < roles.size(); i++){
                System.out.println("roleName：" + roles.get(i).getRoleName() + ", note: " + roles.get(i).getNote());
            }

            RoleParams roleParams = new RoleParams();
            roleParams.setNote("计算机专业学生");
            roles = roleMapper.findByMix(roleParams, new PageParams(4, 10));
            for(int i = 0; i < roles.size(); i++){
                System.out.println("index: " + i + ", roleName：" + roles.get(i).getRoleName() + ", note: " + roles.get(i).getNote());
            }

            System.out.println("++++++++++++++++++++++++++");
            roles = roleMapper.findByRowBounds("计算机专业学生", new RowBounds());
            for(int i = 0; i < roles.size(); i++){
                System.out.println("index: " + i + ", roleName：" + roles.get(i).getRoleName() + ", note: " + roles.get(i).getNote());
            }

            role.setRoleName("test name");
            role.setNote("test note");
            roleMapper.insertRole(role);
            sqlSession.commit();
            System.out.println("id: " + role.getId());
        }finally{
            if(sqlSession != null){
                sqlSession.close();
            }
        }
    }

}
