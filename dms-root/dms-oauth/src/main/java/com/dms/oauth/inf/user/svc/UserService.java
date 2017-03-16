package com.dms.oauth.inf.user.svc;

import com.dms.inf.exception.AppBizException;
import com.dms.oauth.inf.user.cmd.ChangePasswordCmd;
import com.dms.oauth.inf.user.cmd.CreateUserCmd;
import com.dms.oauth.inf.user.cmd.DeleteUserCmd;
import com.dms.oauth.inf.user.cmd.UpdateUserCmd;

public interface UserService {
   
    public void createUser(CreateUserCmd cmd) throws AppBizException;

    public void updateUser(UpdateUserCmd cmd);
    
    public void deleteUser(DeleteUserCmd cmd);

    public void changePassword(ChangePasswordCmd cmd);

}
