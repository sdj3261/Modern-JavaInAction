package Interface;

import java.rmi.Remote;

public class RemoteControlExample {
    public static void main(String[] args) {
        Television rc = new Television();
        rc.turnOn();
        System.out.println(rc.shape() + rc.color());
    }
}
