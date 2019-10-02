package controller;

import model.Product;
import model.TaxType;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/edit-product")
public class ProductEditServlet extends HttpServlet {

    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productToEditId = Long.parseLong(req.getParameter("productId"));

        Optional<Product> optionalProduct = productService.findById(productToEditId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            req.setAttribute("productId", product.getId());
            req.setAttribute("productName", product.getName());
            req.setAttribute("productPrice", product.getPrice());
            req.setAttribute("productTaxType", product.getTaxType());
            req.setAttribute("productStock", product.getStock());

            req.getRequestDispatcher("add-product.jsp").forward(req, resp);

        } else { //jeśli nie uda się znaleźć studenta to
            resp.sendRedirect("/product-add");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long productToEditId = Long.parseLong(req.getParameter("productId"));

        String name = req.getParameter("name" );
        Double price = Double.parseDouble(req.getParameter("price" ));
        TaxType taxType = TaxType.valueOf(req.getParameter("tax_type" ));
        Integer stock = Integer.parseInt(req.getParameter("stock"));

        Product editedProduct = new Product(productToEditId, name, price,taxType,stock);

        productService.update(editedProduct);

        resp.sendRedirect("/invoice-list");


    }
}
