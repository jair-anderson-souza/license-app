package io.github.jass2125.licenseservice.mapper;

import io.github.jass2125.licenseservice.model.License;
import io.github.jass2125.licenseservice.controller.LicenseRequest;
import io.github.jass2125.licenseservice.controller.LicenseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LicenseMapper {

    LicenseMapper INSTANCE = Mappers.getMapper(LicenseMapper.class);

    LicenseResponse toResponse(License license);

    License toEntity(LicenseRequest licenseRequest);

}
