package Interface;

public class Television implements RemoteControl,Shape{

    @Override
    public String shape() {
        return "square";
    }

    @Override
    public String color() {
        return "black";
    }

    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV를 끕니다.");
    }
}
