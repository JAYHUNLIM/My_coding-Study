package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02_insert {

	public static void main(String[] args) {
			//성적 테이블 행 추가 연습
		try {
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver ="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("오라클 DB연결 성공");
		
			//4.sql 작성
			//주의 사항 sql종결문자 ; 를 쓰면 오류 발생
			StringBuilder sql= new StringBuilder();
			sql.append(" insert into sungjuk(sno, uname, kor, eng, mat, addr, wdate)");
			
			//5. sql 형식으로 변환
			PreparedStatement pstmt= con.prepareStatement(sql.toString());
			
			//6. sql문 실행
			int cnt=pstmt.executeUpdate();//insert update delete문 실행
			
			System.out.println("실행결과"+cnt);
			
		} catch (Exception e) {
			System.out.println("오라클 DB연결 실패"+ e);
		}
		
		
	
		
		
		
	}
}
