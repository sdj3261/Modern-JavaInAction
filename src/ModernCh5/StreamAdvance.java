package ModernCh5;

import ModerenCh4.Dish;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class StreamAdvance {
    //take while 과 drop While을 통해 이미 정렬되어있는 상황에서 필터 대신 성능 개선 가능하다

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Dish> lowCaloriesDish = new ArrayList<>();
        if(Dish.menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is vegetarain friendly 적어도 한 요소가 vegeterian 인지 확인");
        }
        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));

        //reduce 반복된 패턴 추상화
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        //identity : 초기값() 과 두 요소를 조합해서 새로운 값을 만드는 binaryOperator<T>
        int sum = numbers.stream().reduce(0,(a,b) -> a + b);
        System.out.println("sum  : " + sum);
        int product = numbers.stream().reduce(1,(a,b) -> a*b);
        //스트림의 요리 개수 구하기
        int DishCount = menu.stream().map(dish -> 1).reduce(1,(a,b) -> a + b);
        System.out.println(DishCount);
    }
}
