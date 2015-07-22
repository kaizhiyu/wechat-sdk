package com.wemote.sdk.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: jayon.xu@gmail.com
 */
public class Entity {

    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private int expiresIn;

    // 静态工厂方法
    @JSONCreator
    public static Entity create(@JSONField(name = "access_token") String accessToken, @JSONField(name = "expires_in") int expiresIn) {
        System.out.println(accessToken);
        Entity entity = new Entity();
        entity.setAccessToken(accessToken);
        entity.setExpiresIn(expiresIn);
        return entity;
    }

    private Entity(){}
    private Entity(String accessToken, int expiresIn) {
        this.setAccessToken(accessToken);
        this.setExpiresIn(expiresIn);
    }

    @JSONField(name = "access_token")
    private void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JSONField(name = "expires_in")
    private void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public static void main(String[] args){
        String tmp = "{\n" +
                "    \"access_token\": \"Mfv_j0Co8QGi_tl6hkpIdkryp8PvrX-SNkzgwK29S5bEm3CTov-oufUQBGj7dS6jglwSsm7XVaVARaPXOzxx6ZKUZ2IKph8pr8a2HkChuwQ\", \n" +
                "    \"expires_in\": 7200\n" +
                "}";
        Entity entity = JSON.parseObject(tmp, Entity.class);
        System.out.println(entity.getAccessToken());
    }


}
