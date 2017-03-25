package holinko.HPN.dal;

import holinko.HPN.entity.Role;

/**
 * Created by Pavel
 */
public interface RoleService
{
    Role findById(Long id);
    Role save(Role role);
}
