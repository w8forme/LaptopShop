package holinko.HPN.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel
 */
@Entity
@Table(name = "role")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_role", nullable = false)
    private String userRole;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Customer> customers = new HashSet<>();

    public Role()
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

    public String getUserRole()
    {
        return userRole;
    }

    public void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }

    public Set<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(Set<Customer> customers)
    {
        this.customers = customers;
    }

    @Override
    public String toString()
    {
        return "Role{" +
                "id=" + id +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
