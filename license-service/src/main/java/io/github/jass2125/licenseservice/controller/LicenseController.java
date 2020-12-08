package io.github.jass2125.licenseservice.controller;

import io.github.jass2125.licenseservice.model.License;
import io.github.jass2125.licenseservice.model.LicenseDTO;
import io.github.jass2125.licenseservice.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.newrelic.api.agent.Trace;


@RestController
@RequestMapping("/license")
public class LicenseController {

	@Autowired
	private LicenseService licenseService;

	@GetMapping
	@Trace
	public List<LicenseDTO> findAll() {
		return this.licenseService.findAll();
	}

	@Trace(dispatcher = true)
	@GetMapping(value = "/{id}")
	public LicenseDTO findById(@PathVariable("id") Long id) {
		return this.licenseService.findById(id);
	}

	@Trace(dispatcher = true)
	@PostMapping
	public LicenseDTO save(@RequestBody License license) {
		return this.licenseService.save(license);
	}

}
