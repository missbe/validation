package cn.missbe.test;

import java.util.List;

import org.junit.Ignore;
import cn.missbe.dao.ExcelDao;
import cn.missbe.dao.impl.ExcelPoiImpl;
import cn.missbe.util.ConstanUtil;

public class ExcelPoiImplTest {
   @Ignore
   public void getUserListTest(){
	   ExcelDao dao=new ExcelPoiImpl();
	   List<String[]> list=dao.getUserList(ConstanUtil.KEYWORDRZO);
       System.out.println("\n获得Excel表格keyword:");
       if(null!=list){
    	   for(int i=0;i<list.size();i++){
    	       	for (String s : list.get(i)) {
    	               System.out.print(s + " --");
    	           }  
    	       	System.out.println();
    	       }
       }
   }
   @Ignore
   public void getUser(){
	   ExcelDao dao=new ExcelPoiImpl();	   
       
       String[] phone = dao.getUser("15892238161", ConstanUtil.VALIDATEPHONE);
       System.out.println("\n获得Excel表格Phone:");
       for (String s : phone) {
           System.out.print(s + " ");
       }           
      
       String[] id = dao.getUser("14101010208", ConstanUtil.VALIDATEID);
       System.out.println("\n获得Excel表格id:");
       for (String s : id) {
           System.out.print(s + " ");
       }   
   }
}
