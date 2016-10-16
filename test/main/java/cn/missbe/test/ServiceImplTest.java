package cn.missbe.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cn.missbe.service.ExcelServiceI;
import cn.missbe.service.impl.ExcelServiceImpl;
import cn.missbe.util.ConstanUtil;

public class ServiceImplTest {
	@Ignore
	   public void getUserListTest(){
		   ExcelServiceI serviceI=new ExcelServiceImpl();
		   List<String[]> list=serviceI.getUserList(ConstanUtil.KEYWORDRZO);
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
		   ExcelServiceI serviceI=new ExcelServiceImpl();
		   String[] phone=serviceI.getUser("15892238161", ConstanUtil.VALIDATEPHONE);
	       System.out.println("\n获得Excel表格Phone:");
	       for (String s : phone) {
	           System.out.print(s + " ");
	       }           
	      
	       String[] id=serviceI.getUser("14101010208", ConstanUtil.VALIDATEID);
	       System.out.println("\n获得Excel表格ID:");
	       for (String s : id) {
	           System.out.print(s + " ");
	       }  
	   }
}
