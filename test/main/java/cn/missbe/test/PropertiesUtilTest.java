package cn.missbe.test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import cn.missbe.util.PropertiesUtil;

public class PropertiesUtilTest {

	@Ignore
	public void validateGetPropertiesValue(){
		String value=PropertiesUtil.getValue("name");
		System.out.println("name:"+value);
		assertEquals("data.xlsx", value);
	}
}
