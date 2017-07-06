package com.moriahtown.pefam.utils;

/**
 * 주민등록번호 유효성 검사
 * Created by Hanson on 2017-07-04.
 */
public class RRNValidator {
    private final static int[] LOGIC_NUM = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};

    public final static boolean isValid(String regNum) {

        if (!isNumeric(regNum) || regNum.length() != 13)
            return false;

        int sum = 0;
        int j = -1;
        for (int i = 0; i < 12; i++) {
            j = Character.getNumericValue(regNum.charAt(i));
            sum += j * LOGIC_NUM[i];
        }
        int checkNum = sum % 11 == 0 ? 1 : 11 - (sum % 11);
        return (checkNum == Character.getNumericValue(regNum.charAt(regNum.length()-1)));
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
