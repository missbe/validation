package cn.missbe.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.missbe.service.ExcelServiceI;
import cn.missbe.service.impl.ExcelServiceImpl;
import cn.missbe.util.ConstanUtil;

public class ManagerAction {
	private String validate;
	/**
	 * 返回签到者列表前端控制必须要有登录权限
	 * @return
	 */
	public String listValidatedIn(){
		Object session=ServletActionContext.getRequest().getSession().getAttribute("admin");
		if(null == session){
			ServletActionContext.getRequest().setAttribute("message", "----你没有查看信息的权限---");
			return "tooltip";
		}			
		
		ExcelServiceI serviceI=new ExcelServiceImpl();
		List<String[]> validatedList=null;
		
		if("in".equals(validate)){
			//获取签到用户列表 
			validatedList=serviceI.getUserList(ConstanUtil.KEYWORDONE);
		}else if("out".equals(validate)){
			validatedList=serviceI.getUserList(ConstanUtil.KEYWORDRZO);
		}
		
		if(null != validatedList){
			System.out.println("----用户列表---- ");
			for (String[] strings : validatedList) {
//				for (String string : strings) {
//					System.out.println(string+" -- ");
//				}
		       strings[strings.length-1]=validate.equals("in") ?"已签到":"未签到";
			}
			
			ServletActionContext.getRequest().setAttribute("message","序号");///表头
			ServletActionContext.getRequest().setAttribute("list",validatedList);
			ServletActionContext.getRequest().setAttribute("title", serviceI.getExcelTitle());///表头;
			
		}else{
			System.out.println("--无签到用户列表--");
			ServletActionContext.getRequest().setAttribute("message","----无签到用户列表---");///表头
//			return "tooltip";
		}	
		return "success";
	}
	public String execute(){
		return "success";
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
}
