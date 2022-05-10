package com.polis.api.storage;

import com.polis.api.storage.providers.StateFactory;
import lombok.Getter;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataProvider {
    private final StateFactory stateFactory;

    @Autowired
    public DataProvider(StateFactory stateFactory) {
        this.stateFactory = stateFactory;
    }

    //*********************************
    // DATA
    //*********************************

    @Getter
    private final Map<Integer, State> states = new HashMap<>();

    @PostConstruct
    private void init() {
        states.put(-4, stateFactory.getState(-4));
        states.put(-3, stateFactory.getState(-3));
        states.put(-2, stateFactory.getState(-2));
        states.put(-1, stateFactory.getState(-1));
        states.put(1, stateFactory.getState(1));
        states.put(2, stateFactory.getState(2));
        states.put(3, stateFactory.getState(3));
        states.put(4, stateFactory.getState(4));
        states.put(5, stateFactory.getState(5));
        states.put(6, stateFactory.getState(6));
//        states.put(7, stateFactory.getState(7));
//        states.put(9, stateFactory.getState(9));
        states.put(10, stateFactory.getState(10));
        states.put(12, stateFactory.getState(12));
        states.put(13, stateFactory.getState(13));
    }
}
