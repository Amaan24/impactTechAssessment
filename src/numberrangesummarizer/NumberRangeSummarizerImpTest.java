package numberrangesummarizer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberRangeSummarizerImpTest {

    // Test that collect method works as expected
    // Assume that test for non numeric chars and duplicates unneccessary as its handled by implementation
    @Test
    void test_collect() {
        NumberRangeSummarizerImp nrs_test = new NumberRangeSummarizerImp();
        String test_input = "1,22,5,3,6,2,7,72,8,12,13,21,23";
        assertEquals(Arrays.asList(1,2,3,5,6,7,8,12,13,21,22,23,72), nrs_test.collect(test_input));
    }


    // Test that summarizeCollection method works as expected
    // This test checks: range at beginning handled, range at end handled, 2 number ranges
    @Test
    void test_summarizeCollection() {
        NumberRangeSummarizerImp nrs_test = new NumberRangeSummarizerImp();
        String test_input = "1,22,5,3,6,74,2,7,72,8,12,13,21,23,73";
        assertEquals("1 - 3, 5 - 8, 12, 13, 21 - 23, 72 - 74", nrs_test.summarizeCollection(Arrays.asList(1,2,3,5,6,7,8,12,13,21,22,23,72,73,74)));
    }
}