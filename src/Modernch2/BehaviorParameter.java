        package Modernch2;

        import java.util.ArrayList;
        import java.util.List;

        //변화하는 요구사항에 대응하기

        public class BehaviorParameter {



            //기존 방식
            public static List<Apple> filterGreenApples(List<Apple> inventory) {
                List<Apple> ret = new ArrayList<>();
                for(Apple apple : ret) {
                    if(Color.GREEN.equals(apple.getColor())) {
                        ret.add(apple);
                    }
                }
                return ret;
            }

            //모든 색상에대해 필터링 해줘 요구사항
            public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
                List<Apple> ret = new ArrayList<>();
                for(Apple apple : ret) {
                    if(apple.getColor().equals(color.toString())) {
                        ret.add(apple);
                    }
                }
                return ret;
            }
            //List<Apple> = filterApplesByColor(inventory, green) // 초록사과

            //모든 색상 + 무게에 대해 필터링 해줄래? 플래그도 걸어줘
            public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
                List<Apple> ret = new ArrayList<>();
                for(Apple apple : ret) {
                    if(flag && apple.getColor().equals(color.toString()) || !flag && apple.getWeight() > weight) {
                        ret.add(apple);
                    }
                }
                return ret;
            }
            //List<Apple> = filterApplesByColor(inventory, green, 0, true) // 초록사과 매우 이상한 코드
            // 거대한 파라미터 필터 메서드를 구현해야하는 문제가 생김.. -> 동작 파라미터화를 사용하자
            // Predicate(선택조건 결정 인터페이스 true,false 반환)
            //전략 패턴(한개의 알고리즘 패밀리와 그에 속한 다양한 전략을 통해..)

            public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
                List<Apple> ret = new ArrayList<>();
                for(Apple apple : ret) {
                    if(p.test(apple)) {
                        ret.add(apple);
                    }
                }
                return ret;
            }

            public static class AppleHeavyWeightPredicate implements ApplePredicate {
                @Override
                public boolean test(Apple apple) {
                    return apple.getWeight() > 150;
                }
            }
            public static class AppleColorPredicate implements ApplePredicate {
                @Override
                public boolean test(Apple apple) {
                    return apple.getColor().equals("GREEN");
                }
            }

            //지금도 많이 복잡하다.. -> 익명 클래스 기법을 통해 클래스 선언과 인스턴스 화를 동시에 수행하자
            //익명 클래스는 자바의 지역 클래스(local class) 와 비슷한 개념 이름이 없는 익명의 클래스다 (인스턴스화와 클래스선언을 동시에)

            public static List<Apple> filterApplesAnymousClass(List<Apple> inventory, ApplePredicate p) {
                List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return "RED".equals(apple.getColor());
                    }
                });
                return redApples;
            }
            // 근데 코드가 너무 난잡하고 장황해.. 결국은 객체를 만들고 명시적으로 메서드를 파라미터에 구현해야하거든..

            public static List<Apple> filterApplesLambda(List<Apple> inventory) {
                List<Apple> ret = filterApples(inventory, (Apple apple) -> "RED".equals(apple.getColor()));
                return ret;
            }

            // 필터에 여러개의 조건을 걸고 싶어

            public static List<Apple> filterApplesLambda2(List<Apple> inventory) {

                List<Apple> ret = filterApples(inventory, Apple::isRedAndHeavy);
                return ret;
            }

            //다양한 리스트에 필터 메서드를 적용시킬 수 있게 제네릭으로 추상화하자
            public interface Predicate<T> {
                boolean test(T t);
            }
            public static <T> List<T> filter(List<T> list, Predicate<T> p) {
                List<T> ret = new ArrayList<>();
                for(T e : list) {
                    if(p.test(e)) {
                        ret.add(e);
                    }
                }
                return ret;
            }
            public static void filterApplesLambda(List<Apple> inventory, List<Integer> numbers) {
                List<Apple> redApples = filter(inventory, (Apple apple) -> "RED".equals(apple.getColor()));
                List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 == 0);
            }
        }
 