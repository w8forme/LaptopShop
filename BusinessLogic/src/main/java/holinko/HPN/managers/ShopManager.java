package holinko.HPN.managers;

import holinko.HPN.entity.Storage;

import java.util.List;

/**
 * Created by Pavel
 */
public interface ShopManager
{
    List<Storage> showLaptops();
    void addLaptop(Long laptopId);
    void deleteLaptop(Long laptopId);
    void buyLaptop(Long laptopId);
    void addPhoto(Long laptopId, String photoUrl);
}
