package holinko.HPN.managers.impl;

import holinko.HPN.dal.StorageService;
import holinko.HPN.dal.impl.StorageServiceImpl;
import holinko.HPN.entity.Storage;
import holinko.HPN.managers.ShopManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Pavel
 */
@Service("shopManager")
public class ShopManagerImpl implements ShopManager
{

    private static Logger LOGGER = LoggerFactory.getLogger(ShopManagerImpl.class);
    @Autowired
    private StorageService storageService;


    @Override
    public List<Storage> showLaptops()
    {
        LOGGER.info("Get all laptops");
        return storageService.getAll();
    }

    @Override
    public void addLaptop(Long laptopId)
    {
        LOGGER.info("Add 1 laptop");
        Storage currentLaptop = storageService.findById(laptopId);
        Integer amountLaptops = currentLaptop.getAmount();
        currentLaptop.setAmount(amountLaptops + 1);
        storageService.save(currentLaptop);
    }

    @Override
    public void deleteLaptop(Long laptopId)
    {
        LOGGER.info("Delete 1 laptop");
        Storage currentLaptop = storageService.findById(laptopId);
        Integer amountLaptops = currentLaptop.getAmount();
        currentLaptop.setAmount(amountLaptops - 1);
        storageService.save(currentLaptop);
    }

    @Override
    public void buyLaptop(Long laptopId)
    {
        LOGGER.info("Buy 1 laptop");
        deleteLaptop(laptopId);
    }

    @Override
    public void addPhoto(Long laptopId, String photoUrl)
    {
        LOGGER.info("Add laptop photo");
        Storage currentLaptop = storageService.findById(laptopId);
        currentLaptop.setPhoto(photoUrl);
        storageService.save(currentLaptop);
    }
}
