package com.ilyap.scrambling;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class DefaultScrambler {
    private DefaultScrambler() {
    }

    public static String scramble(String source) {
        int[] sourceArr = getArr(source);
        int[] result = new int[sourceArr.length];
        for (int i = 0; i < source.length(); i++) {
            if (i >= 5) {
                result[i] = sourceArr[i] ^ result[i - 3] ^ result[i - 5];
            } else if (i >= 3) {
                result[i] = sourceArr[i] ^ result[i - 3];
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
            if (i >= 5) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 3] ^ scrambledArr[i - 5];
            } else if (i >= 3) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 3];
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
