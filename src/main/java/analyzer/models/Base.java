package analyzer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Base", schema = "public")
public class Base {
    @Column(name = "price")
    private Long price;
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="shop_id")
    private Shop shop;

    @Id
    @SequenceGenerator(name = "base_seq", sequenceName = "base_sequence", allocationSize = 1)
    @GeneratedValue(generator = "base_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public Base() {
    }

    public Base(Long price, Date time, Shop shop, Product product, long id) {
        this.price = price;
        this.time = time;
        this.shop = shop;
        this.product = product;
        this.id = id;
    }

    public Base(Long price, Date time, Shop shop, Product product) {
        this.price = price;
        this.time = time;
        this.shop = shop;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public Long getPrice() {
        return price;
    }

    public Date getTime() {
        return time;
    }

    public Product getProduct() {
        return product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}