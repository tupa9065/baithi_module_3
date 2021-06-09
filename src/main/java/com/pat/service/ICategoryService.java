package com.pat.service;

import com.pat.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    List<Category> selectAll() throws SQLException;
}
