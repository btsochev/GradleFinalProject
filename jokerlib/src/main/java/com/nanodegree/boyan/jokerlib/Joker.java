package com.nanodegree.boyan.jokerlib;

import java.util.concurrent.ThreadLocalRandom;

public class Joker {
    private static String[] jokes = {
            "Programmer - a machine that turns coffee into code",
            "Programmer - a person who fixed a problem that you don't know you have, " +
                    "in a way you don't understand",
            "Algorithm - word used by programmers when they do not want to explain what they did",
            "Hardware - the part of a computer that you can kick"
    };

    public static String getJoke() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        return jokes[randomNum];
    }
}
