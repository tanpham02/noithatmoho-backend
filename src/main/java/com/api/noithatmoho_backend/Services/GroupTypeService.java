package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.noithatmoho_backend.Model.GroupTypesModel;
import com.api.noithatmoho_backend.Repository.GroupTypesRepository;

@Service
public class GroupTypeService implements GroupTypesServiceInterface {
	
	@Autowired GroupTypesRepository groupTypesRepository;

	@Override
	public GroupTypesModel createGroupTypes(GroupTypesModel groupTypes) {
		return groupTypesRepository.save(groupTypes);
	}

	@Override
	public Optional<GroupTypesModel> getGroupTypeById(int id) {
		return groupTypesRepository.findById(id);
	}

	@Override
	public List<GroupTypesModel> getAllGroupTypes() {
		return groupTypesRepository.findAll();
	}

	@Override
	public GroupTypesModel updateGroupType(int id, GroupTypesModel groupTypes) {
		GroupTypesModel updateGroupType = groupTypesRepository.findById(id).orElseThrow();
		updateGroupType.setName(groupTypes.getName());
		updateGroupType.setDeleted(groupTypes.isDeleted());
		updateGroupType.setCreated_at(groupTypes.getCreated_at());
		updateGroupType.setCreated_by(groupTypes.getCreated_by());
		updateGroupType.setUpdated_at(groupTypes.getUpdated_at());
		updateGroupType.setUpdated_by(groupTypes.getUpdated_by());
		return groupTypesRepository.save(updateGroupType);
	}

	@Override
	public void deleteGroupType(int id) {
		groupTypesRepository.deleteById(id);
		
	}

}
