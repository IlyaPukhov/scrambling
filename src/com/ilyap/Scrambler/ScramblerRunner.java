package com.ilyap.Scrambler;

public class ScramblerRunner {
    public static void main(String[] args) {
        String sourceCode = "111111000000000000000000000000000000000000000011";
        System.out.println("Исходный код:                             " + sourceCode);

        String scrambled = DefaultScrambler.scramble(sourceCode);
        System.out.println("\nКод, полученный стандартным скремблером:  " + scrambled);

        String descrambled = DefaultScrambler.descramble(scrambled);
        System.out.println("Дескремблированный код:                   " + descrambled);

        String newScrambled = EnhancedScrambler.scramble(sourceCode);
        System.out.println("\nКод, полученный уникальным скремблером:   " + newScrambled);

        String newDescrambled = EnhancedScrambler.descramble(newScrambled);
        System.out.println("Дескремблированный код:                   " + newDescrambled);
    }
}