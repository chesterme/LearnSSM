package ch02;

public class ProductFactory1 implements IProductFactory {

    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = new Product1(productNo);
        product.makeFrom("工厂1");
        return product;
    }
}
