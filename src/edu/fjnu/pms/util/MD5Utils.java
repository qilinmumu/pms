/**
 * 
 */
package edu.fjnu.pms.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author lzx
 */
public class MD5Utils {
	
	/**
	 * 获得MD5加密后的字符串
	 * @param str	要加密的字符串
	 * @return	加密后的字符串
	 * @author lzx
	 */
	public String getMD5(String str){
		//得到MessageDigest对象
		MessageDigest md5 = getMessageDigest();
		
		byte[] byteArray = null;
		byte[] md5Bytes = null;
		try {
			//把要加密的字符串转换成编码为UTF-8的字节数组
			byteArray = str.getBytes("UTF-8");
			//对字节数组进行MD5加密
			md5Bytes = md5.digest(byteArray);
		} 
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//把加密后的字节数组转换成字符串,并变成大写返回
		return this.toUpperCase(this.byteToString(md5Bytes));
	}
	
	/**
	 * 得到MessageDigest对象
	 * @return 返回MessageDigest对象
	 * @author lzx
	 */
	private MessageDigest getMessageDigest(){
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} 
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	
	/**
	 * 将字符串转换成大写
	 * @param str	要转换的字符串
	 * @return	转换成大写后的字符串
	 * @author lzx
	 */
	private String toUpperCase(String str){
		return str.toUpperCase();
	}
	
	/**
	 * 将byte转换成16进制字符
	 * @param md5Bytes	要转换的字节数组
	 * @return 返回16进制字符串
	 * @author lzx
	 */
	private String byteToString(byte[] md5Bytes){
		StringBuffer hexValue = new StringBuffer();
		for(int i = 0; i < md5Bytes.length; i++){
			//取32位整数的后8为
			int val = ((int)md5Bytes[i]) & 0XFF;
			if (val < 16) {
				//如果小于16，需要补0 
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
}
