package study;

public class Calculator {

    public int calc(String value) {
        String[] values = value.split(" ");
        int result = Integer.parseInt(values[0]);
        for(int i=2; i<values.length; i+=2)
            result = operator(values[i-1], result, Integer.parseInt(values[i]));
        return result;
    }

    private int operator(String oper, int fir, int sec) {
        if (oper.equals("+"))
            return fir + sec;
        else if (oper.equals("-"))
            return fir - sec;
        else if (oper.equals("*"))
            return fir * sec;
        else if (oper.equals("/") && sec != 0) {
            return fir / sec;
        } else {
            return 0;
        }
    }
}
