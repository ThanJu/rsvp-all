package com.highteam.router.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


/**
 * @author mwd
 * 2016-4-18
 * 工具类
 */

public class Utils {
	
	 /**
	  * 加密
	  * @param inStr
	  * @return
	  */
    public static String encryption(String inStr){ 
    	if(StringUtils.isBlank(inStr)){
    		return null;
    	}
    	return	DigestUtils.md5Hex(inStr);
    }  
    /**
	  * 创建指定数量的随机字符串 
	  * @param numberFlag 是否是数字 
	  * @param length 
	  * @return 
	  */
    public static String createRandom(boolean numberFlag, int length){  
	  String retStr = "";  
	  String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";  
	  int len = strTable.length();  
	  boolean bDone = true;  
	  do {  
		  retStr = "";  
		  int count = 0;  
		  for (int i = 0; i < length; i++) {  
			  double dblR = Math.random() * len;  
			  int intR = (int) Math.floor(dblR);  
			  char c = strTable.charAt(intR);  
			  if (('0' <= c) && (c <= '9')) {  
				  count++;  
			  }  
			  retStr += strTable.charAt(intR);  
		  }  
		  if (count >= 2) {  
			  bDone = false;  
		  }  
	  } while (bDone);  
	  return retStr;  
	 } 
    
    //获取IP地址
    public static String getRemoteIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
    public static String getIpAddr(HttpServletRequest request) {
		
		StringBuilder resultIp=new StringBuilder();
		
        String xRealIp = request.getHeader("X-Real-IP");
        String xForwardIp = request.getHeader("X-Forwarded-For");
        String remoteIp = request.getRemoteAddr();
        
        if (!StringUtils.isBlank(xRealIp) && !"unknown".equalsIgnoreCase(xRealIp)) {
        	resultIp.append("X-Real-IP:"+xRealIp);
        }
        if (!StringUtils.isBlank(xForwardIp) && !"unknown".equalsIgnoreCase(xForwardIp)) {
        // 多次反向代理后会有多个IP值，第一个为真实IP。
        int index = xForwardIp.indexOf(',');
        if (index != -1) {
           resultIp.append(";X-Forwarded-For:"+xForwardIp.substring(0, index)+",ipList:"+xForwardIp);
          } else {
           resultIp.append(";X-Forwarded-For"+xForwardIp);
          }
        }
        resultIp.append(";remoteAddr:"+remoteIp);
        
        return resultIp.toString();
    }
    public static String getSpecialCharactersString(String str){
		String newStr=str;
		if(!StringUtils.isBlank(newStr)){
			newStr=newStr.replaceAll("%", "%25");
			newStr=newStr.replaceAll("#", "%23");
			newStr=newStr.replaceAll("&", "%26");
			newStr=newStr.replaceAll("\\+", "%2B");
			newStr=newStr.replaceAll("\\\\", "%2F");
			newStr=newStr.replaceAll("=", "%3D");
			newStr=newStr.replaceAll("\\?", "%3F");
			newStr=newStr.replaceAll(" ", "%20");
			newStr=newStr.replaceAll("@", "%40");
			
			
		}
		return newStr;
	}
    
    public static String getbackSpecialString(String str){
    	String newStr=str;
		if(!StringUtils.isBlank(newStr)){
			newStr=newStr.replaceAll("%25", "%");
			newStr=newStr.replaceAll("%23", "#");
			newStr=newStr.replaceAll("%26", "&");
			newStr=newStr.replaceAll("%2B", "+");
			newStr=newStr.replaceAll("%2F", "\\");
			newStr=newStr.replaceAll("%3D", "=");
			newStr=newStr.replaceAll("%3F", "?");
			newStr=newStr.replaceAll("%20", " ");
			newStr=newStr.replaceAll("%40", "@");
			
		}
		return newStr;
    }
    
    
    public static String getSpecialCharactersSQLString(String str){
		String newStr=str;
		if(!StringUtils.isBlank(newStr)){
			newStr=newStr.replace("\\", "\\\\");
			newStr=newStr.replace("'", "\'");
			newStr=newStr.replace("\"", "\\\"");
		}
		return newStr;
	}
    public static String listToString(List<?> list, char separator) {
		return StringUtils.join(list.toArray(),separator);
	}

	private static Color getRandColor(int fc, int bc)
	{
		Random random = new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		return new Color(r,g,b);
	}

	public static void createVCodeImage(HttpServletResponse response,String sRand) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		int width = 120, height = 38;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		String[] fontTypes = {"\u5b8b\u4f53", "\u65b0\u5b8b\u4f53",
				"\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66"};
		int fontTypesLength = fontTypes.length;
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		char[] rand = sRand.toCharArray();
		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(20 + random.nextInt(100), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.setFont(new Font(fontTypes[random.nextInt(fontTypesLength)], Font.BOLD, 28 + random.nextInt(6)));
			g.drawString(rand[i] + "", 25 * i + 12, 25);
		}
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	public static String replaceContentParam(String content,Map<String,String> params){
		Set<Map.Entry<String,String>> set = params.entrySet();
		for (Map.Entry<String,String> entry : set){
			String placeholder = "${"+entry.getKey()+"}";
			content = content.replace(placeholder,entry.getValue());
		}
		return content;
	}
}
