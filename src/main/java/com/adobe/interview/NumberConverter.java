package com.adobe.interview;

/**
* The NumberConverter class contains a method that to converts
* a range of numbers from the Arabic system to Roman numerals.
* The upper and lower limits of the admitted range is hard-coded
* as private parameters of the class.
*
* @author  Andreea Ciuprina
*/
public class NumberConverter {
    private int minRange = 1;
    private int maxRange = 100;

    private static final int[] VALUES = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] SYMBOLS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public NumberConverter() {}

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }


    /**
   * The arabicToRoman uses an algorithm based on the additive notation property of all of the Roman numerals,
   * except a few of them (4, 9, 40, 90, 400, 900) written using subtractive notation, that are saved
   * in the SYMBOLS class variable, alongside the other basic symbols ranging from 1 to 1000.
   * @param min lower limit
   * @param max upper limit
   * @return String array of the Roman numerals in ascending order
   * @exception IllegalArgumentException if the given lower or upper limits are outside the valid range
   */
    public String[] arabicToRoman(final int min, final int max) throws IllegalArgumentException {
        if(min < this.minRange || max > this.maxRange) {
            String exceptionMessage = "Given interval exceeds valid range [" + minRange + " ," + this.maxRange + "]";
            throw new IllegalArgumentException(exceptionMessage);
        }
        int size = max - min + 1;
        String[] romanNumerals = new String[size];
        
        for(int n = min; n <= max; n++) {
            int a = n; // current Arabic number
            String r = ""; // initializing Roman numeral
            int lenNumeralSet = NumberConverter.VALUES.length;

            for (int i = lenNumeralSet-1; i >= 0; i--) {
                while(a >= NumberConverter.VALUES[i]) {
                    a -= NumberConverter.VALUES[i];
                    r += NumberConverter.SYMBOLS[i];
                }
            }
            romanNumerals[size - (max - n + 1)] = r;
        }
        return(romanNumerals);
    }
}