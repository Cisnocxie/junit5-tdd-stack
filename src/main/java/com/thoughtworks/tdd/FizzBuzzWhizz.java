package com.thoughtworks.tdd;

public class FizzBuzzWhizz {
    public String getFizzBuzz(int number) {
        StringBuffer str = new StringBuffer();
        if (Integer.toString(number).indexOf("3") != -1) {
            return "Fizz";
        }
        if (number % 3 == 0) {
            str.append("Fizz");
        }
        if (number % 5 == 0) {
            str.append("Buzz");
        }
        if (number % 7 == 0) {
            str.append("Whizz");
        }
        return "".equals(str.toString()) ? String.valueOf(number) : str.toString();
    }
}
