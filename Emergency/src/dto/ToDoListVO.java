package dto;

import java.util.Date;

public class ToDoListVO {
	private String todo_num;
	private String todo_title;
	private String todo_content;
	private int todo_done;
	private Date todo_date;
	private Date todo_period;
	private int todo_delete;
	private int todo_category;
	
	
	
	public String getTodo_num() {
		return todo_num;
	}
	public void setTodo_num(String todo_num) {
		this.todo_num = todo_num;
	}
	
	public String getTodo_title() {
		return todo_title;
	}
	public void setTodo_title(String todo_title) {
		this.todo_title = todo_title;
	}
	
	public String getTodo_content() {
		return todo_content;
	}
	public void setTodo_content(String todo_content) {
		this.todo_content = todo_content;
	}
	
	public int getTodo_done() {
		return todo_done;
	}
	public void setTodo_done(int todo_done) {
		this.todo_done = todo_done;
	}
	
	public Date getTodo_date() {
		return todo_date;
	}
	public void setTodo_date(Date todo_date) {
		this.todo_date = todo_date;
	}
	
	public Date getTodo_period() {
		return todo_period;
	}
	public void setTodo_period(Date todo_period) {
		this.todo_period = todo_period;
	}
	
	public int getTodo_delete() {
		return todo_delete;
	}
	public void setTodo_delete(int todo_delete) {
		this.todo_delete = todo_delete;
	}
	
	public int getTodo_category() {
		return todo_category;
	}
	public void setTodo_category(int todo_category) {
		this.todo_category = todo_category;
	}
	
	
	
	@Override
	public String toString() {
		return "ToDoListVO [todo_num=" + todo_num + ", todo_title=" + todo_title + ", todo_content=" + todo_content
				+ ", todo_done=" + todo_done + ", todo_date=" + todo_date + ", todo_period=" + todo_period
				+ ", todo_delete=" + todo_delete + ", todo_category=" + todo_category + "]";
	}
	
	
	

}
