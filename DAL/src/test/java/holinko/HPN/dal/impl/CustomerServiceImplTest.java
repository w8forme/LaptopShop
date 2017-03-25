package holinko.HPN.dal.impl;

import holinko.HPN.dal.UserService;
import holinko.HPN.entity.Customer;
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


    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void findByName() throws Exception
    {
        Customer user = userService.findByName("john12");
        System.out.println("user dao: " + user);
    }

    @Test
    public void save() throws Exception
    {

    }
}