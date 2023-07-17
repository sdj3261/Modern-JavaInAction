package FunctionalInterface;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarMain {
    public static void main(String[] args) {
        Car car1 = new Car() {
            @Override
            public String drive(int speed) {
                return "자동차가 " + speed + "km/h 로 움직입니다.";
            }
        };

        Car car2 = (speed) -> "트럭이 " + speed + "km/m로 움직입니다.";
        System.out.println(car1.drive(10));
        System.out.println(car2.drive(100));

        List<Integer> values = Arrays.asList(7,5,122,23,67,40,30);

        List<Integer> result = values.stream().filter(number -> number < 50)
                .distinct().sorted(Integer::compare).collect(Collectors.toList());
        //필터.. // 중복제거 .. /소팅 .. / 스트림 연산 결과 toList 메서드로 합쳐서 return ..
    }
}
