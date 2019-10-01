package controller;

import model.Invoice;
import services.InvoiceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet("/edit-invoice")
public class InvoiceReleaseServlet extends HttpServlet {

    private final InvoiceService invoiceService = new InvoiceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long invoiceToEditId = Long.parseLong(req.getParameter("invoiceId"));

        Optional<Invoice> optionalInvoice = invoiceService.getById(invoiceToEditId);

        if(optionalInvoice.isPresent()){
            Invoice invoice = optionalInvoice.get();
            invoice.setDateOfRelease(LocalDateTime.now());

            invoiceService.update(invoice);

            resp.sendRedirect("/invoice-list?invoiceId=" + invoiceToEditId);
        }

    }

}
