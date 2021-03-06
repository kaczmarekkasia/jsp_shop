package services;

import database.EntityDao;
import model.Invoice;
import model.Product;
import model.TaxType;

import java.util.List;
import java.util.Optional;

public class ProductService {

    EntityDao dao = new EntityDao();

    public List<Product> listAll(){
        return dao.getAll(Product.class);
    }

    public void add(Invoice invoice, String name, double price, TaxType taxType, int stock){
        Product product = new Product(name, price, taxType, stock);

        product.setInvoice(invoice);

        dao.saveOrUpdate(product);
    }


    public void romoveByID(Long productToRemoveId) {
        dao.delete(Product.class, productToRemoveId);
    }

    public Optional<Product> findById(Long productToEditId) {
        return dao.getById(Product.class, productToEditId);
    }

    public void update(Product editedProduct) {
        dao.saveOrUpdate(editedProduct);
    }
}


