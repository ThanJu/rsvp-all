package com.highteam.router.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class AESUtil {
	
	private static final String charset = "utf-8";

	private static final String secret = "AES";

	private static final int keysize = 128;

	private static final byte[] toByte(String source) throws UnsupportedEncodingException {
		return source.getBytes(charset);
	}
	private static final String base64Encode(byte[] b) throws UnsupportedEncodingException {
		return Base64.encodeBase64URLSafeString(b);
	}

	private static final byte[] base64Decode(String source) throws IOException {
		return Base64.decodeBase64(source);
	}

	private static final KeyGenerator getKeyGenerator(String sign) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		KeyGenerator generator = KeyGenerator.getInstance(secret);
		generator.init(keysize, new SecureRandom(toByte(sign)));
		return generator;
	}

	private static final SecretKeySpec getSecretKeySpec(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		KeyGenerator kgen = getKeyGenerator(key);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		return new SecretKeySpec(enCodeFormat, secret);
	}

	private static final Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
		return Cipher.getInstance(secret);
	}

	public static final String encrypt(String content, String key) {
		try {
			SecretKeySpec secretKeySpec = getSecretKeySpec(key);
			Cipher cipher = getCipher();
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] b = cipher.doFinal(content.getBytes(charset));
			return base64Encode(b);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static final String detrypt(String content, String key) {
		try {
			SecretKeySpec secretKeySpec = getSecretKeySpec(key);
			Cipher cipher = getCipher();
			byte b[] = base64Decode(content);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] de = cipher.doFinal(b);
			return new String(de);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
