package com.polis.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Nlu {
    private List<String> tokens = new ArrayList<>();
    private List<String> entities = new ArrayList<>();
}
