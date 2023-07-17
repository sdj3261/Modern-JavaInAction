package ModernCh3;

import Modernch2.Apple;

import java.util.Comparator;

public class Lambda {
    //람다표현식은 메서드로 전달할 수 있는 익명함수를 단순화한 것이라고 볼 수 있다.
    //보통 메서드와 달리 이름이 없고 특정 클래스에 종속되지 않으며 표현식을 변수로 저장하거나 인수로 전달 가능하다. 또한 간결해진다 익명클래스보다
    public static void main(String[] args) {
        Comparator<Apple> byWeight = (Apple a1, Apple a2) ->  a1.getWeight().compareTo(a2.getWeight());
    }
    //함수형 인터페이스는 오직 추상메서드가 하나인 인터페이스

}
