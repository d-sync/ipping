package com.ipping.demo.service.interfaces;

import com.ipping.demo.model.User;

public interface UserService extends CommonService<User> {

    User getByEmail(String email);
}
