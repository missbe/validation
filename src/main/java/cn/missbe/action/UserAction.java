package cn.missbe.action;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	//用户
	private String username;
	private String userpass;
	
	@Override
	public String execute(){
		System.out.println("TEST:"+username);
		if(null == username || null == userpass){
			return "input";
		}
		if(username.equals("admin") && userpass.equals("admin")){
		
			ServletActionContext.getRequest().setAttribute("message", "测试成功完成！");

			return SUCCESS;
		}else{
			System.out.println("未查询到该用户");
			ServletActionContext.getRequest().setAttribute("message","用户名或者密码不正确^_^");
			return INPUT;
		}	  
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
