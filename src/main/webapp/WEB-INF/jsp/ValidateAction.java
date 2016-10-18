package cn.missbe.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.missbe.service.ExcelServiceI;
import cn.missbe.service.impl.ExcelServiceImpl;
import cn.missbe.util.ConstanUtil;

public class ValidateAction extends ActionSupport {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	private String switchParam;
	private String inputParam;
	
	/**
	 * 签到验证返回详细信息Action
	 */
	@Override
 	public  String execute(){
		ExcelServiceI serviceI=new ExcelServiceImpl();
//		switchParam="phone";
//		inputParam="123456";
		String[] contents=null;
		String[] title=serviceI.getExcelTitle();///获取Excel的标题
		if(null == switchParam || null == inputParam){
		    ServletActionContext.getRequest().setAttribute("message","----请正确输入相关信息---");
			return "tooltip";
		}
		if(switchParam.trim().equals("phone")){
			contents=serviceI.getUser(inputParam, ConstanUtil.VALIDATEPHONE);
		}else if(switchParam.trim().equals("id")){
			contents=serviceI.getUser(inputParam, ConstanUtil.VALIDATEID);
		}
		if(null != contents){		
			for(int i=0;i<contents.length;i++){
				contents[i] = title[i]+","+ contents[i];
				System.out.println(contents[i]+" -- ");
			}
		    contents[contents.length-1]="是否签到,已签到"; 
//		    ServletActionContext.getRequest().setAttribute("title",title);
			ServletActionContext.getRequest().setAttribute("list", contents);
			return SUCCESS;
		}else{
			ServletActionContext.getRequest().setAttribute("message","-信息未找到-核验输入是否正确或者验证方式是否正确-");
			return "tooltip";//提示用户信息错误，重新输入
		}		
//		System.out.println(switchParam+":"+inputParam);

	}
	
	
 	public String getSwitchParam() {
		return switchParam;
	}
	public void setSwitchParam(String switchParam) {
		this.switchParam = switchParam;
	}
	public String getInputParam() {
		return inputParam;
	}
	public void setInputParam(String inputParam) {
		this.inputParam = inputParam;
	}

}
