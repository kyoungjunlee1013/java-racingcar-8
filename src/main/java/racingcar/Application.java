package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        List<Car> cars = setupCars();


    }
    private static List<Car> setupCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] carName = input.split(",");

        List <Car> cars = new ArrayList<>();

        for(String name : carName){
            String trimmedName = name.trim();
            validateCarName(trimmedName);
            cars.add(new Car(trimmedName));
        }

        return cars;
    }
    private static String validateCarName(String name){
        if(name.isEmpty() || name.length() >5){
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }

        return name;
    }
}
