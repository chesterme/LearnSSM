package ch10.pojo;

import java.util.*;

public class ComplexAssembly {

    private Long id;
    private List<String> list;
    private Map<String, String> map;
    private Properties prop;
    private Set<String> set;
    private String[] array;

    public ComplexAssembly() {
    }

    public ComplexAssembly(Long id, List<String> list, Map<String, String> map, Properties prop, Set<String> set, String[] array) {
        this.id = id;
        this.list = list;
        this.map = map;
        this.prop = prop;
        this.set = set;
        this.array = array;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < list.size(); i++){
            result += list.get(i) + " ";
        }
        result += "\n";
        for(Map.Entry<String, String> entry : map.entrySet()){
            result += ("key: " + entry.getKey() + ", value: " + entry.getValue() + " ");
        }
        result +="\n";
        Enumeration keys =  prop.propertyNames();
        while(keys.hasMoreElements()){
            result += (keys.nextElement() + " ");
        }
        result +="\n";
        for(String item : set){
            result += item + " ";
        }
        result += "\n";
        for(String item : list){
            result += item + " ";
        }
        return result;
    }
}
