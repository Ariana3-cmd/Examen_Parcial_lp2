package com.example.examen.services;

import java.util.List;

import com.example.examen.model.Paciente;

public interface SPaciente {

	Paciente create (Paciente paciente);
	List<Paciente> readAll();
	Paciente read(long id);
	void delete(long id);
	Paciente update(Paciente al);
}
