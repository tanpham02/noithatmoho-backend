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

import com.api.noithatmoho_backend.Model.GroupTypesModel;
import com.api.noithatmoho_backend.Services.GroupTypeService;

@RestController
@RequestMapping("/api/groupTypes")
//@CrossOrigin(origins = "http://localhost:3000")
public class GroupTypesController {

	@Autowired GroupTypeService groupTypeService;
	
	@PostMapping
	public GroupTypesModel createGroupTypes(GroupTypesModel groupTypes) {
		return groupTypeService.createGroupTypes(groupTypes);
	}
	
	@GetMapping
	public List<GroupTypesModel> getAllGroupTypes() {
		return groupTypeService.getAllGroupTypes();
	}
	
	@GetMapping("/{id}")
	public Optional<GroupTypesModel> getGroupTypeById(@PathVariable int id) {
		return groupTypeService.getGroupTypeById(id);
	}
	
	@PutMapping("/{id}")
	public GroupTypesModel updateGroupType(@PathVariable int id, @RequestBody GroupTypesModel groupTypes) {
		return groupTypeService.updateGroupType(id, groupTypes);
	}
	
	@DeleteMapping("/{id}")
	public void deleteGroupType(@PathVariable int id) {
		groupTypeService.deleteGroupType(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
