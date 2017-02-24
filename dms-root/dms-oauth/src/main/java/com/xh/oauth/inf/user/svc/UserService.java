package com.xh.oauth.inf.user.svc;

import com.xh.dms.base.exception.AppBizException;
import com.xh.oauth.inf.user.cmd.ChangePasswordCmd;
import com.xh.oauth.inf.user.cmd.CreateUserCmd;
import com.xh.oauth.inf.user.cmd.DeleteUserCmd;
import com.xh.oauth.inf.user.cmd.UpdateUserCmd;

public interface UserService {
   
    public void createUser(CreateUserCmd cmd) throws AppBizException;

    public void updateUser(UpdateUserCmd cmd);
    
    public void deleteUser(DeleteUserCmd cmd);

    public void changePassword(ChangePasswordCmd cmd);

}
