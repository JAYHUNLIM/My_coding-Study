package oop0320;
//Test01_getset.java
public class MemberDTO {
	//멤버변수
	private int mno;//일련번호
	private String id;//아이디
	private String passwd;//비밀번호
	private String email;//이메일
	
	//생성자 함수
	//이클립스의 기능 활용해 생성
	public MemberDTO() {}
	public MemberDTO(int mno, String id, String passwd, String email) {
		this.mno = mno;
		this.id = id;
		this.passwd = passwd;
		this.email = email;
	}
	//멤버함수 method
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	










}
