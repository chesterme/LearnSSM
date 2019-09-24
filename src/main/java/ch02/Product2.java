package ch02;

public class Product2 implements IProduct {

    private String name;
    private String productNo;
    private String factoryName;

    public Product2(String productNo) {
        this.name = "卡车";
        this.productNo = productNo;
        factoryName = null;
    }

    @Override
    public void makeFrom(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String toString(){
        return "产品：" + name + "，型号：" + productNo + ", 是由工厂：" + factoryName + ", 制作完成";
    }

}
