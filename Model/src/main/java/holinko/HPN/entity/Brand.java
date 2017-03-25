package holinko.HPN.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "brand")
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products = new HashSet<>();

    public Brand()
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

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
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
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
