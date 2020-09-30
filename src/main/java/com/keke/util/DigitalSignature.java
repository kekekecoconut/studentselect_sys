package com.keke.util;

import org.apache.commons.codec.binary.Hex;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class DigitalSignature {

    /**
     * 执行签名
     * @param wk
     * @param rsaPrivateKey
     * @return
     * @throws Exception
     */
    public static byte[] signature(byte[] wk, byte[] rsaPrivateKey) throws Exception {
      //  PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getBytes());
       // PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initSign(privateKey);
        signature.update(wk);
        byte[] result = signature.sign();
        System.out.println("jdk dsa sign : " + Hex.encodeHexString(result));
        return result;
    }


    /**
     * 验证签名
     * @param ds
     * @param rsaPublicKey
     * @param src
     * @return
     * @throws Exception
     */
    public static boolean verifySignature(byte[] ds, RSAPublicKey rsaPublicKey, String src) throws Exception{
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
        boolean bool = signature.verify(ds);
        System.out.println("jdk dsa verify : " + bool);
        return bool;
    }


}
