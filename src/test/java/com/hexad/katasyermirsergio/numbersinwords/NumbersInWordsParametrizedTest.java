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
                    "givenNumberOneShouldReturnOneDollar",
                    "1$",
                    "one dollar"
                },
                {
                    "givenNumberTwoShouldReturnTwoDollars",
                    "2$",
                    "two dollars"
                },
                {
                        "givenNumber10ShouldReturnTenDollars",
                        "10$",
                        "ten dollars"
                }
        };
    }

    @Parameterized.Parameter(0)
    public String testName;
    @Parameterized.Parameter(1)
    public String textOfNumber;
    @Parameterized.Parameter(2)
    public String expectedWordsOfNumber;

    @Test
    public void test() throws Exception {
        NumberInWords numberInWords = new NumberInWords();
        String actualWordsOfTheNumber = numberInWords.convertNumber(textOfNumber);
        assertEquals(testName, expectedWordsOfNumber, actualWordsOfTheNumber);
    }


}
