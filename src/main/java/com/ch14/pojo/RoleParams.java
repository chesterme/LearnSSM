package com.ch14.pojo;

import org.springframework.stereotype.Component;

/**
 * 带分页参数的角色参数查询
 */
@Component
public class RoleParams {

    private String roleName;
    private String note;
    private PageParams pageParams = null;

    public RoleParams(){}

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public String toString(){
        return "roleName: " + roleName + ", note: " + note + ", " + pageParams;
    }
}
