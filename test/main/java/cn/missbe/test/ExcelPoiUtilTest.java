package cn.missbe.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import cn.missbe.util.ConstanUtil;
import cn.missbe.util.ExcelPoiUtil;
import cn.missbe.util.PropertiesUtil;

public class ExcelPoiUtilTest {
	@Ignore
	public void validateWriteKeyWord() {
		String filename = PropertiesUtil.getValue("name");
		boolean flag = new ExcelPoiUtil().WriteKeyWord(filename, 2, 5, ConstanUtil.KEYWORDONE);
		assertEquals(true, flag);
	}

	@Ignore
	public void test(){

            ExcelPoiUtil excelReader = new ExcelPoiUtil();
//            String[] title = excelReader.readExcelTitle();
//            System.out.println("\n获得Excel表格的标题:");
//            for (String s : title) {
//                System.out.print(s + " ");
//            }
//            
            String[] phone = excelReader.readExcelPhone("15892238161");
            
            System.out.println("\n获得Excel表格Phone:");
           if(null!=phone){
        	   for (String s : phone) {
                   System.out.print(s + " ");
               }   
           }                   
           
//            String[] id = excelReader.readExcelID("14101010208");
//            System.out.println("\n获得Excel表格学号:");
//           
//            for (String s : id) {
//                System.out.print(s +" ");
//            }   
            
            List<String[]> list=excelReader.readExcelKeyWord(ConstanUtil.KEYWORDONE);
            System.out.println("\n获得Excel表格keyword:");
           
            for(int i=0;i<list.size();i++){
            	for (String s : list.get(i)) {
                    System.out.print(s +  " ");
                }  
            	System.out.println();
            }
	}
}
