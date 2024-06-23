package com.company.bpmexperimental.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Level implements EnumClass<Integer> {

    LOW(10),
    HIGH(20);

    private final Integer id;

    Level(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static Level fromId(Integer id) {
        for (Level at : Level.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}