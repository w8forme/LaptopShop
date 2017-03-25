package holinko.HPN.managers.impl;

import holinko.HPN.dal.RoleService;
import holinko.HPN.dal.UserService;
import holinko.HPN.entity.Customer;
import holinko.HPN.managers.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Pavel
 */
@Service("userManager")
public class UserManagerImpl implements UserManager
{

    private static Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public Customer findUserByName(String name)
    {
        LOGGER.info("Find user by name: " + name);
        Customer user = userService.findByName(name);
        LOGGER.info(user.toString());
        return user;
    }

    @Override
    public Customer saveUser(Customer user)
    {
        LOGGER.info("Save user");
        user.setRole(roleService.findById(1L));
        return userService.save(user);
    }
}
