package ch02;

public class ObserverTest {

    public static void main(String[] args){

        ProductList observable = ProductList.getInstance();
        TaobaoObserver taobaoObserver = new TaobaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        observable.addObserver(taobaoObserver);
        observable.addObserver(jingDongObserver);
        observable.addProduct("新增产品1");

    }

}
