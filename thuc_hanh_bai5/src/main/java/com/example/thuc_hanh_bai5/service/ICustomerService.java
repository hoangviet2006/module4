package com.example.thuc_hanh_bai5.service;

import com.example.thuc_hanh_bai5.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
     void save(Customer customer);
     Customer findById(int id);
    void remove(int id);
}
