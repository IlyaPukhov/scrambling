package com.ilyap.Scrambler;

import java.util.Arrays;

public final class EnhancedScrambler {
    private EnhancedScrambler() {
    }

    public static String scramble(String source) {
        int[] sourceArr = getArr(source);
        int[] result = new int[sourceArr.length];
        for (int i = 0; i < source.length(); i++) {
            if (i >= 5) {
                result[i] = sourceArr[i] ^ result[i - 4] ^ result[i - 5];
            } else if (i == 4) {
                result[i] = sourceArr[i] ^ result[i - 4];
            } else {
                result[i] = sourceArr[i];
            }
        }
        return Arrays.toString(result).replaceAll("\\[|]|,|\\s", "");
    }

    public static String descramble(String scrambled) {
        int[] scrambledArr = getArr(scrambled);
        int[] result = new int[scrambledArr.length];
        for (int i = 0; i < scrambled.length(); i++) {
            if (i >= 5) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 4] ^ scrambledArr[i - 5];
            } else if (i == 4) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 4];
            } else {
                result[i] = scrambledArr[i];
            }
        }
        return Arrays.toString(result).replaceAll("\\[|]|,|\\s", "");
    }

    private static int[] getArr(String str) {
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
