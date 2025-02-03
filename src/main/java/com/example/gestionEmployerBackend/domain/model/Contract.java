package com.example.gestionEmployerBackend.domain.model;

import java.util.List;

import com.example.gestionEmployerBackend.application.utils.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "contracts")
@Data
public class Contract extends BaseEntity {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	// private Long id;

	private String reference;
	private String startDate;
	private String endDate;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "employer_id", nullable = false)
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "contract_type_id", nullable = false)
	private ContractType contractType;

	@OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Clause> clauses;

	@OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
	private List<Benefit> benefits;

	// Un contrat est lié à un seul salaire
	@OneToOne(mappedBy = "contract", cascade = CascadeType.ALL)
	private Salary salary;
}