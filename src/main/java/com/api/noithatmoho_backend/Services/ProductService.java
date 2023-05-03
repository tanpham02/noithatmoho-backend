package com.api.noithatmoho_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.noithatmoho_backend.Model.ProductModel;
import com.api.noithatmoho_backend.Repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductModel createProduct(ProductModel product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<ProductModel> getProductbyId(int id) {
		return productRepository.findById(id);
	}
 
	@Override
	public List<ProductModel> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ProductModel updateProduct(int id, ProductModel product) {
		ProductModel updateProd = productRepository.findById(id).orElseThrow();
		updateProd.setName(product.getName());
		updateProd.setDiscount(product.getDiscount());
		updateProd.setPrices(product.getPrices());
		updateProd.setQuantity_sold(product.getQuantity_sold());
		updateProd.setQuantity_stock(product.getQuantity_stock());
		updateProd.setImage_url(product.getImage_url());
		updateProd.setSize(product.getSize());
		updateProd.setType_id(product.getType_id());
		updateProd.setCreated_at(product.getCreated_at());
		updateProd.setCreated_by(product.getCreated_by());
		return productRepository.save(updateProd);
		
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}
 
}
