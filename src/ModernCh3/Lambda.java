package ModernCh3;

import Modernch2.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    private static List<Apple> inventory;
    public static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
    //람다표현식은 메서드로 전달할 수 있는 익명함수를 단순화한 것이라고 볼 수 있다.
    //보통 메서드와 달리 이름이 없고 특정 클래스에 종속되지 않으며 표현식을 변수로 저장하거나 인수로 전달 가능하다. 또한 간결해진다 익명클래스보다
    public static void main(String[] args) {
        inventory = new ArrayList<>();
        Apple a1 = new Apple("GREEN", 50);
        Apple a2 = new Apple("RED", 30);
        Apple a3 = new Apple("BLACK", 70);

        inventory.add(a1);
        inventory.add(a2);
        inventory.add(a3);

        //첫번째 클래스를 따로 나누는 방법
        inventory.sort(new AppleComparator());
        //익명 클래스 활용 방법
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        //람다 표현식 사용
        inventory.sort((Apple a5, Apple a6) -> a5.getWeight().compareTo(a6.getWeight()));

    }
    //함수형 인터페이스는 오직 추상메서드가 하나인 인터페이스

}
