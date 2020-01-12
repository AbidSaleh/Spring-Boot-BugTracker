package com.hillel.bugtracker.repository;


import com.hillel.bugtracker.model.RoleEntity;

import java.util.List;

public interface RoleRepository {
    List<RoleEntity> getRolesList();

    void save(RoleEntity roleEntity);

    RoleEntity findByName(String roleName);

    RoleEntity createRoleIfNotFound(String name);
}
