package holinko.HPN.dal.impl;

import holinko.HPN.dal.StorageService;
import holinko.HPN.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ProcessArrayCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

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

    @Test
    public void getAll() throws Exception
    {
        final int NUMBER_OF_LAPTOPS = 10;
        LOGGER.info("Test get all laptops");
        Collection<Storage> laptops = storageService.getAll();
        Assert.assertNotNull(laptops);
        Assert.assertEquals(NUMBER_OF_LAPTOPS, laptops.size());
        for (Storage testStorage : laptops)
        {
            LOGGER.debug(testStorage.toString());
        }
    }

    @Test
    public void findById() throws Exception
    {
        LOGGER.info("Test find by ID StorageService");
        Storage laptopForSave = new Storage();
        Product productForSave = new Product();
        Brand brand = new Brand();
        Display display = new Display();
        Processor processor = new Processor();
        Ram ram = new Ram();
        brand.setBrandName("TEST_BRAND");
        display.setDisplaySize("TEST_DISPLAY");
        processor.setProcName("TEST_PROCESSOR");
        ram.setRamSize("TEST_RAM");
        productForSave.setBrand(brand);
        productForSave.setDisplay(display);
        productForSave.setProcessor(processor);
        productForSave.setRam(ram);
        brand.getProducts().add(productForSave);
        display.getProducts().add(productForSave);
        processor.getProducts().add(productForSave);
        ram.getProducts().add(productForSave);
        laptopForSave.setProduct(productForSave);
        laptopForSave.setPhoto("findTest.jpg");
        laptopForSave.setAmount(10);
        laptopForSave.setPrice(5000.0);
        storageService.save(laptopForSave);
        Storage laptopAfterSave = storageService.findById(laptopForSave.getId());
        Assert.assertEquals(laptopForSave.getId(), laptopAfterSave.getId());
        Assert.assertEquals(laptopForSave.getAmount(), laptopAfterSave.getAmount());
        Assert.assertEquals(laptopForSave.getPrice(), laptopAfterSave.getPrice());
        Assert.assertEquals(laptopForSave.getPhoto(), laptopAfterSave.getPhoto());
        Assert.assertEquals(laptopForSave.getProduct().getBrand().getBrandName(),
                laptopAfterSave.getProduct().getBrand().getBrandName());
        Assert.assertEquals(laptopForSave.getProduct().getProcessor().getProcName(),
                laptopAfterSave.getProduct().getProcessor().getProcName());
        storageService.delete(laptopForSave);
    }

    @Test
    public void save() throws Exception
    {
        LOGGER.info("Test save StorageService");
        Storage laptopForSave = new Storage();
        Product productForSave = new Product();
        Brand brand = new Brand();
        Display display = new Display();
        Processor processor = new Processor();
        Ram ram = new Ram();
        brand.setBrandName("TEST_BRAND");
        display.setDisplaySize("TEST_DISPLAY");
        processor.setProcName("TEST_PROCESSOR");
        ram.setRamSize("TEST_RAM");
        productForSave.setBrand(brand);
        productForSave.setDisplay(display);
        productForSave.setProcessor(processor);
        productForSave.setRam(ram);
        brand.getProducts().add(productForSave);
        display.getProducts().add(productForSave);
        processor.getProducts().add(productForSave);
        ram.getProducts().add(productForSave);
        laptopForSave.setProduct(productForSave);
        laptopForSave.setPhoto("saveTest.jpg");
        laptopForSave.setAmount(20);
        laptopForSave.setPrice(6000.0);
        storageService.save(laptopForSave);
        Storage laptopAfterSave = storageService.findById(laptopForSave.getId());
        Assert.assertEquals(laptopForSave.getId(), laptopAfterSave.getId());
        Assert.assertEquals(laptopForSave.getAmount(), laptopAfterSave.getAmount());
        Assert.assertEquals(laptopForSave.getPrice(), laptopAfterSave.getPrice());
        Assert.assertEquals(laptopForSave.getPhoto(), laptopAfterSave.getPhoto());
        Assert.assertEquals(laptopForSave.getProduct().getBrand().getBrandName(),
                laptopAfterSave.getProduct().getBrand().getBrandName());
        Assert.assertEquals(laptopForSave.getProduct().getProcessor().getProcName(),
                laptopAfterSave.getProduct().getProcessor().getProcName());
        storageService.delete(laptopForSave);
    }

    @Test
    public void delete() throws Exception
    {
        LOGGER.info("Test delete StorageService");
        Storage laptopForDelete = new Storage();
        Product productForDelete = new Product();
        Brand brand = new Brand();
        Display display = new Display();
        Processor processor = new Processor();
        Ram ram = new Ram();
        brand.setBrandName("TEST_BRAND");
        display.setDisplaySize("TEST_DISPLAY");
        processor.setProcName("TEST_PROCESSOR");
        ram.setRamSize("TEST_RAM");
        productForDelete.setBrand(brand);
        productForDelete.setDisplay(display);
        productForDelete.setProcessor(processor);
        productForDelete.setRam(ram);
        brand.getProducts().add(productForDelete);
        display.getProducts().add(productForDelete);
        processor.getProducts().add(productForDelete);
        ram.getProducts().add(productForDelete);
        laptopForDelete.setProduct(productForDelete);
        laptopForDelete.setPhoto("deleteTest.jpg");
        laptopForDelete.setAmount(15);
        laptopForDelete.setPrice(7000.0);
        storageService.save(laptopForDelete);
        storageService.delete(laptopForDelete);
        Storage laptopAfterSave = storageService.findById(laptopForDelete.getId());
        Assert.assertNull(laptopAfterSave);
    }
}