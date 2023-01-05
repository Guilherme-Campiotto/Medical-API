package com.campiotto.med.api.doctor;

import com.campiotto.med.api.address.Address;

public record DoctorReturnDetails(Long id, String name, String email, String crm, Speciality speciality, Address address, String phoneNumber) {
    public DoctorReturnDetails(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality(), doctor.getAddress(), doctor.getPhoneNumber());
    }
}
