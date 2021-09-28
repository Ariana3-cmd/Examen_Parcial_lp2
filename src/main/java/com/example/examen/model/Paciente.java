package com.example.examen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paciente")

public class Paciente {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int idpaciente;
		private String dni;
		private String nombres;
		private String apellidos;
		private String direcion;	
		private String telefono;
		@OneToOne(mappedBy = "paciente")
		private Paciente paciente;

}
