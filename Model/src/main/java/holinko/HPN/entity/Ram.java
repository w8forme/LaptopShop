package holinko.HPN.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "RAM")
public class Ram
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ram_size", nullable = false)
    private String ramSize;

    @OneToMany(mappedBy = "ram")
    private Set<Product> products = new HashSet<>();

    public Ram()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getRamSize()
    {
        return ramSize;
    }

    public void setRamSize(String ramSize)
    {
        this.ramSize = ramSize;
    }

    public Set<Product> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        return "Ram{" +
                "id=" + id +
                ", ramSize='" + ramSize + '\'' +
                '}';
    }
}
