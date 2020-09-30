package com.keke.util;

import com.keke.util.des.DESProvider;
import com.keke.util.rsa.RSAProvider;

import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		//对称密钥：A/SymmetricKey
		String symmetricKey = DESProvider.generateKey();
		System.out.println("symmetricKey="+symmetricKey);
		StreamUtil.printToFile("A/SymmetricKey", symmetricKey);

		//公钥：A/BPublicKey
		Map<String, Object> keyPair = RSAProvider.generateKeyPair();//生成密钥对
		String pubkey = RSAProvider.getPublicKeyBytes(keyPair);
		System.out.println("A/BPublicKey="+pubkey);
		StreamUtil.printToFile("A/BPublicKey", pubkey);

		//私钥：B/BPrivateKey
		String prikey = RSAProvider.getPrivateKeyBytes(keyPair);
		System.out.println("B/BPrivateKey="+ prikey);
		StreamUtil.printToFile("B/BPrivateKey", prikey);

		//用公钥A/BPublicKey对对称密钥加密A/SymmetricKey：SecretKey
		String secretKey = StreamUtil.readFromFile("A/SymmetricKey");
		byte[] ctext = RSAProvider.encryptPublicKey(secretKey,pubkey);
		String text = StreamUtil.byteToBase64(ctext);
		System.out.println("SecretKey="+text);
		StreamUtil.printToFile("SecretKey", text);

		//用私钥B/BPrivateKey对SecretKey解密：B/SymmetricKey
		String text2 = StreamUtil.readFromFile("SecretKey");
		byte[] ctext2 = StreamUtil.base64ToByte(text2);
		String ptext = RSAProvider.decryptPrivateKey(ctext2, prikey);

		//验证
		System.out.println("原文="+symmetricKey);
		System.out.println("解密="+ptext);

	}
}


