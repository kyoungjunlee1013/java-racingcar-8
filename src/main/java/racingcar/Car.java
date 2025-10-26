package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    public void move(int randomNumber) {

        if(randomNumber >= 4){
            this.position++;
        }
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
