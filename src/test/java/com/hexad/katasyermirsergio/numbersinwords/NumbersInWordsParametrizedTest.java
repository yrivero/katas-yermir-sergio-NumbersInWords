package com.hexad.katasyermirsergio.numbersinwords;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hexad GmbH on 12/03/2017.
 */
@RunWith(Parameterized.class)
public class NumbersInWordsParametrizedTest {

    @Parameterized.Parameters(name="{0}")
    public static Object[][] testData(){
        return new Object[][]{
                {
                    "givenSingleDigitNumberShouldReturnItsDescription",
                    new String[] {"0$", "1$", "2$", "3$", "4$", "5$", "6$", "7$", "8$", "9$"},
                    new String[] {"zero dollar", "one dollar", "two dollars", "three dollars", "four dollars", "five dollars", "six dollars", "seven dollars", "eight dollars", "nine dollars"}
                }
        };
    }

    @Parameterized.Parameter(0)
    public String testName;
    @Parameterized.Parameter(1)
    public String[] textOfNumber;
    @Parameterized.Parameter(2)
    public String[] expectedWordsOfNumber;

    @Test
    public void test() throws Exception {
        for (int i=0; i<textOfNumber.length; i++) {
            testSingleNumber(textOfNumber[i], expectedWordsOfNumber[i]);
        }
    }

    private void testSingleNumber(String textOfNumber, String expectedWordsOfNumber) {
        NumberInWords numberInWords = new NumberInWords();
        String actualWordsOfTheNumber = numberInWords.convertNumber(textOfNumber);
        assertEquals(testName, expectedWordsOfNumber, actualWordsOfTheNumber);
    }


}
