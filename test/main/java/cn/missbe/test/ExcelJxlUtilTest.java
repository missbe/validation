package cn.missbe.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cn.missbe.util.ExcelJxlUtil;
import cn.missbe.util.PropertiesUtil;

public class ExcelJxlUtilTest {
	@Ignore
	public void validateReadExcelPhone(){
		String filename=PropertiesUtil.getValue("name");
		String message=ExcelJxlUtil.readExcelPhone(filename,"15892238161");
		assertNotSame("",message);
	}
	@Ignore
	public void validateWriteKeyWord(){
		String filename=PropertiesUtil.getValue("name");
		boolean flag=ExcelJxlUtil.WriteKeyWord(filename, 0, 0, "missbe");
		assertEquals(true, flag);
	}
	
	@Ignore
	public void validateReadExcelId(){
		String filename=PropertiesUtil.getValue("name");
		String message=ExcelJxlUtil.readExcelID(filename,"14101010208");
		assertNotSame("",message);
	}
	
	@Ignore
	public void validateReadExcelList(){
		String filename=PropertiesUtil.getValue("name");
		List<String> message=ExcelJxlUtil.readExcelKeyWord(filename,"1");
		if(null!=message){
			for (String string : message) {
				System.out.println(string);
			}
		}
		assertNotNull(message);
	}
}
