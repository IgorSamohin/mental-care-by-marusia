package com.polis.api.model.response.components;

import com.polis.api.model.response.components.base.types.CommandType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Command {
    protected CommandType type;
}
