package dto;

public class ToDoCategoryVO {
	private int category_code;
	private String category_name;
	
	
	
	public int getCategory_code() {
		return category_code;
	}
	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
	
	@Override
	public String toString() {
		return "ToDoCategoryVO [category_code=" + category_code + ", category_name=" + category_name + "]";
	}
	
	
	
	
	
}
