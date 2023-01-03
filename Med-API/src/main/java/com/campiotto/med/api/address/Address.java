package com.campiotto.med.api.address;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String zipCode;
    private String city;
    private String uf;
    private String number;
    private String complement;

    public Address(AddressRegistration addressRegistration) {
        this.street = addressRegistration.street();
        this.zipCode = addressRegistration.zipCode();
        this.city = addressRegistration.city();
        this.uf = addressRegistration.uf();
        this.number = addressRegistration.number();
        this.complement = addressRegistration.complement();
    }

    public void updateAddress(AddressRegistration addressRegistration) {
        if(addressRegistration.street() != null) {
            this.street = addressRegistration.street();
        }

        if(addressRegistration.zipCode() != null) {
            this.zipCode = addressRegistration.zipCode();
        }

        if(addressRegistration.city() != null) {
            this.city = addressRegistration.city();
        }

        if(addressRegistration.uf() != null) {
            this.uf = addressRegistration.uf();
        }

        if(addressRegistration.number() != null) {
            this.number = addressRegistration.number();
        }

        this.complement = addressRegistration.complement();
    }
}
