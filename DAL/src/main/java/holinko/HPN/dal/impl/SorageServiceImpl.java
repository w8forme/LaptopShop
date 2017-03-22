package holinko.HPN.dal.impl;

import holinko.HPN.dal.SorageService;
import holinko.HPN.entity.Storage;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Pavel
 */
@Transactional
@Repository("storageDao")
public class SorageServiceImpl implements SorageService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SorageServiceImpl.class);
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Storage> getAll()
    {
        return sessionFactory.getCurrentSession().createQuery("from STORAGE").list();
    }

    @Override
    public Storage findById(Long id)
    {
        return (Storage) sessionFactory.getCurrentSession().get(Storage.class, id);
    }

    @Override
    public Storage save(Storage storage)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(storage);
        LOGGER.info("Storage save with id - "+ storage.getId());
        return storage;
    }

    @Override
    public void delete(Storage storage)
    {
        sessionFactory.getCurrentSession().delete(storage);
        LOGGER.info("Delete storage");
    }
}
