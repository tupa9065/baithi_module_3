package com.pat.service;

import com.pat.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    boolean create(Product product) throws SQLException;

    Product select(int id) throws SQLException;

    List<Product> selectAll() throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(int id,Product product) throws SQLException;
}
