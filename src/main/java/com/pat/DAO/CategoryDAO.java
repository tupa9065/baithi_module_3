package com.pat.DAO;

import com.pat.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    private static final String SELECT_FROM_CATEGORY = "select * from category";

    @Override
    public List<Category> selectAll() throws SQLException {
        List<Category> list = new ArrayList<>();
        try {
            Connection connection = SQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                list.add(new Category(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
