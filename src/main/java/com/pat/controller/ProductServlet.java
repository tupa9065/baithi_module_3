package com.pat.controller;

import com.pat.model.Category;
import com.pat.model.Product;
import com.pat.service.CategoryService;
import com.pat.service.ICategoryService;
import com.pat.service.IProductService;
import com.pat.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/Products")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductService();
    private final ICategoryService categoryService = new CategoryService();
    String action = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewForm(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteForm(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }

    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Product> products = productService.selectAll();
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> categories =categoryService.selectAll();
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }
    }


    private void editForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Product product = productService.select(id);
            List<Category> categories = categoryService.selectAll();
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
            if (product == null) {
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            }
            request.setAttribute("product", product);
            request.setAttribute("categories",categories);
            dispatcher.forward(request, response);

        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNew(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String detail = request.getParameter("detail");
        int cat_id = Integer.parseInt(request.getParameter("cat_id"));

        Product product = new Product(id, name,price,amount,detail,cat_id);

        try {
            List<Category> categories = categoryService.selectAll();

            boolean isEdit = productService.update(product.getId(), product);
            if (!isEdit) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
            request.setAttribute("product", product);
            request.setAttribute("categories",categories);
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String detail = request.getParameter("detail");
        int cat_id = Integer.parseInt(request.getParameter("cat_id"));
        Product product = new Product(name,price,amount,detail,cat_id);

        try {
            boolean isCreate = productService.create(product);
            if (!isCreate) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            List<Category> categories =categoryService.selectAll();
            request.setAttribute("categories", categories);

            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");

            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }


    }
}
