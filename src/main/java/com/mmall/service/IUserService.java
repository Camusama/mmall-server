package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Role;
import com.mmall.pojo.User;

import java.util.List;

public interface IUserService {
    User login(String labor_id, String password);

    List<Role> getRoleList(Integer id);

    ServerResponse<String> checkValid(String str,String type);
}
