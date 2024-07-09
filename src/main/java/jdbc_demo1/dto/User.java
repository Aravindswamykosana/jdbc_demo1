package jdbc_demo1.dto;

public class User {
	private int id;
	private String name;
	private long phone;
	private String email;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "\nUser [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", pwd=" + pwd + "]";
	}
	public User(int id, String name, long phone, String email, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.pwd = pwd;
	}
	public User() {
		super();
	}
	public User(String name1, String pwd1, long ph1, String email1) {
		this.name = name1;
		this.pwd = pwd1;
		this.phone = ph1;
		this.email = email1;
	}
}
