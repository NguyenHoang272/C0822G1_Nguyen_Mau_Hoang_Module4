package com.cart.service;

import com.cart.model.Product;
import com.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iproductRepository;

    @Override
    public List<Product> findAll() {
        return iproductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return iproductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iproductRepository.save(product);
    }
}
