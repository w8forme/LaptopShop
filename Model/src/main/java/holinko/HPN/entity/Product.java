package holinko.HPN.entity;

import javax.persistence.*;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "PRODUCT")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "ram_id")
    private Ram ram;

    @ManyToOne
    @JoinColumn(name = "processor_id")
    private Processor processor;

    @ManyToOne
    @JoinColumn(name = "display_id")
    private Display display;

    public Product()
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

    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand(Brand brand)
    {
        this.brand = brand;
    }

    public Ram getRam()
    {
        return ram;
    }

    public void setRam(Ram ram)
    {
        this.ram = ram;
    }

    public Processor getProcessor()
    {
        return processor;
    }

    public void setProcessor(Processor processor)
    {
        this.processor = processor;
    }

    public Display getDisplay()
    {
        return display;
    }

    public void setDisplay(Display display)
    {
        this.display = display;
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "id=" + id +
                ", brand=" + brand +
                ", ram=" + ram +
                ", processor=" + processor +
                ", display=" + display +
                '}';
    }
}
