package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test03_update {

	public static void main(String[] args) {
		// sungjuk 테이블 행 수정 연습
		try {
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver ="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, password);
			System.out.println("오라클 DB연결 성공");
		
			StringBuilder sql= new StringBuilder();
			sql.append("update sungjuk ");
			sql.append("set tot=kor+eng+mat ");
			sql.append(",aver=(kor+eng+mat)/3 ");
			sql.append("where sno=133");
			
		
			PreparedStatement pstmt= con.prepareStatement(sql.toString());
			int cnt=pstmt.executeUpdate();
			if (cnt==0) {
				System.out.println("수정 실패");
			}else {
				System.out.println("수정 성공");
			}
			
			//자원 반납(순서주의)
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("오라클 DB연결 실패"+ e);
		}
		
		
		
	}

}
