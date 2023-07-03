package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test07_Select {

	public static void main(String[] args) {
			//sungjuk 테이블의 행의 갯수를 출력하시오 
			Connection con =null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;  //select문을 실행한 결과를 테이블로 저장
			
		try {
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver ="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			System.out.println("오라클 DB연결 성공");
			
					
			StringBuilder sql= new StringBuilder();
			sql.append("select count(*) as cnt from sungjuk");
			
			pstmt= con.prepareStatement(sql.toString());
			rs =pstmt.executeQuery();//select문 실행 명령어
			
			//cursor: 행을 가리키는 값. 이동할수 있다
			if(rs.next()) {		//cursor가 존재 하는지?
				System.out.println("자료가 존재함");
				
				//1.칼럼의 순서로 접근
				//->SELECT KOR, ENG, MAT ~~
				//->자료형을 일치하면서 가져온다.
				System.out.println("전체 행 갯수:"+ rs.getInt(1));		//1번 칼럼. 자료형은 int로 가져온다
				
				//2.칼럼명으로 접근
				//-> SELECT cnt,~~~
				System.out.println("전체 행 갯수:"+ rs.getInt("cnt"));
				
								
				
			}else {
				System.out.println("자료가 없음");
			}
			
		}catch (Exception e) {
			System.out.println("오라클 DB연결 실패:"+ e);
			
		}finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				
			} catch (Exception e) {	}
			
			try {
				if (pstmt!=null) {
					pstmt.close();
				}
				
			} catch (Exception e) {	}
			
			try {
				if (con!=null) {
					con.close();
				}	
			} catch (Exception e) {}
			
		}
		
		
	}
}