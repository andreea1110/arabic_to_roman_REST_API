package com.adobe.interview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class NumberConverterTest {

    NumberConverter converter;

    @BeforeEach
    public void setup() {
        converter = new NumberConverter();
    }

    @Test
    public void testArabicToRoman_withinRange_41_49(){

      String[] roman_41_49 = {"XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII","XLIX"};
      
      String[] result = converter.arabicToRoman(41, 49);
   
      assertArrayEquals(roman_41_49, result);
    }

    @Test
    public void testArabicToRoman_withinRange_1_100(){

      String[] roman_1_100 = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
      
      String[] result = converter.arabicToRoman(1, 100);
   
      assertArrayEquals(roman_1_100, result);
    }
}
