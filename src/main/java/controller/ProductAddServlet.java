package controller;

import model.Invoice;
import model.TaxType;
import services.InvoiceService;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet("/add-product")
public class ProductAddServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceID = Long.parseLong(req.getParameter("invoiceId"));

        req.setAttribute("invoiceId", invoiceID);

        req.getRequestDispatcher("add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceId = Long.parseLong(req.getParameter("invoice_which_i_should_add_product_to"));
        Optional<Invoice> optionalInvoice = invoiceService.getById(invoiceId);

        if (optionalInvoice.isPresent()) {
            Invoice invoice = optionalInvoice.get();

            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            TaxType taxType = TaxType.valueOf(req.getParameter("tax_type"));
            int stock = Integer.parseInt(req.getParameter("stock"));

            productService.add(invoice, name, price, taxType, stock);

            resp.sendRedirect("/invoice-list");
        }
    }
}
