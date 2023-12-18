package com.example.thuchanh2bai1md4.model;

import com.example.thuchanh2bai1md4.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO {
    public void insertUser(Customer customer) throws SQLException;

    public Customer selectUser(int id);

    public List<Customer> selectAllCustomers();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;
    public Customer getCustomer(int id) throws SQLException;
}
