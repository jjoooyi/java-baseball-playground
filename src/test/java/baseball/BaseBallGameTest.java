package baseball;

import org.junit.jupiter.api.Test;

class BaseBallGameTest {

    @Test
    void playGame() {
        BaseBallGame game = new BaseBallGame();
        game.playGame(123);
    }
}