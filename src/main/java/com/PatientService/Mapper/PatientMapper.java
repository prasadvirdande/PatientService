package com.PatientService.Mapper;

import com.PatientService.DTO.PatientRequestDTO;
import com.PatientService.DTO.PatientResponseDTO;
import com.PatientService.Entity.Patient;

import java.time.LocalDate;

public class PatientMapper {
  public static PatientResponseDTO mapToPatientResponseDTO(Patient patient) {
      PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
      patientResponseDTO.setId(patient.getId().toString());
      patientResponseDTO.setName(patient.getName());
      patientResponseDTO.setEmail(patient.getEmail());
      patientResponseDTO.setId(patient.getId().toString());
      patientResponseDTO.setName(patient.getName());
      patientResponseDTO.setAddress(patient.getAddress());
      patientResponseDTO.setEmail(patient.getEmail());
      patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());

      return patientResponseDTO;
  }

  public static Patient toPatient(PatientRequestDTO patientRequestDTO) {
      Patient patient = new Patient();
      patient.setName(patientRequestDTO.getName());
      patient.setEmail(patientRequestDTO.getEmail());
      patient.setAddress(patientRequestDTO.getAddress());
      patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth().toString()));
      return patient;
  }

  }

