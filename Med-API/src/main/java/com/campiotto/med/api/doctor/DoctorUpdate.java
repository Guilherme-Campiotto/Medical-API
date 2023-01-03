package com.campiotto.med.api.doctor;

import com.campiotto.med.api.address.AddressRegistration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdate(
        @NotNull
        Long id,
        @NotBlank
        String name,
        @NotNull
        @Valid
        AddressRegistration addressRegistration,
        String phoneNumber) {
}
