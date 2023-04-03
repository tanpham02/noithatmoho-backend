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

import com.api.noithatmoho_backend.Model.ProductModel;
import com.api.noithatmoho_backend.Services.ProductService;

@RestController
@RequestMapping("/api/products")
//@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
		
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ProductModel createProduct(@RequestBody ProductModel product) {
		return productService.createProduct(product);
	}
	
	@GetMapping
	public List<ProductModel> getAllProduct() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Optional<ProductModel> getProductById(@PathVariable int id) {
		return productService.getProductbyId(id);
	}
	
	@PutMapping("/{id}")
	public ProductModel updateProduct(@PathVariable int id, @RequestBody ProductModel product) {
		return productService.updateProduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
