package com.pat.service;

import com.pat.DAO.CategoryDAO;
import com.pat.DAO.ICategoryDAO;
import com.pat.model.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryDAO categoryDAO = new CategoryDAO();
    @Override
    public List<Category> selectAll() throws SQLException {
        return categoryDAO.selectAll();
    }
}
