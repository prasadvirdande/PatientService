package com.PatientService.Service;

 import com.PatientService.DTO.PatientRequestDTO;
 import com.PatientService.DTO.PatientResponseDTO;
 import com.PatientService.Entity.Patient;
 import com.PatientService.Mapper.PatientMapper;
 import com.PatientService.Repository.PatientRepository;
 import org.springframework.stereotype.Service;

 import java.time.LocalDate;
 import java.time.LocalDateTime;
 import java.util.List;
 import java.util.UUID;
 import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll().stream().map(patient -> PatientMapper.mapToPatientResponseDTO(patient)).collect(Collectors.toList());
    }

    public PatientRequestDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient= PatientMapper.toPatient(patientRequestDTO);
        patient.setRegisteredDate(LocalDate.now());
        patientRepository.save(patient);
        return patientRequestDTO;
    }
    public PatientRequestDTO updatePatient(PatientRequestDTO patientRequestDTO) {
        Patient patient= PatientMapper.toPatient(patientRequestDTO);
        patientRepository.save(patient);
        return patientRequestDTO;
    }
    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }



}
