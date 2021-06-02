package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    /*
    ---
    com / user
    1 4, 1 4 -> strike
    1 4, 2 4 -> ball
    1 4, 2 5 -> nothing
    */
    @Test
    void strike() {
        Ball com = new Ball(1, 4);
        assertThat(com.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball com = new Ball(1, 4);
        assertThat(com.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball com = new Ball(1, 4);
//        BallStatus status = com.play(new Ball(2, 5));
//        assertThat(status).isEqualTo(BallStatus.NOTHING);
        assertThat(com.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }

}
