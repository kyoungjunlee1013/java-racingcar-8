package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    public static void run() {
        List<Car> cars = setupCars();

        int attemptCount = getAttemptCount();

        runRacing(cars, attemptCount);

        printWinners(cars);
    }

    private static List<Car> setupCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        String[] carName = input.split(",");

        List<Car> cars = new ArrayList<>();

        for (String name : carName) {
            String trimmedName = name.trim();
            validateCarName(trimmedName);
            cars.add(new Car(trimmedName));
        }

        return cars;
    }

    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    private static int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        return parseAndValidateAttemptCount(input);
    }

    private static int parseAndValidateAttemptCount(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return count;
    }

    private static void runRacing(List<Car> cars, int attemptCount) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            MoveCars(cars);
            printCurrentPositions(cars);
        }
    }

    private static void MoveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    private static void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + convertPositionToHyphens(car.getPosition()));
        }
    }

    private static String convertPositionToHyphens(int position) {
        StringBuilder hyphens = new StringBuilder();
        for (int i = 0; i < position; i++) {
            hyphens.append("-");
        }
        return hyphens.toString();
    }

    private static void printWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        List<String> winnerNames = findWinnerNames(cars, maxPosition);

        String winnersString = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnersString);
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private static List<String> findWinnerNames(List<Car> cars, int maxPosition) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
