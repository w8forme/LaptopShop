package holinko.HPN.managers;

import holinko.HPN.entity.Customer;

/**
 * Created by Pavel
 */
public interface UserManager
{
    Customer findUserByName(String name);
    Customer saveUser(Customer user);
}
