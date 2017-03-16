package com.dms.oauth.web;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dms.inf.exception.AppBizException;
import com.dms.oauth.inf.user.cmd.ChangePasswordCmd;
import com.dms.oauth.inf.user.cmd.CreateUserCmd;
import com.dms.oauth.inf.user.cmd.DeleteUserCmd;
import com.dms.oauth.inf.user.cmd.UpdateUserCmd;
import com.dms.oauth.inf.user.svc.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;
    
    @RequestMapping(value = "/create")
    public Object create(CreateUserCmd cmd) throws AppBizException {
    	cmd.setIdUser(UUID.randomUUID().toString());
        userService.createUser(cmd);
        return cmd;
    }

    @RequestMapping(value = "/update")
    public Object update(UpdateUserCmd cmd) {
        userService.updateUser(cmd);
        return cmd;
    }

    @RequestMapping(value = "/delete/{idUser}")
    public Object delete(DeleteUserCmd cmd) {
        userService.deleteUser(cmd);
        return cmd;
    }

    @RequestMapping(value = "/changePassword/{userId}/{newPassword}")
    public Object changePassword(ChangePasswordCmd cmd) {
        userService.changePassword(cmd);
        return cmd;
    }
    
    @RequestMapping(value = "/redis/{key}/{value}")
    public String redis(String key,String value) {
    	listOps.leftPush("k2", "v2");
        // or use template directly
        redisTemplate.boundListOps("k1").leftPush("v1");
//        redisTemplate.boundValueOps(key).
        return "hello redis";
    }

}
