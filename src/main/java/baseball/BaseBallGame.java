package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGame {

    private int comNum;
    private int fir;
    private int sec;
    private int trd;

    private int strike;
    private int ball;

    public BaseBallGame() {
        makeNum();
        comNum = fir + sec * 10 + trd * 100;
        System.out.println(comNum);
    }

    public void playGame(int user) {
        checkStrike(user);
        checkBall(user);
        printResult();
    }

    private void printResult() {
        if(ball > 0) System.out.print(ball + "ball ");
        if(strike > 0) System.out.print(strike + "strike");
        if(ball == 0 && strike ==0) System.out.println("nothing");
    }

    private void checkStrike(int user) {
        strike = 0;

        int a = user % 10;
        user /= 10;
        int b = user % 10;
        int c = user / 10;

        if (a == fir) strike++;
        if (b == sec) strike++;
        if (c == trd) strike++;
    }

    private void checkBall(int user) {
        ball = 0;
        int a = user % 10;
        user /= 10;
        int b = user % 10;
        int c = user / 10;

        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);

        if (set.contains(fir)) ball++;
        if (set.contains(sec)) ball++;
        if (set.contains(trd)) ball++;
        ball -= strike;
    }


    private void makeNum() {
        int fir = randomNum();
        int sec = randomNum();
        int trd = randomNum();

        while (fir == sec) {
            sec = randomNum();
        }
        while (trd == fir || trd == sec) {
            trd = randomNum();
        }

        this.fir = fir;
        this.sec = sec;
        this.trd = trd;
    }

    private int randomNum() {
        return (int)(Math.random() * 9) + 1;
    }

    public int getComNum() {
        return comNum;
    }
}
