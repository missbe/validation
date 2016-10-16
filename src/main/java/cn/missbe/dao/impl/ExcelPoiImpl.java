package cn.missbe.dao.impl;

import java.util.List;

import cn.missbe.dao.ExcelDao;
import cn.missbe.util.ConstanUtil;
import cn.missbe.util.ExcelPoiUtil;

public class ExcelPoiImpl implements ExcelDao {
    private ExcelPoiUtil util;
	public ExcelPoiImpl() {
		
		System.out.println("ExcelPoiImpl初始化完成");
		
		util=new ExcelPoiUtil();
	}
	@Override
	public List<String[]> getUserList(int keyword) {
//		System.out.println("ExcelPoiImpl-getUserList被调用");
		List<String[]> list=util.readExcelKeyWord(keyword);
		return list;
	}

	

	@Override
	public String[] getUser(String param, int flag) {
		String[] content=null;
		switch(flag){
		case ConstanUtil.VALIDATEPHONE:
			content=util.readExcelPhone(param);
			break;
		case ConstanUtil.VALIDATEID:
			content=util.readExcelID(param);
			break;
			default:
				break;
		}
		return content;
	}
	@Override
	public String[] getExcelTitle() {
		
		return util.readExcelTitle();
	}

}
