package com.eoi.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class DigitsToLettersUtils {

    /**
     * Letters corresponding to numbers 0-9
     */
    private static final Map<Integer, List<String>> arrayMap = new HashMap() {
        {
            put(2, Arrays.asList("a", "b", "c"));
            put(3, Arrays.asList("d", "e", "f"));
            put(4, Arrays.asList("g", "h", "i"));
            put(5, Arrays.asList("j", "k", "l"));
            put(6, Arrays.asList("m", "n", "o"));
            put(7, Arrays.asList("p", "q", "r", "s"));
            put(8, Arrays.asList("t", "u", "v"));
            put(9, Arrays.asList("w", "x", "y", "z"));
        }

    };

    /**
     * converting the digits into letters
     *
     * @param args
     * @return
     */
    public static String convertDigitsToLetters(Integer[] args) throws Exception {
        List<Integer> list = Arrays.asList(args);
        /**
         * The input parameter must not be null or greater than 99, otherwise an exception is thrown.
         */
        List<Integer> collect = list.stream().filter(i -> i < 100).collect(Collectors.toList());
        if (collect == null || collect.size() != args.length) {
            throw new Exception("error：The input parameter is null or the value is greater than 99");
        }

        List<String> stringList = convert(collect);

        return stringList == null ? "" : StringUtils.join(stringList, " ");
    }

    /**
     * Converting 0-99 digits into Letters
     *
     * @param args
     * @return
     */
    private static List<String> convert(List<Integer> args) {

        final List<List<String>> arrays = new ArrayList<List<String>>();
        List<String> strings = null;

        /**
         * Get the corresponding letters according to the input value，return Two-dimensional array
         */
        for (Integer i : args) {
            if (i < 10) {
                strings = arrayMap.get(i);
            } else {
                strings = convertMutiDigitsToLetters(i);
            }
            if (strings != null) {
                arrays.add(strings);
            }
        }

        if (arrays.size() == 0) {
            return null;
        }

        /**
         *Two-dimensional array field merge, returning list object
         */
        List<String> list = arrays.get(0);
        for (int i = 1; i < arrays.size(); i++) {
            list = mergingArray(list, arrays.get(i));
        }

        return list;
    }


    /**
     * @param in
     * @return
     */
    private static List<String> convertMutiDigitsToLetters(Integer in) {

        String value = String.valueOf(in);
        List<Integer> args = new ArrayList<Integer>();
        String substring = value.substring(0, 1);
        String substring2 = value.substring(1, 2);
        args.add(Integer.valueOf(substring));
        args.add(Integer.valueOf(substring2));
        return convert(args);
    }

    /**
     * Two-dimensional array field merge, returning list object
     *
     * @param source
     * @param target
     * @return List
     */
    private static List<String> mergingArray(List<String> source, List<String> target) {
        List<String> resultList = new ArrayList<String>();
        for (String souStr : source) {
            for (String targStr : target) {
                resultList.add(souStr + targStr);
            }
        }
        return resultList;
    }

}
