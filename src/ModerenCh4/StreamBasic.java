package ModerenCh4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {
    public static void main(String[] args) {
        List<Dish> lowCaloriesDish = new ArrayList<>();
        for(Dish dish : Dish.menu) {
            if(dish.getCalories() <= 400) {
                lowCaloriesDish.add(dish);
            }
        }
        Collections.sort(lowCaloriesDish, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for(Dish dish : lowCaloriesDish) {
            lowCaloricDishesName.add(dish.getName());
        }

        //400보다 칼로리 작은 음식 추출 후 칼로리 순서로 정렬 후 (작은 순서대로 이름을 뽑는다) -> 매우 많은 코드 자바8로 바꿔보자
        List<String> lowCaloricDishesName2 = Dish.menu.stream().filter(data -> data.getCalories() <= 400).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
                .collect(toList());

        //병렬 처리로 바꿔보자
        List<String> lowCaloricDishesName3 = Dish.menu.parallelStream().filter(data -> data.getCalories() <= 400).sorted(Comparator.comparing(Dish::getCalories)).map(Dish::getName)
                .collect(toList());
    }
}
