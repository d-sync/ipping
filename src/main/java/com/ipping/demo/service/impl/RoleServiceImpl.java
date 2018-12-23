package com.ipping.demo.service.impl;

import com.ipping.demo.model.Role;
import com.ipping.demo.repository.interfaces.RoleRepository;
import com.ipping.demo.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends CommonServiceImpl<Role> implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getByRoleName(roleName);
    }
}
