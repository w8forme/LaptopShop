package holinko.HPN.dal.impl;

import holinko.HPN.dal.RoleService;
import holinko.HPN.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Pavel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app-context-annotation.xml"})
public class RoleServiceImplTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImplTest.class);

    @Autowired
    private RoleService roleService;

    @Test
    public void testSaveAndFindByID() throws Exception
    {
        LOGGER.info("Save role test");
        Role roleForSave = new Role();
        roleForSave.setUserRole("TEST_ROLE");
        roleService.save(roleForSave);
        Role roleAfterSave = roleService.findById(roleForSave.getId());
        Assert.assertEquals(roleForSave.getUserRole(), roleAfterSave.getUserRole());
        Assert.assertEquals(roleForSave.getId(), roleAfterSave.getId());
    }
}