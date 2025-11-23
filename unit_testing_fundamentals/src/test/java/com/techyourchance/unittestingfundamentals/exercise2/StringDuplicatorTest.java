ppackage com.techyourchance.unittestingfundamentals.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringDuplicatorTest {

    private StringDuplicator SUT; 

    @BeforeEach
    void setUp() {
        SUT = new StringDuplicator();
    }

    @Test
    void duplicate_regularString_stringIsDuplicated() {
        String input = "test";
        String expected = "testtest"; 
        String actual = SUT.duplicate(input);
        Assertions.assertEquals(expected, actual, "Рядок має бути подвоєний, а не потроєний.");
    }
    
    @Test
    void duplicate_emptyString_emptyStringReturned() {
        String input = "";
        String expected = "";
        String actual = SUT.duplicate(input);
        Assertions.assertEquals(expected, actual, "Дублювання порожнього рядка має дати порожній рядок.");
    }
    
    @Test
    void duplicate_singleCharacterString_duplicatedStringReturned() {
        String input = "A";
        String expected = "AA"; 
        String actual = SUT.duplicate(input);
        Assertions.assertEquals(expected, actual, "Рядок з одним символом має бути подвоєний.");
    }
}