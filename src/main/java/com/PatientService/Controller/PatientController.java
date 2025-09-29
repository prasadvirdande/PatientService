package com.PatientService.Controller;
import com.PatientService.DTO.PatientRequestDTO;
import com.PatientService.DTO.PatientResponseDTO;
import com.PatientService.Service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
@Tag(name = "Patient Controller", description = "Patient Controller")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping("/all")
    @Operation(summary = "Get all patients", description = "Get all patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by id", description = "Get patient by id")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable UUID id) {
        System.out.println(">>> Received request for patient: " + id);
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    @PostMapping("/create")
    @Operation(summary = "Create patient", description = "Create patient")
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody @Valid PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.createPatient(patientRequestDTO));
    }
    @PutMapping("/update")
    @Operation(summary = "Update patient", description = "Update patient")
    public ResponseEntity<PatientResponseDTO> updatePatient(@RequestBody @Valid PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.updatePatient(patientRequestDTO));
    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete patient", description = "Delete patient")
    public void deletePatient(@PathVariable UUID id) {
         patientService.deletePatient(id);

    }
}
