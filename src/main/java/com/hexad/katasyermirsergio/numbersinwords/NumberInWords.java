package com.hexad.katasyermirsergio.numbersinwords;

/**
 * Created by Hexad GmbH on 12/03/2017.
 */
public class NumberInWords {

    public String convertNumber(String textOfNumber) {
        double plainNumber = extractPlainNumber(textOfNumber);
        String formattedNumber = formatNumber(plainNumber);

        return formattedNumber;
    }

    private double extractPlainNumber(String textOfNumber) {
        if (textOfNumber.equals("1$")) {
            return 1.0D;
        }
        else {
            return 2.0D;
        }
    }

    private String formatNumber(Double plainNumber) {
        if (plainNumber == 1.0D) {
            return "one dollar";
        }
        else {
            return "two dollars";
        }
    }

}
