package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Invoice implements IBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    @Column()
    protected LocalDateTime dateOfCreation;
    @Column(nullable = false)
    private String clientName;
    @Column(length = 10)
    private String NIP;
    private String adress;
    @Column(nullable = false, columnDefinition = " tinyint default 0")
    private boolean ifPaid;
    private LocalDateTime dateOfRelease;
    private LocalDateTime dateOfPayment;
    @Formula(value = "(SELECT SUM(p.price * p.stock) from product p where p.invoice_id = id)")
    private Double billValue;
    @OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER)
    private List<Product> product;

    public Invoice(String clientName, String NIP, String adress) {
        this.clientName = clientName;
        this.NIP = NIP;
        this.adress = adress;
    }

    public void release(){
        this.dateOfRelease = LocalDateTime.now();
    }

    public void paid(){
        this.dateOfPayment = LocalDateTime.now();
    }
}
