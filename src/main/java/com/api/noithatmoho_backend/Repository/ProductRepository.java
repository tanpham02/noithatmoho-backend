package com.api.noithatmoho_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.noithatmoho_backend.Model.ProductModel;

public interface ProductRepository extends	JpaRepository<ProductModel, Integer> {

}
