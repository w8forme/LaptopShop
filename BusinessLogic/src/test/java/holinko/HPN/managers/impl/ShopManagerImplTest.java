package holinko.HPN.managers.impl;

import holinko.HPN.dal.StorageService;
import holinko.HPN.managers.ShopManager;
import org.junit.After;
import org.junit.Before;
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
public class ShopManagerImplTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ShopManagerImplTest.class);

    @Autowired
    private ShopManager shopManager;

    @Before
    public void setUp() throws Exception
    {

    }

    @After
    public void tearDown() throws Exception
    {

    }

    @Test
    public void showLaptops() throws Exception
    {
    }

    @Test
    public void addLaptop() throws Exception
    {
        shopManager.addLaptop(1L);
    }

    @Test
    public void deleteLaptop() throws Exception
    {
        shopManager.deleteLaptop(1L);
    }

    @Test
    public void buyLaptop() throws Exception
    {

    }

    @Test
    public void addPhoto() throws Exception
    {

    }

}