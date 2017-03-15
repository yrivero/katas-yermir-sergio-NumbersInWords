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
                    new String[] {"zero dollars", "one dollar", "two dollars", "three dollars", "four dollars",
                            "five dollars", "six dollars", "seven dollars", "eight dollars", "nine dollars"}
                },
                {
                        "givenTwoDigitNumberShouldReturnItsDescription",
                        new String[] {"10$", "11$", "12$", "13$", "14$", "15$", "16$", "17$", "18$", "19$"},
                        new String[] {
                                "ten dollars", "eleven dollars", "twelve dollars", "thirteen dollars", "fourteen dollars",
                                "fifteen dollars", "sixteen dollars", "seventeen dollars", "eighteen dollars", "nineteen dollars"}
                },
                {
                        "givenANumberInTheTensExceptTenShouldReturnItsDescription",
                        new String[] {"20$", "30$", "40$", "50$", "60$", "70$", "80$", "90$"},
                        new String[] {
                                "twenty dollars", "thirty dollars", "forty dollars", "fifty dollars", "sixty dollars",
                                "seventy dollars", "eighty dollars", "ninety dollars"}
                },
                {
                        "givenACompositeTwoDigitNumberShouldReturnItsDescription",
                        new String[] {"21$", "32$", "43$", "54$", "65$", "76$", "87$", "98$", "29$"},
                        new String[] {
                                "twenty one dollars", "thirty two dollars", "forty three dollars", "fifty four dollars", "sixty five dollars",
                                "seventy six dollars", "eighty seven dollars", "ninety eight dollars", "twenty nine dollars"}
                },
                {
                        "givenANumberInTheHundredsItShouldReturnItsDescription",
                        new String[] {"100$", "200$", "300$", "400$", "500$", "600$", "700$", "800$", "900$"},
                        new String[] {
                                "one hundred dollars", "two hundred dollars", "three hundred dollars", "four hundred dollars", "five hundred dollars",
                                "six hundred dollars", "seven hundred dollars", "eight hundred dollars", "nine hundred dollars"}
                },
                {
                        "givenAThreeDigitsNumberItShouldReturnItsDescription",
                        new String[] {"101$", "211$", "350$", "499$"},
                        new String[] {
                                "one hundred and one dollars", "two hundred and eleven dollars", "three hundred and fifty dollars", "four hundred and ninety nine dollars"}
                },
                {
                        "givenAFourDigitsNumberItShouldReturnItsDescription",
                        new String[] {"1101$", "2211$", "3350$", "4499$", "5505$", "6611$", "7450$", "8299$", "9399$"},
                        new String[] {
                                "one thousand one hundred and one dollars",
                                "two thousand two hundred and eleven dollars",
                                "three thousand three hundred and fifty dollars",
                                "four thousand four hundred and ninety nine dollars",
                                "five thousand five hundred and five dollars",
                                "six thousand six hundred and eleven dollars",
                                "seven thousand four hundred and fifty dollars",
                                "eight thousand two hundred and ninety nine dollars",
                                "nine thousand three hundred and ninety nine dollars"
                        }
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
