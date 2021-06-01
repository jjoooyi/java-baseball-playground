package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CalculatorTest {

    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @AfterEach
    void tearDown() {
        cal = null;
    }

    @Test
    void calc() {
        Assertions.assertThat(cal.calc("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    void test() {
        Random ran = new Random();
        System.out.println(ran.nextInt(10));
    }

}
