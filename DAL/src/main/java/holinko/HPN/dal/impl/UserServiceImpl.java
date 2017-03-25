package holinko.HPN.dal.impl;

import holinko.HPN.dal.UserService;
import holinko.HPN.entity.Customer;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Pavel
 */
@Transactional
@Repository("userDao")
public class UserServiceImpl implements UserService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer findByName(String name)
    {
        LOGGER.info("dao: " + name);
        Customer user = (Customer) sessionFactory.getCurrentSession()
                .createQuery("SELECT u from Customer u where u.login=:login")
                .setParameter("login", name).uniqueResult();
        LOGGER.info("user dao: " + user.toString());
        return user;
    }

    @Override
    public Customer save(Customer user)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        LOGGER.info("Customer save with id - "+ user.getId());
        return user;
    }
}
