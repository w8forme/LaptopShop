package holinko.HPN.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "display")
public class Display
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "display_size", nullable = false)
    private String displaySize;

    @OneToMany(mappedBy = "display")
    private Set<Product> products = new HashSet<>();

    public Display()
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

    public String getDisplaySize()
    {
        return displaySize;
    }

    public void setDisplaySize(String displaySize)
    {
        this.displaySize = displaySize;
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
        return "Display{" +
                "id=" + id +
                ", displaySize='" + displaySize + '\'' +
                '}';
    }
}
