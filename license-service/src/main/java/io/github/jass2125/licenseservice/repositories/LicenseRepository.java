package io.github.jass2125.licenseservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.github.jass2125.licenseservice.model.License;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

    public List<License> findAll();

}
