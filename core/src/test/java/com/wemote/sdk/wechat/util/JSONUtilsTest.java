package com.wemote.sdk.wechat.util;

import com.jayway.jsonpath.JsonPath;
import com.wemote.sdk.wechat.domain.access.AccessToken;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author: jayon.xu@gmail.com
 */
public class JSONUtilsTest {

    @Test
    public void testParseObject() throws Exception {
        String accessTokenJSONStr = "{\n" +
                "    \"access_token\": \"Mfv_j0Co8QGi_tl6hkpIdkryp8PvrX-SNkzgwK29S5bEm3CTov-oufUQBGj7dS6jglwSsm7XVaVARaPXOzxx6ZKUZ2IKph8pr8a2HkChuwQ\", \n" +
                "    \"expires_in\": 7200\n" +
                "}";

        AccessToken accessToken = JSONUtils.parseObject(accessTokenJSONStr, AccessToken.class);

        Assert.assertEquals("Mfv_j0Co8QGi_tl6hkpIdkryp8PvrX-SNkzgwK29S5bEm3CTov-oufUQBGj7dS6jglwSsm7XVaVARaPXOzxx6ZKUZ2IKph8pr8a2HkChuwQ", accessToken.getAccessToken());
    }

    @Test
    public void testToJSONString() throws Exception {
        String accessToken = JSONUtils.toJSONString(new AccessToken("access_token", 7200));

        assertThat(JsonPath.<String>read(accessToken, "access_token"), is("access_token"));
    }

    @Test
    public void testStringToJSONString_shouldSuccess() throws Exception{
        String msgId = "abc";
        String msgIdJSONStr = JSONUtils.toJSONString(msgId);

        System.out.println(msgIdJSONStr);
    }
}