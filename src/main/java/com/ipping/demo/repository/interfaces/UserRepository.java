package com.ipping.demo.repository.interfaces;

import com.ipping.demo.model.User;

public interface UserRepository extends CommonGenericRepository<User> {

    User getByEmail(String email);
}
