package holinko.HPN.dal;

import holinko.HPN.entity.Customer;

/**
 * Created by Pavel
 */
public interface UserService
{
    Customer findByName(String name);
    Customer save(Customer user);
}
