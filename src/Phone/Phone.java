package Phone;

public abstract class Phone {
    String owner;

    public Phone(String owner) {
        this.owner = owner;
    }

    void turnOn() {
        System.out.println("폰 전월을 킵니다.");
    }

    void turnOff() {
        System.out.println("폰 전원을 끕니다.");
    }
}
