package holinko.HPN.dal;

import holinko.HPN.entity.Storage;

import java.util.List;

/**
 * Created by Pavel
 */
public interface SorageService
{
    List<Storage> getAll();
    Storage findById(Long id);
    Storage save(Storage storage);
    void delete(Storage storage);
}
