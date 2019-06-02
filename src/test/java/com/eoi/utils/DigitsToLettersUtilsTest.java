package com.eoi.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class DigitsToLettersUtilsTest {


    /**
     * Normal 2-9 array single test
     */
    @Test
    public void testConvertDigitsToLettersForSingleDigits() {

        Integer[] argArray = new Integer[]{2};
        System.out.println("input: arr[] = {" + StringUtils.join(argArray,",")+"}");

        try {
            String s = DigitsToLettersUtils.convertDigitsToLetters(argArray);
            System.out.println("output: " + s);
            Assert.assertEquals("a b c", s);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * Normal 2-9 Array Multiple Tests
     */
    @Test
    public void testConvertDigitsToLettersForMultipleDigits() {

        Integer[] argArray = new Integer[]{3, 4,5};
        System.out.println("input: arr[] = {" + StringUtils.join(argArray,",")+"}");

        try {
            String s = DigitsToLettersUtils.convertDigitsToLetters(argArray);
            System.out.println("output: " + s);
            Assert.assertEquals("dgj dgk dgl dhj dhk dhl dij dik dil egj egk egl ehj ehk ehl eij eik eil fgj fgk fgl fhj fhk fhl fij fik fil", s);
        } catch (Exception e) {
            Assert.fail();
        }
    }


    /**
     * input 0 or 1 Test
     */
    @Test
    public void testConvertDigitsToLettersForParamZeroAndOneDigits() {
        Integer[] argArray = new Integer[]{0,1};
        System.out.println("input: arr[] = {" + StringUtils.join(argArray,",")+"}");
        try {
            String s = DigitsToLettersUtils.convertDigitsToLetters(argArray);
            System.out.println("output: " + s);
            Assert.assertEquals("", s);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * Normal 2-9 array single test
     */
    @Test
    public void testConvertDigitsToLettersForCludingZero() {

        Integer[] argArray = new Integer[]{2,0};
        System.out.println("input: arr[] = {" + StringUtils.join(argArray,",")+"}");

        try {
            String s = DigitsToLettersUtils.convertDigitsToLetters(argArray);
            System.out.println("output: " + s);
            Assert.assertEquals("a b c", s);
        } catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * input 10 or 99 Test
     */
    @Test
    public void testConvertDigitsToLettersForTwoDigitNumber() {
        Integer[] argArray = new Integer[]{99,10};
        System.out.println("input: arr[] = {" + StringUtils.join(argArray,",")+"}");
        try {
            String s = DigitsToLettersUtils.convertDigitsToLetters(argArray);
            System.out.println("output: " + s);
            Assert.assertEquals("ww wx wy wz xw xx xy xz yw yx yy yz zw zx zy zz", s);
        } catch (Exception e) {
            Assert.fail();
        }
    }


    /**
     * input param greater than 99,and throw Exception
     */
    @Test
    public void testConvertDigitsToLettersForGreaterThanUsing() {
        Integer[] argArray = new Integer[]{100};
        System.out.println("input: arr[] = {" + StringUtils.join(argArray,",")+"}");
        try {
            DigitsToLettersUtils.convertDigitsToLetters(argArray);
            Assert.fail();
        } catch (Exception e) {
            System.out.println("output: " + e.getMessage());
            Assert.assertEquals("error：The input parameter is null or the value is greater than 99",e.getMessage());
        }
    }





}
