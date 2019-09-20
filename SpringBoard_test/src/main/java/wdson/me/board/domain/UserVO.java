package wdson.me.board.domain;

public class UserVO {
	
	private int u_code;
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_email;
	private int u_grade;
	
	public UserVO() {
		super();
	}
	
	// 로그인 용
	public UserVO(String u_id, String u_pw) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
	}
	
	// 데이터 전체 사용 용 
	public UserVO(int u_code, String u_id, String u_pw, String u_name, String u_email, int u_grade) {
		super();
		this.u_code = u_code;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_grade = u_grade;
	}
	
	// 회원가입 용
	public UserVO(String u_id, String u_pw, String u_name, String u_email) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_email = u_email;
	}

	public int getU_code() {
		return u_code;
	}
	public void setU_code(int u_code) {
		this.u_code = u_code;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getU_grade() {
		return u_grade;
	}
	public void setU_grade(int u_grade) {
		this.u_grade = u_grade;
	}
	
}
