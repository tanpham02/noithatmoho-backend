package com.api.noithatmoho_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name= "types")
public class TypesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private boolean deleted;
	private String created_at;
	private String created_by;
	private String updated_at;
	private String updated_by;
	private int group_type_id;

	public TypesModel() {
		super();
	}

	public TypesModel(String name, boolean deleted, String created_at, String created_by, String updated_at,
			String updated_by, int group_type_id) {
		super();
		this.name = name;
		this.deleted = deleted;
		this.created_at = created_at;
		this.created_by = created_by;
		this.updated_at = updated_at;
		this.updated_by = updated_by;
		this.group_type_id = group_type_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public int getGroup_type_id() {
		return group_type_id;
	}

	public void setGroup_type_id(int group_type_id) {
		this.group_type_id = group_type_id;
	}
}
