package com.example.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.examen.model.Paciente;
import com.example.examen.repository.PacienteRepository;

public class PacienteService implements SPaciente{
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public Paciente create(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(paciente);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente read(long id) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		pacienteRepository.deleteById(id);
		
	}

	@Override
	public Paciente update(Paciente al) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(al);
	}
	



}
