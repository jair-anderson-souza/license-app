package io.github.jass2125.licenseservice.exceptions;

public class LicenseNotFoundException extends RuntimeException {

    public LicenseNotFoundException(String licenseNotFound) {
        super(licenseNotFound);
    }
    
}
