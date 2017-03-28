package holinko.HPN.dal.impl;

import holinko.HPN.dal.UserService;
import holinko.HPN.entity.Customer;
import holinko.HPN.entity.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Pavel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context-annotation.xml"})
public class CustomerServiceImplTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImplTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void testFindByName() throws Exception
    {
        LOGGER.info("Find user by name");
        Customer customerForAdd = new Customer();
        customerForAdd.setLogin("Alex");
        customerForAdd.setPassword("123");
        Role role = new Role();
        role.setUserRole("TEST_ROLE");
        role.getCustomers().add(customerForAdd);
        customerForAdd.setRole(role);
        LOGGER.info(role.toString());
        userService.save(customerForAdd);
        Customer customerAfterAdd = userService.findByName("Alex");
        Assert.assertEquals(customerForAdd.getLogin(), customerAfterAdd.getLogin());
        Assert.assertEquals(customerForAdd.getPassword(), customerAfterAdd.getPassword());
        Assert.assertEquals(customerForAdd.getRole().getUserRole(), customerAfterAdd.getRole().getUserRole());
    }

    @Test
    public void testSave() throws Exception
    {
        LOGGER.info("Test user save");
        Customer customerForSave = new Customer();
        customerForSave.setLogin("Max");
        customerForSave.setPassword("12345");
        Role role = new Role();
        role.setUserRole("TEST_ROLE");
        role.getCustomers().add(customerForSave);
        customerForSave.setRole(role);
        LOGGER.info(role.toString());
        userService.save(customerForSave);
        Customer customerAfterSave = userService.findByName("Max");
        Assert.assertEquals(customerForSave.getLogin(), customerAfterSave.getLogin());
        Assert.assertEquals(customerForSave.getPassword(), customerAfterSave.getPassword());
        Assert.assertEquals(customerForSave.getRole().getUserRole(), customerAfterSave.getRole().getUserRole());
    }
}