package com.campiotto.med.api.domain.doctor;

import com.campiotto.med.api.domain.address.AddressRegistration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DoctorRegistration(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Speciality speciality,
        @NotNull
        @Valid
        AddressRegistration addressRegistration,
        String phoneNumber) {
}
