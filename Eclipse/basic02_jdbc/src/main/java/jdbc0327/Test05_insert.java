package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test05_insert {

	public static void main(String[] args) {
		// 변수를 이용해서 sungjuk 테이블 행 추가하기
		try {
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver ="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("오라클 DB연결 성공");
			
			String name="박지성";
			int kor=99,eng=98,mat=100;
			String addr="Seoul";
			
			StringBuilder sql= new StringBuilder();
			sql.append("insert into sungjuk(sno, uname, kor, eng, mat, addr, wdate) ");
			sql.append("values(sungjuk_seq.nextval, ?, ?, ?, ?, ?,sysdate)");
			//-> ?특정값으로 대입할 수 있는 표식
			//'?'기호 
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			//->?의 갯수, 순서, 자료형이 일치해야 한다
			pstmt.setString(1,name); // 1 ->첫번째 물음표, uname 칼럼
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setString(5,addr);
			
			int cnt=pstmt.executeUpdate();
			if (cnt==0) {
				System.out.println("행추가 실패");
			}else {
				System.out.println("행추가 성공");
			}
			
		} catch (Exception e) {
			System.out.println("오라클 DB연결 실패:"+ e);
		}

	}

}
