package holinko.HPN.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "processor")
public class Processor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "proc_name", nullable = false)
    private String procName;

    @OneToMany(mappedBy = "processor")
    private Set<Product> products = new HashSet<>();

    public Processor()
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

    public String getProcName()
    {
        return procName;
    }

    public void setProcName(String procName)
    {
        this.procName = procName;
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
        return "Processor{" +
                "id=" + id +
                ", procName='" + procName + '\'' +
                '}';
    }
}
