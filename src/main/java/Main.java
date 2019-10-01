import database.EntityDao;
import model.Invoice;
import model.Product;
import model.TaxType;
import services.InvoiceService;

public class Main {
    public static void main(String[] args) {

        EntityDao dao = new EntityDao();

        Invoice i = new Invoice("jakiś", "1234567890", "jakiś");

        dao.saveOrUpdate(i);

        Product p = new Product("a", 2.3, TaxType.PRODUCT, 3);

        dao.saveOrUpdate(p);

        System.out.println(p.getTaxValue());


    }
}
