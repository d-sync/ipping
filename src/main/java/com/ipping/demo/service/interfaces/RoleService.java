package com.ipping.demo.service.interfaces;

import com.ipping.demo.model.Role;

public interface RoleService extends CommonService<Role>{

    Role getRoleByName(String roleName);
}
