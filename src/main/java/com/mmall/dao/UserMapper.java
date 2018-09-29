package com.mmall.dao;

import com.mmall.pojo.Role;
import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String labor_id);

    int checkPassword(@Param(value="password")String password,@Param("userId")Integer userId);

    /**
     * 用户登录
     * @param labor_id
     * @param password
     * @return
     */
    User selectLogin(@Param("labor_id") String labor_id, @Param("password")String password);

    /**
     * 获取对应的角色和权限
     * @param id
     * @return
     */
    List<Role> getRoleList(Integer id);

    int updatePasswordByUsername(@Param("labor_id")String labor_id, @Param("passwordNew")String passwordNew);

}