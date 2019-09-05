package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
  private ProductService productService = new ProductServiceImpl();


  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "create":
        createProduct(request, response);
        break;
      case "edit":
        editProduct(request, response);
        break;
      case "delete":
        deleteProduct(request,response);
        break;
      default:
        viewProduct(request,response);
        break;
    }
  }

  private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = productService.findById(id);
    productService.delete(product.getId());
    request.setAttribute("message","product was deleted");
    request.setAttribute("product",product);
    RequestDispatcher dispatcher = request.getRequestDispatcher("product/delete.jsp");
    try{
  dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void editProduct(HttpServletRequest request, HttpServletResponse response) {

    int id = Integer.parseInt(request.getParameter("id"));
    float price = Float.parseFloat(request.getParameter("price"));
    String description = request.getParameter("description");
    String supplier = request.getParameter("supplier");
    String image = request.getParameter("image");
    Product product = this.productService.findById(id);
    RequestDispatcher dispatcher;
    if (product == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      product.setPrice(price);
      product.setDescription(description);
      product.setSupplier(supplier);
      product.setImage(image);
      this.productService.save(product);
      request.setAttribute("product", product);
      request.setAttribute("message", "product was edited");
      dispatcher = request.getRequestDispatcher("product/edit.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void createProduct(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    float price = Float.parseFloat(request.getParameter("price"));
    String description = request.getParameter("description");
    String supplier = request.getParameter("supplier");
    String image = request.getParameter("image");
    Product product = new Product(id, name, price, description, supplier, image);
    productService.save(product);
    request.setAttribute("message", "new Product was created");
    RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
      action = "";
    }
    switch (action) {
      case "create":
        showCreateForm(request, response);
        break;
      case "edit":
        showEditForm(request, response);
        break;
      case "delete":
        showDeleteForm(request,response);
        break;
      case "view":

        break;
      default:
        showListProducts(request, response);

        break;
    }
  }

  private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = productService.findById(id);
    RequestDispatcher dispatcher;
    if(product == null){
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    }else{
      request.setAttribute("product",product);
      dispatcher =request.getRequestDispatcher("product/delete.jsp");
    }
    try {
      dispatcher.forward(request,response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = productService.findById(id);
    RequestDispatcher dispatcher;
    if (product == null) {
      dispatcher = request.getRequestDispatcher("error-404.jsp");
    } else {
      request.setAttribute("product", product);
      dispatcher = request.getRequestDispatcher("product/edit.jsp");
    }
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }

  private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }

  }

  private void showListProducts(HttpServletRequest request, HttpServletResponse response) {
    List<Product> products = productService.findAll();
    request.setAttribute("products", products);
    RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException | IOException e) {
      e.printStackTrace();
    }
  }
private void viewProduct(HttpServletRequest request,HttpServletResponse response){
    String name = request.getParameter("searchByName");
    Product product = productService.findByName(name);
    RequestDispatcher dispatcher;
  if(product == null){
    dispatcher = request.getRequestDispatcher("error-404.jsp");
  }else{
    request.setAttribute("product",product);
    dispatcher =request.getRequestDispatcher("product/view.jsp");
  }
  try {
    dispatcher.forward(request,response);
  } catch (ServletException | IOException e) {
    e.printStackTrace();
  }
}

}
