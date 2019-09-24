package ch02;

public class ProductFactoryTest {

    public static void main(String[] args){
        ProductFactory factory = new ProductFactory();
        IProduct product = factory.createProduct("1-001");
        System.out.println(product);
    }

}
