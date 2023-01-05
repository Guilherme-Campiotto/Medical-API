package com.campiotto.med.api.controller;

import com.campiotto.med.api.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity CreateDoctor(@RequestBody @Valid DoctorRegistration doctorRegistration, UriComponentsBuilder uriBuilder) {
        Doctor newDoctor = new Doctor(doctorRegistration);
        doctorRepository.save(newDoctor);

        URI uri = uriBuilder.path("/{id}").buildAndExpand(newDoctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorReturnDetails(newDoctor));
    }

    @PutMapping("/update")
    @Transactional
    public ResponseEntity UpdateDoctor(@RequestBody @Valid DoctorUpdate doctorUpdate) {
        Doctor doctor = doctorRepository.getReferenceById(doctorUpdate.id());
        doctor.update(doctorUpdate);
        return ResponseEntity.ok(new DoctorReturnDetails(doctor));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity DeleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.deactivateDoctor();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<DoctorDataExibition>> ListDoctors(Pageable pageable) {
        Page<DoctorDataExibition> doctors = doctorRepository.findAll(pageable).map(DoctorDataExibition::new);
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorReturnDetails> DoctorDetails(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DoctorReturnDetails(doctor));
    }

}
