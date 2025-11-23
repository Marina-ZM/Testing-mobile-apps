package com.techyourchance.unittestingfundamentals.exercise3;

import com.techyourchance.unittestingfundamentals.example3.Interval; 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalsAdjacencyDetectorTest {

    private IntervalsAdjacencyDetector SUT; 

    @BeforeEach
    void setUp() {
        SUT = new IntervalsAdjacencyDetector();
    }

    @Test
    void isAdjacent_interval1_before_interval2_adjacentTrueReturned() {
        Interval interval1 = new Interval(0, 5);
        Interval interval2 = new Interval(5, 10);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assertions.assertTrue(result, "Має бути суміжним (I1.end == I2.start)");
    }

    @Test
    void isAdjacent_interval2_before_interval1_adjacentTrueReturned() {
        Interval interval1 = new Interval(5, 10);
        Interval interval2 = new Interval(0, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assertions.assertTrue(result, "Має бути суміжним (I2.end == I1.start)");
    }

    @Test
    void isAdjacent_intervalsOverlap_falseReturned() {
        Interval interval1 = new Interval(0, 5);
        Interval interval2 = new Interval(4, 10);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assertions.assertFalse(result, "Перекриття не є суміжністю");
    }

    @Test
    void isAdjacent_intervalsWithGap_falseReturned() {
        Interval interval1 = new Interval(0, 5);
        Interval interval2 = new Interval(6, 10);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assertions.assertFalse(result, "Розділені інтервали не є суміжними");
    }

    @Test
    void isAdjacent_intervalsAreIdentical_falseReturned() {
        Interval interval1 = new Interval(0, 5);
        Interval interval2 = new Interval(0, 5);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assertions.assertFalse(result, "Однакові інтервали не повинні вважатися суміжними (це перекриття)");
    }
    
    @Test
    void isAdjacent_interval2_containedIn_interval1_falseReturned() {
        Interval interval1 = new Interval(0, 10);
        Interval interval2 = new Interval(2, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        Assertions.assertFalse(result, "Внутрішнє перекриття не є суміжністю");
    }
}