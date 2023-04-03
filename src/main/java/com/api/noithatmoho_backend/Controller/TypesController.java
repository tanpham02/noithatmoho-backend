package com.api.noithatmoho_backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.noithatmoho_backend.Model.TypesModel;
import com.api.noithatmoho_backend.Services.TypesService;

@RestController
@RequestMapping("/api/types")
//@CrossOrigin(origins = "http://localhost:3000")
public class TypesController {

	@Autowired TypesService typeService;
	
	@PostMapping
	public TypesModel createType(@RequestBody TypesModel type) {
		return typeService.createType(type);
	}
	
	@GetMapping
	public List<TypesModel> getAllTypes() {
		return typeService.getAllTypes();
	}
	
	@GetMapping("/{id}")
	public Optional<TypesModel> getTypeById(@PathVariable int id) {
		return typeService.getTypeById(id);
	}
	
	
	@PutMapping("/{id}")
	public TypesModel updateType(@PathVariable int id, @RequestBody TypesModel type) {
		return typeService.updateType(id, type);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteType(@PathVariable int id) {
		typeService.deleteType(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
