package com.pat.DAO;

import com.pat.model.Category;
import com.pat.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDAO {
    List<Category> selectAll() throws SQLException;
}
