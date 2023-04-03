package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.noithatmoho_backend.Model.TypesModel;
import com.api.noithatmoho_backend.Repository.TypesRepository;

@Service
public class TypesService implements TypesServiceInterface {
	
	@Autowired TypesRepository typeRepository;

	@Override
	public TypesModel createType(TypesModel type) {
		return typeRepository.save(type);
	}

	@Override
	public Optional<TypesModel> getTypeById(int id) {
		return typeRepository.findById(id);
	}

	@Override
	public List<TypesModel> getAllTypes() {
		return typeRepository.findAll();
	}

	@Override
	public TypesModel updateType(int id, TypesModel type) {
		TypesModel updateTy = typeRepository.findById(id).orElseThrow();
		updateTy.setName(type.getName());
		updateTy.setDeleted(type.isDeleted());
		updateTy.setCreated_at(type.getCreated_at());
		updateTy.setCreated_by(type.getCreated_by());
		updateTy.setUpdated_at(type.getUpdated_at());
		updateTy.setUpdated_by(type.getUpdated_by());
		return typeRepository.save(updateTy);
	}

	@Override
	public void deleteType(int id) {
		typeRepository.deleteById(id);
	}
	
	

}
