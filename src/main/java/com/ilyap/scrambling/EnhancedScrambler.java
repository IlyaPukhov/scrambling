package com.ilyap.scrambling;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class EnhancedScrambler {
    private EnhancedScrambler() {
    }

    public static String scramble(String source) {
        int[] sourceArr = getArr(source);
        int[] result = new int[sourceArr.length];

        for (int i = 0; i < source.length(); i++) {
            if (i >= 48) {
                result[i] = sourceArr[i] ^ result[i - 4] ^ result[i - 44] ^ result[i - 48];
            } else if (i >= 44) {
                result[i] = sourceArr[i] ^ result[i - 4] ^ result[i - 44];
            } else if (i >= 4) {
                result[i] = sourceArr[i] ^ result[i - 4];
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
            if (i >= 48) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 4] ^ scrambledArr[i - 44] ^ scrambledArr[i - 48];
            } else if (i >= 44) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 4] ^ scrambledArr[i - 44];
            } else if (i >= 4) {
                result[i] = scrambledArr[i] ^ scrambledArr[i - 4];
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
