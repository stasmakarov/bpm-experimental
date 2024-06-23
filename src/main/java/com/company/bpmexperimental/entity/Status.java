package com.company.bpmexperimental.entity;

import io.jmix.core.metamodel.datatype.EnumClass;

import org.springframework.lang.Nullable;


public enum Status implements EnumClass<String> {

    NEW("A"),
    OLD("B");

    private final String id;

    Status(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Status fromId(String id) {
        for (Status at : Status.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}