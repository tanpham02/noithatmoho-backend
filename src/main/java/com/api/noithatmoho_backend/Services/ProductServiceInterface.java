package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import com.api.noithatmoho_backend.Model.ProductModel;

public interface ProductServiceInterface {
	public ProductModel createProduct(ProductModel product); // lưu vào product
	public Optional<ProductModel> getProductbyId(int id);
	List<ProductModel> getAllProducts();
	ProductModel updateProduct(int id, ProductModel product); // update thằng nào, update vào đâu
	public void deleteProduct(int id); // delete thằng nào
}
