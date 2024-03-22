package com.youngzy.kim.roman;

import org.junit.Test;

import static com.youngzy.kim.roman.RomanNumeralParser.INVALID_ROMAN_NUMERAL;
import static com.youngzy.kim.roman.RomanNumeralParser.parse;
import static org.junit.Assert.assertEquals;

/**
 * @author youngzy
 * @since 2022-10-25
 */
public class RomanNumeralParserTest {

    @Test
    public void testParse_roman_success() {
        assertEquals(42, parse("XLII"));
    }

    @Test
    public void testParse_roman_fail() {
        String errorMsg = null;
        try {
            parse("FOO");
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        assertEquals(INVALID_ROMAN_NUMERAL, errorMsg);
    }

    @Test
    public void testParse_arabic_success() {
        assertEquals("XLII", parse(42));
    }

    @Test
    public void testParse_arabic_fail() {
        String errorMsg = null;
        try {
            parse(4000);
        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        assertEquals(RomanNumeral.NUMERAL_MUST_BE_3999_OR_LESS, errorMsg);
    }
}
