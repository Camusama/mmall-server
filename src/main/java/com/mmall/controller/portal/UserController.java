package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ServerResponse;
import com.mmall.common.method.cache.UserCache;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// service->mybatis->dao
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;
//    此处iUserService的名字和UserServiceImpl里的@Service("iUserService")对应



//    用户登录
    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, String> map1, HttpSession session){
        String labor_id=(String) map1.get("labor_id");
        String password=(String) map1.get("password");

//      TODO 此处是在user表里找的账户
        User user = iUserService.login(labor_id,password);

        Map<String, Object> map = new HashMap<String, Object>();

//      这是前端cookie值
        String ticket = UUID.randomUUID().toString();
        map.put("ticket", ticket);

//      这是登录信息实体
        Map<String, Object> LoginResult = new HashMap<String, Object>();
        LoginResult.put("user",user);
        LoginResult.put("RList",iUserService.getRoleList(user.getId()));
        map.put("LoginResult",LoginResult);

//        此为登录效果
        UserCache.put(ticket, user);
        return map;
    }

//    登出
    @RequestMapping(value = "logout.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

//    统一校验，type为校验的字段
    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){
        return iUserService.checkValid(str,type);
    }
}
