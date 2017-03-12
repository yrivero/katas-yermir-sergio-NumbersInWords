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
        // Remove dollar sign
        textOfNumber = textOfNumber.replace("$", "");
        // Remove whitespaces left and right
        textOfNumber = textOfNumber.trim();
        // Remove the thousands separator (comma)
        textOfNumber = textOfNumber.replace(",", "");
        // Parse it as double
        double plainNumber = Double.valueOf(textOfNumber);

        return plainNumber;
    }

    private String formatNumber(double plainNumber) {
        String formattedNumber = formatOnlyNumber(plainNumber);
        String dollarsSuffix = formatDollarsSuffix(plainNumber);

        return formattedNumber + " " + dollarsSuffix;

    }

    private String formatDollarsSuffix(double plainNumber) {
        if (plainNumber == 1.0D) {
            return "dollar";
        }
        else {
            return "dollars";
        }
    }

    private String formatOnlyNumber(double plainNumber) {
        Double number = new Double(plainNumber);

        switch (number.intValue()) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            default:
                throw new UnsupportedOperationException("Not implemented yet!");
        }

    }

}
