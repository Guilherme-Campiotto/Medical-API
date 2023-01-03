package com.campiotto.med.api.controller;

import com.campiotto.med.api.doctor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/create")
    public String CreateDoctor(@RequestBody @Valid DoctorRegistration doctorRegistration) {
        doctorRepository.save(new Doctor(doctorRegistration));
        System.out.println(doctorRegistration);
        return doctorRegistration.toString();
    }

    @PutMapping("/update")
    @Transactional
    public String UpdateDoctor(@RequestBody @Valid DoctorUpdate doctorUpdate) {
        Doctor doctor = doctorRepository.getReferenceById(doctorUpdate.id());
        doctor.update(doctorUpdate);
        System.out.println(doctorUpdate);
        return doctor.toString();
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public String DeleteDoctor(@PathVariable Long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.deactivateDoctor();
        System.out.println(doctor);
        return doctor.toString();
    }

    @GetMapping("/get-all")
    public Page<DoctorDataExibition> ListDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable).map(DoctorDataExibition::new);
    }

    @GetMapping("/schedule")
    public String CheckSchedule() {
        return "Schedule is open!";
    }

}
