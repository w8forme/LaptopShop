package holinko.HPN.dal.impl;

import holinko.HPN.dal.StorageService;
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
public class StorageServiceImplTest
{

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImplTest.class);

    @Autowired
    private StorageService storageService;


    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void getAll() throws Exception
    {
        System.out.println(storageService.getAll());
    }

    @Test
    public void findById() throws Exception
    {
        System.out.println(storageService.findById(1L));
    }

    @Test
    public void save() throws Exception
    {

    }

    @Test
    public void delete() throws Exception
    {

    }

}