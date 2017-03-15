package com.hexad.katasyermirsergio.numbersinwords;

/**
 * Created by Hexad GmbH on 12/03/2017.
 */
public class NumberInWords {

    public String convertNumber(String textOfNumber) {
        double plainNumber = extractPlainNumber(textOfNumber);

        int integerPlainNumber = doubleToInt(plainNumber);
        String formattedNumber = formatPlainNumber(integerPlainNumber);

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

    private String formatPlainNumber(int integerPlainNumber) {
        String formattedNumber = formatNumber(integerPlainNumber);
        String dollarsSuffix = formatDollarsSuffix(integerPlainNumber);

        return formattedNumber + " " + dollarsSuffix;

    }

    private String formatNumber(int integerPlainNumber) {
        String formattedNumber;

        if (isSingleDigitNumber(integerPlainNumber)) {
            formattedNumber = formatSingleDigitNumber(integerPlainNumber);
        }
        else if (isSpecialTwoDigitNumber(integerPlainNumber)) {
            formattedNumber = formatSpecialTwoDigitNumber(integerPlainNumber);
        }
        else if (isNonSpecialTensNumber(integerPlainNumber)) {
            formattedNumber = formatNonSpecialTensNumber(integerPlainNumber);
        }
        else if (isCompositeTwoDigitNumber(integerPlainNumber)) {
            formattedNumber = formatCompositeTwoDigitNumber(integerPlainNumber);
        }
        else if (isHundredsNumber(integerPlainNumber)) {
            formattedNumber = formatHundredsNumber(integerPlainNumber);
        }
        else {
            throw new UnsupportedOperationException("Not implemented yet. And maybe never will be!");
        }

        return formattedNumber;
    }

    private boolean isSpecialTwoDigitNumber(int integerPlainNumber) {
        return integerPlainNumber >=10 && integerPlainNumber <= 19;
    }

    private boolean isSingleDigitNumber(int integerPlainNumber) {
        return integerPlainNumber >=0 && integerPlainNumber <= 9;
    }

    private String formatCompositeTwoDigitNumber(int integerPlainNumber) {
        int units = integerPlainNumber % 10;
        int tens = integerPlainNumber - units;

        return formatNonSpecialTensNumber(tens) + " " + formatSingleDigitNumber(units);
    }

    private boolean isCompositeTwoDigitNumber(int integerPlainNumber) {
        return
            (
                (integerPlainNumber>=0 && integerPlainNumber<100)
                &&
                !(isSingleDigitNumber(integerPlainNumber))
                &&
                !(isSpecialTwoDigitNumber(integerPlainNumber))
                &&
                !isNonSpecialTensNumber(integerPlainNumber)
            );
    }

    private boolean isNonSpecialTensNumber(int integerPlainNumber) {
        return
                (integerPlainNumber>=0 && integerPlainNumber<100)
                && integerPlainNumber % 10 == 0
                && integerPlainNumber != 10;
    }

    private String formatDollarsSuffix(int integerPlainNumber) {
        if (integerPlainNumber == 1) {
            return "dollar";
        }
        else {
            return "dollars";
        }
    }

    private String formatSingleDigitNumber(int integerPlainNumber) {
        switch (integerPlainNumber) {
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


    private String formatSpecialTwoDigitNumber(int integerPlainNumber) {
        switch (integerPlainNumber) {
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


    private String formatNonSpecialTensNumber(int integerPlainNumber) {
        switch (integerPlainNumber) {
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

    private boolean isHundredsNumber(int integerPlainNumber) {
        return (integerPlainNumber % 100 == 0);
    }

    private String formatHundredsNumber(int integerPlainNumber) {
        int hundreds = integerPlainNumber / 100;

        String hundredsInWords = formatSingleDigitNumber(hundreds);

        String number = hundredsInWords + " " + "hundred";

        return number;
    }

}
