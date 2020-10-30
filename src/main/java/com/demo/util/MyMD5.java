package com.demo.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyMD5 {
    private static final String KEY_MD5 = "MD5";

    public static String encrypt(String baseString){
        BigInteger bigInteger = null;
        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] baseData = baseString.getBytes();
            md.update(baseData);
            bigInteger = new BigInteger(md.digest());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }
}
