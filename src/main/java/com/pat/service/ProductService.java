package com.pat.service;

import com.pat.DAO.IProductDAO;
import com.pat.DAO.ProductDAO;
import com.pat.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    IProductDAO productDAO = new ProductDAO();
    @Override
    public boolean create(Product product) throws SQLException {
        return productDAO.create(product);
    }

    @Override
    public Product select(int id) throws SQLException {
        return productDAO.select(id);
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        return productDAO.selectAll();
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return productDAO.delete(id);
    }

    @Override
    public boolean update(int id, Product product) throws SQLException {
        return productDAO.update(id,product);
    }
}
