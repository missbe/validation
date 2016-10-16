package cn.missbe.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import cn.missbe.dao.impl.ExcelPoiImpl;

public class ExcelPoiUtil {
	private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    public ExcelPoiUtil(){
    	String filename = PropertiesUtil.getValue("name");
		String url = ExcelPoiImpl.class.getClassLoader().getResource(filename).getFile();
		// 对读取Excel表格标题测试
		InputStream is = null;
		try {
		     is = new FileInputStream(url);
			 fs = new POIFSFileSystem(is);
	         wb = new HSSFWorkbook(fs);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			System.out.println("文件未找到");
		}catch (IOException e) {
            e.printStackTrace();
            System.out.println("readExcelTitle-文件IO错误");           
        }
    	 System.out.println("ExcelPoiUtil初始化完成");
    }
    /**
     * 读取Excel表格表头的内容
     * @param InputStream
     * @return String 表头内容的数组
     */
    public  String[] readExcelTitle() {        
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("\nreadExcelTitle-colNum:" + colNum);
        
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell( i));
        }
        return title;
    }
    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式                    
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                   
//                    System.out.println("Cell:"+cellvalue);
                }
                break;
            }           
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    /**
     * 读取Excel数据内容
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
     */
    @SuppressWarnings("unused")
	private Map<Integer, String> readExcelContent(InputStream is) {
        Map<Integer, String> content = new HashMap<Integer, String>();
        String str = "";
        
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {       
            	if(colNum-1 == j){
            		str += getCellFormatValue(row.getCell(j)).trim() ;
            	}else{
            		str += getCellFormatValue(row.getCell(j)).trim() + ",";
            	}
                
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }
    
	/**
	 * 根据手机号码进行验证
	 * @param filename 读取的xls文件名字
	 * @param phone  关键的手机号码 
	 * @return 返回用户信息，失败返回null
	 */
	public  String[] readExcelPhone(String phone){
		String[] content = null;   
//		String[] title=readExcelTitle();
        
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        content=new String[colNum];///根据列的数目来建立字符串数组
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            ///查询指定手机号码的用户
            if(getCellFormatValue(row.getCell(1)).trim().equals(phone)){
            	int j = 0;
                while (j < colNum) {      
                	content[j]=getCellFormatValue(row.getCell(j)).trim();            	
                    j++;
                } //end while    
                String filename = PropertiesUtil.getValue("name");
                WriteKeyWord(filename, i, j-1, ConstanUtil.KEYWORDONE);//j-1回退到前一个
                return content;
            }                         
        }   
		return null;
	}
	/**
	 * 根据学号码进行验证
	 * @param filename 读取的xls文件名字
	 * @param phone  关键的学号字段
	 * @return 返回用户信息，失败返回null
	 */
	public  String[] readExcelID(String id) {
		String[] content = null;   
//		String[] title=readExcelTitle();
        
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        
        content=new String[colNum];///根据列的数目来建立字符串数组
        
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            ///查询指定学号ID号码的用户
            if(getCellFormatValue(row.getCell(0)).trim().equals(id)){
            	int j = 0;
                while (j < colNum) {      
                	content[j]=getCellFormatValue(row.getCell(j)).trim();            	
                    j++;
                } //end while 
                String filename = PropertiesUtil.getValue("name");
                WriteKeyWord(filename, i, j-1, ConstanUtil.KEYWORDONE);//j-1回退到前一个
                return content;
            }                         
        }   
        
		return null;
	}
	/**
	 * 获取关键字段的用户列表
	 * @param filename 指定文件名称
	 * @param KeyWord 用户指定关键字
	 * @return 成功返回用户列表，失败返回null
	 */
	public  List<String[]> readExcelKeyWord(int KeyWord){
      List<String[]> list = new ArrayList<String[]>();  
//      String[] title=readExcelTitle();
        
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();        
       
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            ///查询指定学号ID号码的用户
        
            int key=(int)row.getCell(colNum-1).getNumericCellValue();
             
            if(KeyWord == key){
            	int j = 0;
            	String[] content=new String[colNum];
                while (j < colNum) {      
                	content[j]= getCellFormatValue(row.getCell(j)).trim();            	
                    j++;                   
                } //end while 
                list.add(content);
            }                         
        }   
        return list.size()>0 ? list :null;
	}
    public  boolean WriteKeyWord(String filename,int rowIndex,int columnIndex,int keyword){
    	String fileLocation = ExcelJxlUtil.class.getClassLoader().getResource(filename).getFile();
    	System.out.println("URL:"+fileLocation);
//        int coloum = 1; // 比如你要获取第1列
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
            		fileLocation));
            HSSFSheet sheet = workbook.getSheet("Sheet1");
 
            HSSFRow row=sheet.getRow(rowIndex);
            //如果行不存在，返回假
            if (null == row) {
            	workbook.close();
            	System.out.println("获取不到指定的行");
            	return false;
            }            
			HSSFCell cell=row.getCell(columnIndex);
            ///如果单元格为空，返回假
            if(null==cell){
            	workbook.close();
            	System.out.println("获取不到指定列");
            	return false;
            }
            System.out.println(cell.getNumericCellValue());
            if(1==rowIndex){
            	int temp = (int) cell.getNumericCellValue();
                cell.setCellValue(temp+1); //设置数字加一
            }else{
            	cell.setCellValue(keyword);
            }
            
            
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(fileLocation);
                workbook.write(out);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("工作集写入时产生IOException");
                return false;
            } finally {
                try {
                	workbook.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("工作集关闭时产生IOException");
                    return false;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("工作集FileNotFoundException产生错误");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("工作集IOException产生错误");
            return false;
        }
        return true;
    }
}
