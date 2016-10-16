package cn.missbe.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static String proFileName = "file.properties";// 正确的
	private static Properties pro;

	static {
		try {
			System.out.println("静态初始化PropertiesUtil");
			pro = new Properties();
			InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(proFileName);
			pro.load(in);
			in.close();
		} catch (IOException e) {			
			e.printStackTrace();
			System.out.println("属性文件读取错误");
		}
	}

	public static String getValue(String key) {
//		System.out.println("\n调用getValue\n");
		String value = pro.getProperty(key);
		return value;
	}
}
