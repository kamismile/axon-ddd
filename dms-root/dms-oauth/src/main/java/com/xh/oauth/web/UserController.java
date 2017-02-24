package com.xh.oauth.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xh.dms.base.exception.AppBizException;
import com.xh.oauth.inf.user.cmd.ChangePasswordCmd;
import com.xh.oauth.inf.user.cmd.CreateUserCmd;
import com.xh.oauth.inf.user.cmd.DeleteUserCmd;
import com.xh.oauth.inf.user.cmd.UpdateUserCmd;
import com.xh.oauth.inf.user.svc.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
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

}
