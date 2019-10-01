package controller;

import model.Invoice;
import model.Product;
import services.InvoiceService;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("invoiceId") != null){
            Long invoiceId = Long.parseLong(req.getParameter("invoiceId"));
            Optional<Invoice> optionalInvoice = invoiceService.getById(invoiceId);
            if (optionalInvoice.isPresent()){
                Invoice invoice = optionalInvoice.get();
                req.setAttribute("product_list", invoice.getProduct());
            }
            req.getRequestDispatcher("product-list.jsp").forward(req, resp);
        }else {
            List<Product> products = productService.listAll();
            req.setAttribute("product_list", products);
            req.getRequestDispatcher("product-list.jsp").forward(req, resp);
        }
    }
}
