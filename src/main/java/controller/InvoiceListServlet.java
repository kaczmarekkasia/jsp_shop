package controller;

import model.Invoice;
import services.InvoiceService;
import services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/invoice-list")
public class InvoiceListServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Invoice> invoiceList = invoiceService.listAll();

        req.setAttribute("invoice_list", invoiceList);

        req.getRequestDispatcher("invoice-list.jsp").forward(req, resp);
    }
}
