package cn.missbe.action;

import java.util.List;

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
	@Override
	public  String execute(){
		ExcelServiceI serviceI=new ExcelServiceImpl();
//		switchParam="phone";
//		inputParam="123456";
		String[] contents=null;
		String[] title=serviceI.getExcelTitle();///获取Excel的表头
		if(switchParam.trim().equals("phone")){
			contents=serviceI.getUser(inputParam, ConstanUtil.VALIDATEPHONE);
		}else if(switchParam.trim().equals("id")){
			contents=serviceI.getUser(inputParam, ConstanUtil.VALIDATEID);
		}
		if(null != contents){		
			for(int i=0;i<contents.length;i++){
				contents[i] = title[i]+"---" + contents[i];
				System.out.println(contents[i]+" -- ");
			}
			
			ServletActionContext.getRequest().setAttribute("list", contents);
			return SUCCESS;
		}		
		return "message";
//		System.out.println(switchParam+":"+inputParam);

	}
	
	public String list(){
		ExcelServiceI serviceI=new ExcelServiceImpl();
		List<String[]> validatedIn=serviceI.getUserList(ConstanUtil.KEYWORDONE);
		if(null != validatedIn){
			System.out.println("签到用户列表： ");
			for (String[] strings : validatedIn) {
				for (String string : strings) {
					System.out.println(string+" -- ");
				}
			}
		}else{
			System.out.println("未获取的签到用户列表 ");
		}
		List<String[]> validatedOut=serviceI.getUserList(ConstanUtil.KEYWORDRZO);
		if(null != validatedOut){
			System.out.println("未签到用户列表 ：");
			for (String[] strings : validatedOut) {
				for (String string : strings) {
					System.out.println(string+" ** ");
				}
			}
		}else{
			System.out.println("未获取到未签到用户");
		}
		return SUCCESS;
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
