package com.campiotto.med.api.doctor;

public record DoctorDataExibition(Long id, String name, String email, String crm, Speciality speciality, boolean active) {

    public DoctorDataExibition(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpeciality(), doctor.isActive());
    }

}