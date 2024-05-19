package analyzer.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Shop", schema = "public")
public class Shop {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "shop")
    private List<Base> bases;

    @Id
    @SequenceGenerator(name = "shop_seq", sequenceName = "shop_sequence", allocationSize = 1)
    @GeneratedValue(generator = "shop_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public Shop() {
    }

    public Shop(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}