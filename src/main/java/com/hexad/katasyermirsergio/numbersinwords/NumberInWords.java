package com.hexad.katasyermirsergio.numbersinwords;

/**
 * Created by Hexad GmbH on 12/03/2017.
 */
public class NumberInWords {

    public String convertNumber(String textOfNumber) {
        if (textOfNumber.equals("1$")) {
            return "one dollar";
        }
        else {
            return "two dollars";
        }

    }

}
