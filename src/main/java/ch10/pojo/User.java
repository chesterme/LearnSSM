package ch10.pojo;

public class User {

    private String name;
    private long id;
    private Role role;

    public User(String name, long id, Role role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString(){
        return "id: " + id + ", name: " + name + role.toString();
    }
}
