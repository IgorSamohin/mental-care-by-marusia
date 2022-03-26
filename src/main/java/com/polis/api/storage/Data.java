package com.polis.api.storage;

import java.util.Map;

public class Data {
    public static Map<Integer, State> states = Map.of(
            -1, new State(),//default state
            1, new State(),
            2, new State()
            );
}
