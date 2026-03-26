package org.example.demospring.service;

import org.example.demospring.entity.Product;
import org.example.demospring.dto.ProductDTO;
import org.example.demospring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // GET - Get all products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // GET - Get product by ID - FIXED!
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? convertToDTO(product) : null;  // ✅ Fixed
    }

    // POST - Create new product
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    // PUT - Update existing product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct == null) {
            return null;
        }

        existingProduct.setCoffeeName(productDTO.getCoffeeName());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setCoffeeOrigin(productDTO.getCoffeeOrigin());
        existingProduct.setIsAvailable(productDTO.getIsAvailable());

        Product updatedProduct = productRepository.save(existingProduct);
        return convertToDTO(updatedProduct);
    }

    // DELETE - Delete product
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Helper method to convert Entity to DTO
    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setCoffeeName(product.getCoffeeName());
        dto.setPrice(product.getPrice());
        dto.setCoffeeOrigin(product.getCoffeeOrigin());
        dto.setIsAvailable(product.getIsAvailable());
        return dto;
    }

    // Helper method to convert DTO to Entity
    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setCoffeeName(dto.getCoffeeName());
        product.setPrice(dto.getPrice());
        product.setCoffeeOrigin(dto.getCoffeeOrigin());
        product.setIsAvailable(dto.getIsAvailable());
        return product;
    }
}