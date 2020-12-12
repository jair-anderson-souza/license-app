package io.github.jass2125.licenseservice.controller;

import java.io.Serializable;

public class LicenseResponse implements Serializable {

    private Long id;

    private String name;

    public LicenseResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
