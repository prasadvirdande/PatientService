package com.PatientService.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        @NotNull
        private String name;

        @NotNull
        @Email
        @Column(unique = true)
        private String email;

        @NotNull
        private String address;

        @NotNull
        private LocalDate dateOfBirth;

        @NotNull
        private LocalDate registeredDate;

        public UUID getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public String getEmail() {
                return email;
        }

        public String getAddress() {
                return address;
        }

        public LocalDate getDateOfBirth() {
                return dateOfBirth;
        }

        public LocalDate getRegisteredDate() {
                return registeredDate;
        }

        public void setId(UUID id) {
                this.id = id;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }

        public void setRegisteredDate(LocalDate registeredDate) {
                this.registeredDate = registeredDate;
        }
}
