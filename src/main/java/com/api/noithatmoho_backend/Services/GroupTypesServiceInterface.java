package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;


import com.api.noithatmoho_backend.Model.GroupTypesModel;

public interface GroupTypesServiceInterface {

	public GroupTypesModel createGroupTypes(GroupTypesModel groupTypes);
	public Optional<GroupTypesModel> getGroupTypeById(int id);
	List<GroupTypesModel> getAllGroupTypes();
	public GroupTypesModel updateGroupType(int id, GroupTypesModel groupTypes);
	public void deleteGroupType(int id);
}
