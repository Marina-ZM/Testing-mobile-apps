package com.techyourchance.unittestingfundamentals.exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NegativeNumberValidatorTest {

    private NegativeNumberValidator SUT; 

    @BeforeEach
    void setUp() {
        SUT = new NegativeNumberValidator();
    }

    @Test
    void isNegative_positiveNumber_falseReturned() {
        int positiveNumber = 5;
        boolean result = SUT.isNegative(positiveNumber);
        Assertions.assertFalse(result, "Позитивне число не повинно вважатися негативним");
    }

    @Test
    void isNegative_zero_falseReturned() {
        int zero = 0;
        boolean result = SUT.isNegative(zero);
        Assertions.assertFalse(result, "Нуль не повинен вважатися негативним");
    }

    @Test
    void isNegative_negativeNumber_trueReturned() {
        int negativeNumber = -10;
        boolean result = SUT.isNegative(negativeNumber);
        Assertions.assertTrue(result, "Негативне число повинно вважатися негативним");
    }
}