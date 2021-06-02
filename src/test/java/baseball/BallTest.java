package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    /*
    ---
    com / user
    123, 456 -> nothing
    123, 245 -> 1ball
    123, 145 -> 1strike

    PlayResult result = BaseBall.play(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

    ---
    com / user
    123 / 1 4 -> nothing
    123 / 1 2 -> ball
    123 / 1 1 -> strike

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
