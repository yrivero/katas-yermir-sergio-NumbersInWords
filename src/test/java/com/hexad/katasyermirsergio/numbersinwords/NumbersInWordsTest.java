package com.hexad.katasyermirsergio.numbersinwords;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Hexad GmbH on 12/03/2017.
 */
public class NumbersInWordsTest {

    @Test
    public void givenNumberOneShouldReturnOneDollar() throws Exception {
        NumberInWords numberInWords = new NumberInWords();
        String wordsOfTheNumber = numberInWords.convertNumber("1$");
        assertEquals("one dollar", wordsOfTheNumber);
    }

    @Test
    public void givenNumberTwoShouldReturnTwoDollars() throws Exception {
        NumberInWords numberInWords = new NumberInWords();
        String wordsOfTheNumber = numberInWords.convertNumber("2$");
        assertEquals("two dollars", wordsOfTheNumber);
    }
}
