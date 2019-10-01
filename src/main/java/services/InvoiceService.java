package services;

import database.EntityDao;
import model.Invoice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class InvoiceService {
    EntityDao dao = new EntityDao();

    public List<Invoice> listAll(){
        return dao.getAll(Invoice.class);
    }

    public void add(String clientName, String NIP, String adress){
        dao.saveOrUpdate(new Invoice(clientName, NIP, adress));
    }

    public Optional<Invoice> getById(Long id){
        return dao.getById(Invoice.class, id);
    }

    public void update(Invoice invoiceEdited){
        dao.saveOrUpdate(invoiceEdited);
    }
}
