package ch05.pojo;

import ch04.SexEnum;

import java.io.Serializable;
import java.util.List;

public class User2 implements Serializable {

    private static final long serialVersionUID = -60447815418677824L;
    private Long id;
    private String userName;
    private String realName;
    private SexEnum sex;
    private String mobile;
    private String email;
    private String note;
    private List<Role2> roleList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Role2> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role2> roleList) {
        this.roleList = roleList;
    }
}
