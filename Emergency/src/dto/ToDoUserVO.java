package dto;

import java.util.Date;

import dao.ToDoUserDAO;

public class ToDoUserVO {
	private String user_id;
	private String user_pwd;
	private String user_nick;
	private Date user_join_date;
	private int admin_code;
	private int access_code;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	
	
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	
	
	public Date getUser_join_date() {
		return user_join_date;
	}
	public void setUser_join_date(Date user_join_date) {
		this.user_join_date = user_join_date;
	}
	
	
	public int getAdmin_code() {
		return admin_code;
	}
	public void setAdmin_code(int admin_code) {
		this.admin_code = admin_code;
	}
	
	
	public int getAccess_code() {
		return access_code;
	}
	public void setAccess_code(int access_code) {
		this.access_code = access_code;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ToDoUserVO [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_nick=" + user_nick
				+ ", user_join_date=" + user_join_date + ", admin_code=" + admin_code + ", access_code=" + access_code
				+ "]";
	}

	
	
	
	
}
