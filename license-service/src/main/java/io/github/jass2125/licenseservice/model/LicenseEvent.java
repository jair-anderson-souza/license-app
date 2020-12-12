package io.github.jass2125.licenseservice.model;

import org.springframework.context.ApplicationEvent;

public class LicenseEvent extends ApplicationEvent {

    private License license;

    public LicenseEvent(License license) {
        super(license);
        this.license = license;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "LicenseEvent{" +
                "license=" + license +
                '}';
    }
}
