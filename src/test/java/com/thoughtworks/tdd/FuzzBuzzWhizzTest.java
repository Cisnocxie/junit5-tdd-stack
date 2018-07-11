package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FuzzBuzzWhizzTest {
    @Test
    public void should_return_1_when_inputs_1() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 1;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("1"));
    }
    @Test
    public void should_return_2_when_inputs_2() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 2;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("2"));
    }
    @Test
    public void should_return_Fizz_when_inputs_3() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 3;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Fizz"));
    }

    @Test
    public void should_return_Fizz_when_inputs_6333() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 6333;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Fizz"));
    }

    @Test
    public void should_return_Buzz_when_inputs_5() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 5;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Buzz"));
    }
    @Test
    public void should_return_Fizz_when_inputs_235() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 235;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Fizz"));
    }

    @Test
    public void should_return_Whizz_when_inputs_7() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 7;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Whizz"));
    }

    @Test
    public void should_return_Whizz_when_inputs_14() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 14;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Whizz"));
    }
    @Test
    public void should_return_FizzBuzz_when_inputs_15() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 15;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("FizzBuzz"));
    }

    @Test
    public void should_return_FizzWhizz_when_inputs_21() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 21;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("FizzWhizz"));
    }

    @Test
    public void should_return_Fizz_when_inputs_35() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 35;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("Fizz"));
    }

    @Test
    public void should_return_FizzBuzzWhizz_when_inputs_105() {
        //given
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int number = 105;

        //when
        String result = fizzBuzzWhizz.getFizzBuzz(number);

        //then
        assertThat(result, is("FizzBuzzWhizz"));
    }
}
