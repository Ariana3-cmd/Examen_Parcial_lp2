package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.examen.model.Paciente;

	@Repository
	public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
