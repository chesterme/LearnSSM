package ch04;

import java.io.Serializable;

/**
 * 性别枚举类
 */
public enum SexEnum{
    MALE(1, "男"), FEMALE(0, "女");

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SexEnum(){}

    SexEnum(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static SexEnum getSexById(int id){
        for(SexEnum sex : SexEnum.values()){
            System.out.println("getId: " + sex.getId());
            if(sex.getId() == id){
                System.out.println("id: " + id);
                return sex;
            }
        }
        return null;
    }
}
