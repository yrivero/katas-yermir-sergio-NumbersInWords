package com.hexad.katasyermirsergio.numbersinwords;

/**
 * Created by Hexad GmbH on 12/03/2017.
 */
public class NumberInWords {

    public String convertNumber(String textOfNumber) {
        double plainNumber = extractPlainNumber(textOfNumber);
        String formattedNumber = formatPlainNumber(plainNumber);

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

    private String formatPlainNumber(double plainNumber) {
        String formattedNumber = formatNumber(plainNumber);
        String dollarsSuffix = formatDollarsSuffix(plainNumber);

        return formattedNumber + " " + dollarsSuffix;

    }

    private String formatNumber(double plainNumber) {
        String formattedNumber;

        if (isSingleDigitNumber(plainNumber)) {
            formattedNumber = formatSingleDigitNumber(plainNumber);
        }
        else if (isSpecialTwoDigitNumber(plainNumber)) {
            formattedNumber = formatSpecialTwoDigitNumber(plainNumber);
        }
        else if (isNonSpecialTensNumber(plainNumber)) {
            formattedNumber = formatNonSpecialTensNumber(plainNumber);
        }
        else if (isCompositeTwoDigitNumber(plainNumber)) {
            formattedNumber = formatCompositeTwoDigitNumber(plainNumber);
        }
        else {
            throw new UnsupportedOperationException("Not implemented yet. And maybe never will be!");
        }

        return formattedNumber;
    }

    private boolean isSpecialTwoDigitNumber(double plainNumber) {
        return plainNumber >=10 && plainNumber <= 19;
    }

    private boolean isSingleDigitNumber(double plainNumber) {
        return plainNumber >=0 && plainNumber <= 9;
    }

    private String formatCompositeTwoDigitNumber(double plainNumber) {
        int units = Double.valueOf(plainNumber).intValue() % 10;
        int tens = Double.valueOf(plainNumber).intValue() - units;

        return formatNonSpecialTensNumber(tens) + " " + formatSingleDigitNumber(units);
    }

    private boolean isCompositeTwoDigitNumber(double plainNumber) {
        return
            (
                !(isSingleDigitNumber(plainNumber))
                &&
                !(isSpecialTwoDigitNumber(plainNumber))
                &&
                !isNonSpecialTensNumber(plainNumber)
            );
    }

    private boolean isNonSpecialTensNumber(double plainNumber) {
        return plainNumber % 10 == 0 && plainNumber != 10;
    }

    private String formatDollarsSuffix(double plainNumber) {
        if (plainNumber == 1.0D ) {
            return "dollar";
        }
        else {
            return "dollars";
        }
    }

    private String formatSingleDigitNumber(double plainNumber) {
        switch (doubleToInt(plainNumber)) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                throw new UnsupportedOperationException("Not implemented yet!");
        }

    }

    private int doubleToInt(double plainNumber) {
        return Double.valueOf(plainNumber).intValue();
    }


    private String formatSpecialTwoDigitNumber(double plainNumber) {
        switch (doubleToInt(plainNumber)) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                throw new UnsupportedOperationException("Not implemented yet!");
        }

    }


    private String formatNonSpecialTensNumber(double plainNumber) {
        switch (doubleToInt(plainNumber)) {
            case 20:
                return "twenty";
            case 30:
                return "thirty";
            case 40:
                return "forty";
            case 50:
                return "fifty";
            case 60:
                return "sixty";
            case 70:
                return "seventy";
            case 80:
                return "eighty";
            case 90:
                return "ninety";
            default:
                throw new IllegalArgumentException("Is not a non special tens number");
        }

    }
}
