package com.example.gestionEmployerBackend.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "contracts")
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private Double salary;

	@Column(name = "contract_type")
	private String contractType;

	private String status;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_id")
	private Long employeeId;

	private String details;

}
