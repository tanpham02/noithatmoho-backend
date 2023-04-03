package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import com.api.noithatmoho_backend.Model.TypesModel;

public interface TypesServiceInterface {
	public TypesModel createType(TypesModel type);
	public Optional<TypesModel> getTypeById(int id);
	List<TypesModel> getAllTypes();
	public TypesModel updateType(int id, TypesModel type);
	public void deleteType(int id);
} 
