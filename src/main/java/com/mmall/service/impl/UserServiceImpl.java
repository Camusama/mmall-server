package com.mmall.service.impl;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.dao.UserMapper;
import com.mmall.pojo.Role;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import com.mmall.util.MD5Util;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//注入给controller调用，首字母小写
@Service("iUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param labor_id
     * @param password
     * @return
     */
    public User login(String labor_id, String password) {
//      TODO 密码录入加密
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user  = userMapper.selectLogin(labor_id,password);
//        用户名或密码错误
        if(user == null){
            return null;
        }
        // 返回明文里将密码 置空
        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return user;
    }

    /**
     * 获取单用户角色表
     * @param id
     * @return
     */
    public List<Role> getRoleList(Integer id) {
        return userMapper.getRoleList(id);
    }

    /**
     * 用户校验
     * @param str
     * @param type
     * @return
     */
    public ServerResponse<String> checkValid(String str,String type){
        if(org.apache.commons.lang3.StringUtils.isNotBlank(type)){
            //开始校验
            if(Const.USERNAME.equals(type)){
                int resultCount = userMapper.checkUsername(str);
                if(resultCount > 0 ){
                    return ServerResponse.createByErrorMessage("工号已存在");
                }
            }
        }else{
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
}
}
