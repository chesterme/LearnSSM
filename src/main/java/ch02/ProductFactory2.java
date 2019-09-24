package ch02;

public class ProductFactory2 implements IProductFactory {

    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = new Product2(productNo);
        product.makeFrom("工厂2");
        return product;
    }

}
