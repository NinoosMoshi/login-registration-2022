package com.ninos.service;

import com.ninos.dto.ProductDTO;
import com.ninos.model.Product;
import com.ninos.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public List<ProductDTO> findAllProducts(){
       List<Product> list = productRepository.findAll();
       List<ProductDTO> expenseList = list.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
       return expenseList;
    }


    private ProductDTO mapToDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }



}
