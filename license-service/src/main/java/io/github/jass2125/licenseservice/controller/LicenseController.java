package io.github.jass2125.licenseservice.controller;

import com.newrelic.api.agent.Trace;
import io.github.jass2125.licenseservice.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/license")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping
    @Trace(dispatcher = true)
    public List<LicenseResponse> findAll() {
        return this.licenseService.findAll();
    }

    @Trace(dispatcher = true)
    @GetMapping(value = "/{id}")
    public LicenseResponse findById(@PathVariable("id") final Long id) {
        return this.licenseService.findById(id);
    }

    @Trace(dispatcher = true)
    @PostMapping
    public LicenseResponse save(@RequestBody final LicenseRequest licenseRequest) {
        return this.licenseService.save(licenseRequest);
    }

}
