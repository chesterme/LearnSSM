package ch02;

public class TicketTest {

    public static void main(String[] args){
        TicketHelper helper = new TicketHelper();
        helper.buildAdult("成人票");
        helper.buildChildForSeat("有座儿童票");
        helper.buildChildNoSeat("无座儿童票");
        helper.buildElderly("老人票");
        helper.buildSoldier("军用票");
        Object ticket = TicketBuilder.builder(helper);
    }

}
