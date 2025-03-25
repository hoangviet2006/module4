package com.example.bai_tap_bai_5_jpa.repository;

import com.example.bai_tap_bai_5_jpa.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> getAll() {
        TypedQuery<Product> typedQuery = (TypedQuery<Product>) entityManager.createQuery("from Product");
        return typedQuery.getResultList();
    }

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public List<Product> searchProduct(String name) {
        return null;
    }
}
