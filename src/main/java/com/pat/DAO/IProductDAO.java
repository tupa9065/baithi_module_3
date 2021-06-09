package com.pat.DAO;

import com.pat.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    boolean create(Product product) throws SQLException;

    Product select(int id) throws SQLException;

    List<Product> selectAll() throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(int id,Product product) throws SQLException;
}
