package com.example.thuchanh2bai1md4.model;

import com.example.thuchanh2bai1md4.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/customers?customerSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Trung123@";

    private static final String INSERT_USERS_SQL = "INSERT INTO customer (name, email, address) VALUES (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,address from customer where id =?";
    private static final String SELECT_ALL_USERS = "select * from customer";
    private static final String DELETE_USERS_SQL = "delete from customer where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set name = ?,email= ?, address =? where id = ?;";

    public CustomerDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(Customer customer) throws SQLException {

    }

    @Override
    public Customer selectUser(int id) {
        return null;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                customers.add(new Customer(id, name, email, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getAddress());
            statement.setInt(4, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Customer getCustomer(int id) throws SQLException {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE id = ?";
        try (Connection connection = getConnection();

             PreparedStatement statement = connection.prepareStatement(sql);) {

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                String name = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                customer = new Customer(id,name, email, address);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


}
