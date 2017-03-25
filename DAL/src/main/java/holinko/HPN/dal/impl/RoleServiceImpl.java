package holinko.HPN.dal.impl;

import holinko.HPN.dal.RoleService;
import holinko.HPN.entity.Role;
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
@Repository("roleDao")
public class RoleServiceImpl implements RoleService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);
    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role findById(Long id)
    {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public Role save(Role role)
    {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
        LOGGER.info("Role save with id - "+ role.getId());
        return role;
    }
}
