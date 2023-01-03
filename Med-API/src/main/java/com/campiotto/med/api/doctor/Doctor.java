package com.campiotto.med.api.doctor;

import com.campiotto.med.api.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name="Doctors")
@Entity(name="Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    private String phoneNumber;

    public Doctor(DoctorRegistration doctorRegistration) {
        this.active = true;
        this.name = doctorRegistration.name();
        this.email = doctorRegistration.email();
        this.crm = doctorRegistration.crm();
        this.speciality = doctorRegistration.speciality();
        this.address = new Address(doctorRegistration.addressRegistration());
        this.phoneNumber = doctorRegistration.phoneNumber();
    }

    public void update(DoctorUpdate doctorUpdate) {
        if(doctorUpdate.name() != null) {
            this.name = doctorUpdate.name();
        }

        if(doctorUpdate.phoneNumber() != null) {
            this.phoneNumber = doctorUpdate.phoneNumber();
        }

        if(doctorUpdate.addressRegistration() != null) {
            this.address.updateAddress(doctorUpdate.addressRegistration());
        }
    }

    public void deactivateDoctor() {
        this.active = false;
    }
}
