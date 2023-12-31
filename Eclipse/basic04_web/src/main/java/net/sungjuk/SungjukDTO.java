package net.sungjuk;


public class SungjukDTO {	//DATA TRANSFER OBJECT 전송객체
							//VALUE OBJECT

	//성적 클래스를 기준으로 한다
	//성적 테이블 칼럼명을 기준으로 멤버 변수 선언
	private int sno;
	private String uname; 
	private int	kor; 
	private int eng;
	private int mat;
	private int aver;
	private String addr;
	private String wdate;
	
	//기본 생성자 함수
public SungjukDTO( ) {
	
}

//private  멤버 변수에 각각 getter와 setter 함수 작성
public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public int getKor() {
	return kor;
}

public void setKor(int kor) {
	this.kor = kor;
}

public int getEng() {
	return eng;
}

public void setEng(int eng) {
	this.eng = eng;
}

public int getMat() {
	return mat;
}

public void setMat(int mat) {
	this.mat = mat;
}

public int getAver() {
	return aver;
}

public void setAver(int aver) {
	this.aver = aver;
}

public String getAddr() {
	return addr;
}

public void setAddr(String addr) {
	this.addr = addr;
}

public String getWdate() {
	return wdate;
}

public void setWdate(String wdate) {
	this.wdate = wdate;
}

@Override
public String toString() {
	return "SungjukDTO [sno=" + sno + ", uname=" + uname + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", aver="
			+ aver + ", addr=" + addr + ", wdate=" + wdate + "]";
}	
}