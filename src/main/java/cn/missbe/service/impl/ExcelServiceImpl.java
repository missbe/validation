package cn.missbe.service.impl;

import java.util.List;

import cn.missbe.dao.ExcelDao;
import cn.missbe.dao.impl.ExcelPoiImpl;
import cn.missbe.service.ExcelServiceI;

public class ExcelServiceImpl implements ExcelServiceI {
    private ExcelDao dao;
    public ExcelServiceImpl(){    	
    	dao=new ExcelPoiImpl();
    }
	@Override
	public List<String[]> getUserList(int keyword) {		
		return dao.getUserList(keyword);
	}

	@Override
	public String[] getUser(String param, int flag) {		
		return dao.getUser(param, flag);
	}
	@Override
	public String[] getExcelTitle() {
		// TODO Auto-generated method stub
		return dao.getExcelTitle();
	}

}
