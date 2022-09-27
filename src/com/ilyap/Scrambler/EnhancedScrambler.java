package com.ilyap.Scrambler;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class EnhancedScrambler {
    private EnhancedScrambler() {
    }

    public static String scramble(String source) {
        int[] sourceArr = getArr(source);
        int[] result = new int[sourceArr.length];
        for (int i = 0; i < source.length(); i++) {
            if (i >= 2) {
                result[i] = sourceArr[i] ^ result[i - 2];
            } else {
                result[i] = sourceArr[i];
            }
        }
        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    public static String descramble(String scrambled) {
        int[] scrambledArr = getArr(scrambled);
        int[] result = new int[scrambledArr.length];
        for (int i = 0; i < scrambled.length(); i++) {
            if (i >= 2) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 2];
            } else {
                result[i] = scrambledArr[i];
            }
        }
        return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private static int[] getArr(String str) {
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
