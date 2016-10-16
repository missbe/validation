package cn.missbe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ExcelJxlUtil {
	/**
	 * 根据手机号码进行验证
	 * @param filename 读取的xls文件名字
	 * @param phone  关键的手机号码 
	 * @return 返回用户信息，失败返回空串
	 */
	public static String readExcelPhone(String filename, String phone) {
		Workbook rwb=getWorkBook(filename);
		if(null==rwb){
			return "工作集读取错误";
		}
		// 3、获得工作簿的个数,对应于一个excel中的工作表个数
		rwb.getNumberOfSheets();

		Sheet oFirstSheet = rwb.getSheet(0);// 使用索引形式获取第一个工作表，也可以使用rwb.getSheet(sheetName);其中sheetName表示的是工作表的名称
		System.out.println("工作表名称：" + oFirstSheet.getName());
		
		int rows = oFirstSheet.getRows();// 获取工作表中的总行数
		int columns = oFirstSheet.getColumns();// 获取工作表中的总列数
		StringBuilder message=new StringBuilder("用户信息如下:\n");///进行数据连接
		for (int i = 1; i < rows; i++) {
			Cell oCell = oFirstSheet.getCell(0, i);//获取Excel表的每一行的第一列-phone
			if(oCell.getContents().equals(phone)){
				for (int j = 0; j < columns-1; j++) {		
					// 需要注意的是这里的getCell方法的参数，第一个是指定第几列，第二个参数才是指定第几行
					oCell = oFirstSheet.getCell(j, i);/// 获取用户的所有数据					
                    if(columns-2 == j){
                    	message.append(oFirstSheet.getCell(j, 0).getContents() + ":" ///为每列加上头
            					+ oCell.getContents() );
                    }else{
                    	message.append(oFirstSheet.getCell(j, 0).getContents() + ":" ///为每列加上头
            					+ oCell.getContents() + ",");	
                   }									
						
			  }//end for
//				message.substring(0, message.length()-2);/// 去掉最后一个','字符
				System.out.print(message);	
				return message.toString();
			}
			
		}//end for
		return "";
	}
	/**
	 * 根据学号码进行验证
	 * @param filename 读取的xls文件名字
	 * @param phone  关键的学号字段
	 * @return 返回用户信息，失败返回空串
	 */
	public static String readExcelID(String filename, String id) {
		Workbook rwb=getWorkBook(filename);
		if(null==rwb){
			return "工作集读取错误";
		}
		// 3、获得工作簿的个数,对应于一个excel中的工作表个数
		rwb.getNumberOfSheets();

		Sheet oFirstSheet = rwb.getSheet(0);// 使用索引形式获取第一个工作表，也可以使用rwb.getSheet(sheetName);其中sheetName表示的是工作表的名称
		System.out.println("工作表名称：" + oFirstSheet.getName());
		
		int rows = oFirstSheet.getRows();// 获取工作表中的总行数
		int columns = oFirstSheet.getColumns();// 获取工作表中的总列数
		StringBuilder message=new StringBuilder("用户信息如下:\n");///进行数据连接
		for (int i = 1; i < rows; i++) {
			Cell oCell = oFirstSheet.getCell(1, i);//获取Excel表的每一行的第二列-id
			if(oCell.getContents().equals(id)){///对用户手机号码进行遍历查询
				for (int j = 0; j < columns-1; j++) {		
					// 需要注意的是这里的getCell方法的参数，第一个是指定第几列，第二个参数才是指定第几行
					oCell = oFirstSheet.getCell(j, i);/// 获取用户的所有数据
									
					if(columns-2 == j){
						message.append(oFirstSheet.getCell(j, 0).getContents() + ":" ///为每列加上头
								+ oCell.getContents() );	
                    }else{
                    	message.append(oFirstSheet.getCell(j, 0).getContents() + ":" ///为每列加上头
            					+ oCell.getContents() + ",");	
                   }		
			  }//end for
//				message.substring(0, message.length()-2);/// 去掉最后一个','字符
				System.out.print(message);	
				return message.toString();
			}
			
		}//end for
		return "";
	}
	/**
	 * 对指定工作集的指定单元格写入关键字段
	 * @param filename 工作集名称
	 * @param keyword 写入的关键字段	
	 * @param row 指定单元格的行标
	 * @param column 指定单元格的列标
	 */
	public static boolean WriteKeyWord(String filename,int row,int column,String keyword){	

		String url = PropertiesUtil.class.getClassLoader().getResource(filename).getFile();
		System.out.println("WriteKeyWord:进行关键字写入"+url);
//		 Workbook rwb = Workbook.getWorkbook(new File(url));   
		//打开一个文件的副本，并且指定数据写回到原文件        
		 Workbook rwb=null;
		 WritableWorkbook wwb=null;
		 WritableSheet ws=null;		 
		 try   
	       {   
			    ///打开原始文档
                rwb = Workbook.getWorkbook(new File(url));                  
	           //打开一个文件的副本，并且指定数据写回到原文件        
                wwb = Workbook.createWorkbook(new File("back.xls"),rwb);//copy   
	            ws= wwb.getSheet(0);   
	            WritableCell wc = ws.getWritableCell(column,row);   
	           
	           //判断单元格的类型,做出相应的转换   
	           if(null != wc)   
	           {   
	               Label label = (Label)wc;   
	               label.setString(keyword);   
	           }   
	           System.out.println("Contents:"+ws.getWritableCell(column,row).getContents());
	           if(null!=wwb){
    			   wwb.write();
    			   wwb.write();
    		   }		           
	       }catch (IOException e) {
				e.printStackTrace();
				System.out.println("WriteKeyWord：数据IO异常");
				return false;
//			} catch (RowsExceededException e) {
//				e.printStackTrace();
//				System.out.println("WriteKeyWord：数据RowsExceededException异常");
//				return false;
//			} catch (WriteException e) {
//				e.printStackTrace();
//				System.out.println("WriteKeyWord：数据WriteException异常");
//				return false;
			} catch (BiffException e) {
				e.printStackTrace();
				System.out.println("WriteKeyWord：数据BiffException异常");
				return false;
			}catch(Exception e)   
	        {   
	           e.printStackTrace(); 
	           System.out.println("WriteKeyWord：Exception异常");
			   return false;
	        } finally {
	        	
	        	   try {	        		   
	        		   if(null!=wwb){
	        			   wwb.close();   
	        		   }
	        		   if(null!=rwb){	        			   
	        			   rwb.close();  
	        		   }	        		  
			           
				} catch (IOException e) {					
					e.printStackTrace();
					System.out.println("WriteKeyWord：IOException关闭异常");
					return false;
				}   catch (WriteException e) {
					e.printStackTrace();
					System.out.println("WriteKeyWord：WriteException关闭异常");
					return false;
				}
		            
			}  
		
		
		return true;
	}
	/**
	 * 根据文件名称建立工作集
	 * @param filename 指定文件名称
	 * @return 成功返回一个工作集，否则返回null
	 */
	private static Workbook getWorkBook(String filename){
		// 1、构造excel文件输入流对象		
				String url=PropertiesUtil.class.getClassLoader().getResource(filename).getFile();
				
				System.out.println("URL:"+url);
				InputStream is =null;
				try {
					is = new FileInputStream(url);
				} catch (FileNotFoundException e1) {			
					e1.printStackTrace();
					System.out.println("文件读取过程中产生错误");
				}
				if(is==null){
					System.out.println("文件读取流为NULL,不能进行读取文件操作");
					return null;
				}
				// 2、声明工作簿对象
				Workbook rwb=null;
				try {
					rwb = Workbook.getWorkbook(is);
				} catch (BiffException e) {			
					e.printStackTrace();
					System.out.println("工作集读取产生BiffException错误");
				} catch (IOException e) {			
					e.printStackTrace();
					System.out.println("工作集IO产生错误");
				}
				return rwb;
	}
	/**
	 * 获取关键字段的用户列表
	 * @param filename 指定文件名称
	 * @param KeyWord 用户指定关键字
	 * @return 成功返回用户列表，失败返回null
	 */
	public static List<String> readExcelKeyWord(String filename, String KeyWord) {
		Workbook rwb=getWorkBook(filename);
		if(null==rwb){
			System.out.println("获取工作集失败+readExcelKeyWord");
			return null;
		}
		// 3、获得工作簿的个数,对应于一个excel中的工作表个数
		rwb.getNumberOfSheets();

		Sheet oFirstSheet = rwb.getSheet(0);// 使用索引形式获取第一个工作表，也可以使用rwb.getSheet(sheetName);其中sheetName表示的是工作表的名称
		System.out.println("工作表名称：" + oFirstSheet.getName());
		
		int rows = oFirstSheet.getRows();// 获取工作表中的总行数
		int columns = oFirstSheet.getColumns();// 获取工作表中的总列数
		StringBuilder message=new StringBuilder();///进行数据连接
		List<String> messageList=new ArrayList<String>();///初始化一个列表 
		
		for (int i = 1; i < rows; i++) {///过滤第一行
			Cell oCell = oFirstSheet.getCell(columns-1, i);//获取Excel表的最后一列
			if(oCell.getContents().equals(KeyWord)){///对指定关键字段进行过滤
				for (int j = 0; j < columns; j++) {		
					// 需要注意的是这里的getCell方法的参数，第一个是指定第几列，第二个参数才是指定第几行
					oCell = oFirstSheet.getCell(j, i);/// 获取用户的所有数据
					
					if(columns-1 == j){
						message.append(oFirstSheet.getCell(j, 0).getContents() + ":" ///为每列加上头
								+ oCell.getContents() );	
                    }else{
                    	message.append(oFirstSheet.getCell(j, 0).getContents() + ":" ///为每列加上头
            					+ oCell.getContents() + ",");		
                   }		
						
			  }//end for

				System.out.println("TEST:readExcelKeyWord:"+message);	
				messageList.add(message.toString());///将这个用户添加进行列表 
				message=new StringBuilder();///重新初始化一个字符连接串
			}			
		}//end for
		return messageList.size()>0 ? messageList : null;
	}
}
