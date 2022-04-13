package com.polis.api;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    private RandomUtils() {

    }

    public static int randomNumberFromZeroToBound(int bound) {
        return random.nextInt(bound);
    }
}
