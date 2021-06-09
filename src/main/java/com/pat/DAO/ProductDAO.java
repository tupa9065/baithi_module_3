package com.pat.DAO;

import com.pat.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO{
    private static final String INSERT_NEW_PRODUCT = "insert into product(name,price,amount,detail,cat_id) value (?,?,?,?,?)";
    private static final String SELECT_ALL_PRODUCT = "select * from Product";
    private static final String UPDATE_PRODUCT = "update product set name = ?,price = ?,amout = ?,detail =?,cat_id=?  where id = ?";
    private static final String SELECT_PRODUCT = "select * from product where id=?";
    private Connection connection = null;
    private int newRow;
    @Override
    public boolean create(Product product) throws SQLException {
        connection = SQLConnection.getConnection();
        newRow = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setInt(3, product.getAmount());
        preparedStatement.setString(4, product.getDetail());
        preparedStatement.setInt(5, product.getCat_id());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }

    @Override
    public Product select(int id) throws SQLException {
        connection = SQLConnection.getConnection();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int product_id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                String detail = resultSet.getString("detail");
                int cat_id = resultSet.getInt("cat_id");
                product = new Product(product_id, name , price , amount , detail , cat_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        connection = SQLConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                String detail = resultSet.getString("detail");
                int cat_id = resultSet.getInt("cat_id");
                list.add(new Product(id, name,price,amount,detail,cat_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(int id, Product product) throws SQLException {
        newRow = 0;
        connection = SQLConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getPrice());
        preparedStatement.setInt(3, product.getAmount());
        preparedStatement.setString(4, product.getDetail());
        preparedStatement.setInt(5, product.getCat_id());
        preparedStatement.setInt(6, product.getId());
        newRow = preparedStatement.executeUpdate();
        return newRow != 0;
    }
}
