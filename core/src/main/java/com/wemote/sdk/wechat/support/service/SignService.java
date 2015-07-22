package com.wemote.sdk.wechat.support.service;

import com.wemote.sdk.wechat.util.crypto.SHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

/**
 * @author: jayon.xu@gmail.com
 */
public class SignService {

    private static final Logger LOG = LoggerFactory.getLogger(SignService.class);

    /**
     * 验证签名
     *
     * @param signature
     * @param token
     * @param timestamp
     * @param nonce
     * @return 是否验证成功
     */
    public static boolean checkSignature(String signature, String token, String timestamp, String nonce) {
        try {
            String gen = SHA1.gen(token, timestamp, nonce);
            // 将sha1加密后的字符串可与signature对比
            return gen != null ? gen.equals(signature.toUpperCase()) : Boolean.FALSE;
        } catch (NoSuchAlgorithmException e) {
            LOG.warn("Check signature error! the error msg:{}", e.getMessage());
            e.printStackTrace();
        }

        return Boolean.FALSE;

    }
}
