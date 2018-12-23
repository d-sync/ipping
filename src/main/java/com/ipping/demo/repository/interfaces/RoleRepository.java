package com.ipping.demo.repository.interfaces;

import com.ipping.demo.model.Role;

public interface RoleRepository extends CommonGenericRepository<Role> {

    Role getByRoleName(String roleName);

}
