package com.example.bai_tap_jpa.repository;

import com.example.bai_tap_jpa.model.Product;
import com.example.bai_tap_jpa.repository.ProductRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
    @Transactional
    public boolean addProduct(Product product) {
        entityManager.merge(product);
        return true;
    }

    @Override
    @Transactional
    public boolean updateProduct(int id, Product product) {
        Product findProduct = findId(id);
        if (findProduct != null) {
            findProduct.setName(product.getName());
            findProduct.setPrice(product.getPrice());
            findProduct.setQuantity(product.getQuantity());
            entityManager.merge(findProduct);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteProduct(int id) {
        Product deleteProduct = findId(id);
        entityManager.remove(deleteProduct);
        return true;
    }

    @Override
    @Transactional
    public List<Product> searchProduct(String name) {
        TypedQuery<Product> typedQuery = (TypedQuery<Product>) entityManager.createQuery("from Product where name like :name");
        typedQuery.setParameter("name", "%" + name + "%");
        return typedQuery.getResultList();
    }

    @Override
    public Product findId(int id) {
        return entityManager.find(Product.class, id);
    }
}
