package services;

import database.EntityDao;
import model.Invoice;
import model.Product;
import model.TaxType;

import java.util.List;

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


}


