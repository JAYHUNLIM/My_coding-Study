package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test09_SelectALL {

	public static void main(String[] args) {
		//Sungjuk 테이블 전체 행 조회하기
				
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;  
		
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="system";
			String password="1234";
			String driver ="oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			System.out.println("오라클 DB연결 성공");
			
					
			StringBuilder sql= new StringBuilder();
			sql.append("select sno, uname, kor, eng, mat, tot, aver, addr, wdate ");
			sql.append("from sungjuk ");
			sql.append("order by sno desc ");
			
			pstmt= con.prepareStatement(sql.toString());
						
			rs =pstmt.executeQuery();
			if(rs.next()) {		
				System.out.println("자료가 존재함");

				do {
					System.out.print(rs.getInt("sno")+" ");
					System.out.print(rs.getString("uname")+" ");
					System.out.print(rs.getInt("kor")+" ");
					System.out.print(rs.getInt("eng")+" ");
					System.out.print(rs.getInt("mat")+" ");
					System.out.print(rs.getInt("tot")+" ");
					System.out.print(rs.getInt("aver")+" ");
					System.out.print(rs.getString("addr")+" ");
					System.out.print(rs.getString("wdate")+" ");
					System.out.println();
				} while (rs.next());  //다음 cursor가 있는지
				
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
