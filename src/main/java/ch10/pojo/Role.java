package ch10.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "role")
public class Role {

    @Value("1")
    private Long id;
    @Value("项目经理")
    private String roleName;
    @Value("高级项目经理")
    private String note;

    public Role(String roleName, String note){
        this.id = 0L;
        this.roleName = roleName;
        this.note = note;
    }

    public Role(Long id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

    public Role(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String toString(){
        return "id: " + id + ", roleName: " + roleName + ", note: " + note;
    }
}
