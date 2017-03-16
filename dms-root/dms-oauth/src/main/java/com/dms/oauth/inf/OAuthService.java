package com.dms.oauth.inf;

import com.dms.oauth.inf.client.cmd.CheckClientIdCmd;

public interface OAuthService {

	//添加 auth code
    public void addAuthCode(String authCode, String username);
    //添加 access token
    public void addAccessToken(String accessToken, String username);

    //验证auth code是否有效
    boolean checkAuthCode(String authCode);
    //验证access token是否有效
    boolean checkAccessToken(String accessToken);

    String getUsernameByAuthCode(String authCode);
    String getUsernameByAccessToken(String accessToken);


    //auth code / access token 过期时间
    long getExpireIn();


    public boolean checkClientId(CheckClientIdCmd checkClientIdCmd);

    public boolean checkClientSecret(String clientSecret);
}
