package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("무작위 값이 4 이상일 경우 자동차는 전진한다.")
    void move_When_NumberIsOver4() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(4); // 4는 전진 조건

        // then
        assertThat(car.getPosition()).isEqualTo(1);

        // when
        car.move(9); // 9도 전진 조건

        // then
        assertThat(car.getPosition()).isEqualTo(2); // 1 + 1 = 2
    }

    @Test
    @DisplayName("무작위 값이 3 이하일 경우 자동차는 멈춘다.")
    void stop_When_NumberIsUnder3() {
        // given
        Car car = new Car("pobi");

        // when
        car.move(3); // 3은 정지 조건

        // then
        assertThat(car.getPosition()).isZero(); // 0

        // when
        car.move(0); // 0도 정지 조건

        // then
        assertThat(car.getPosition()).isZero(); // 0 + 0 = 0
    }

    @Test
    @DisplayName("이름과 초기 위치 0을 올바르게 반환한다.")
    void car_HasCorrectInitialState() {
        // given
        Car car = new Car("woni");

        // when & then
        assertThat(car.getName()).isEqualTo("woni");
        assertThat(car.getPosition()).isZero();
    }
}

