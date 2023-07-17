package Modernch2;

import java.util.List;

public class ch2Quiz1 {

    public static void prettyPrintApple(List<Apple> inventory, ch2Quiz1Interface p) {
        for(Apple apple : inventory) {
            String output = p.predicatePrintApple(apple);
            System.out.println(output);
        }
    }

    public static class ApplePrintFormatPredicate implements ch2Quiz1Interface {

        @Override
        public String predicatePrintApple(Apple apple) {
            switch (apple.getColor()) {
                case "GREEN":
                    return "초록색사과입니다.";
                case "RED":
                    return "빨간사과입니다.";
                default :
                    return "검은사과입니다.";
            }
        }
    }
    public static class AppleWeightFormatPredicate implements ch2Quiz1Interface {

        @Override
        public String predicatePrintApple(Apple apple) {
            if(apple.getWeight() > 10) {
                return "무거운 사과 입니다.";
            }
            return "가벼운 사과 입니다.";
        }
    }
}
