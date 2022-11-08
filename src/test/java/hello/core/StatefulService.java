package hello.core;

public class StatefulService {
    private int price; //stateful 필드

    public void order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        this.price = price; //여기서 문제 발생!
    }

    public int getPrice(){
        return price;
    }
}
