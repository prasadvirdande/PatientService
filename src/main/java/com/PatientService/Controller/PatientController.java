package com.PatientService.Controller;
import com.PatientService.DTO.PatientRequestDTO;
import com.PatientService.DTO.PatientResponseDTO;
import com.PatientService.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/all")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping("/create")
    public ResponseEntity<PatientRequestDTO> createPatient(@RequestBody @Valid PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }
    @PutMapping("/update")
    public ResponseEntity<PatientRequestDTO> updatePatient(@RequestBody @Valid PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.updatePatient(patientRequestDTO));
    }
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable UUID id) {
         patientService.deletePatient(id);

    }
}
