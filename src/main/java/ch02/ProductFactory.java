package ch02;

public class ProductFactory implements IProductFactory {

    public IProduct createProduct(String productNo){
        char ch = productNo.charAt(0);
        IProductFactory factory = null;
        switch(ch){
            case '1': factory = new ProductFactory1();break;
            case '2': factory = new ProductFactory2(); break;
            default: break;
        }
        if(factory != null){
            IProduct product = factory.createProduct(productNo);
            return product;
        }
        return null;
    }

}
