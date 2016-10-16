package cn.missbe.dao;

import java.util.List;

public interface ExcelDao {
	/**
	 * 获取指定关键字段的用户列表
	 * @param keyword 指定的关键字段
	 * @return 返回的用户列表 
	 */
   List<String[]> getUserList(int keyword);
   /**
	 * 获取用户信息
	 * @param id 用户唯一标识
	 * @param flag 1-表示用手机号码查找，0表示学号查找 
	 * @return  返回用户全部信息，否则返回null
	 */
   String[] getUser(String param ,int flag);
   
   /**
    * 获取Excel文件的头
    * @return
    */
   String[] getExcelTitle();
}
