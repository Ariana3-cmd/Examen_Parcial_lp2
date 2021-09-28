package com.example.examen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.model.Paciente;
import com.example.examen.services.PacienteService;

@RestController
@RequestMapping("/api")
public class PacienteController {
	private static final Paciente Paciente = null;
	@Autowired
	private PacienteService paciente;
	
	@PostMapping("/save")
	public ResponseEntity<Paciente> save(@RequestBody Paciente p){
		try {
			Paciente pac = paciente.create(new Paciente(0, p.getDni(),p.getNombres(),p.getApellidos(),p.getDirecion(),p.getTelefono(), Paciente));
			return new ResponseEntity<>(pac,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/paciente")
	public ResponseEntity<List<Paciente>> getPaciente(){
		try {
			List<Paciente> list = new ArrayList<>();
			list=paciente.readAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/paciente/{id}")
	public ResponseEntity<Paciente> getPacienteID(@PathVariable("id") int id){
		Paciente p = paciente.read(id);
		if (p.getIdpaciente()>0) {
			return new ResponseEntity<>(p,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<Paciente> delete(@PathVariable("id")int id){
			try {
				paciente.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/alumno/update/{id}")
	public ResponseEntity<Paciente> update(@RequestBody Paciente p, @PathVariable("id") Long id){
		try {
			Paciente ul = paciente.read(id);
			if(ul.getIdpaciente()>0) {
				ul.setNombres(p.getNombres());
				ul.setApellidos(p.getApellidos());
				ul.setDni(p.getDni());
				ul.setTelefono(p.getTelefono());
				ul.setDirecion(p.getDirecion());
				return new ResponseEntity<>(paciente.update(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
