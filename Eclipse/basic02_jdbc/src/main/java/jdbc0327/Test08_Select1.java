package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test08_Select1 {

	public static void main(String[] args) {
		// sungjuk 테이블에서 한행 가져오기
		int sno=132;
		
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
			sql.append("where sno=?");
				
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setInt(1, sno);
						
			rs =pstmt.executeQuery();
			if(rs.next()) {		
				System.out.println("자료가 존재함");
			//1.칼럼 순서접근
				System.out.println(rs.getInt(1)); //1번칼럼. sno
				System.out.println(rs.getString(2)); //2번칼럼. 
				System.out.println(rs.getInt(3));  
				System.out.println(rs.getInt(4)); 
				System.out.println(rs.getInt(5)); 
				System.out.println(rs.getInt(6));  
				System.out.println(rs.getInt(7));  
				System.out.println(rs.getString(8)); 
				System.out.println(rs.getString(9));  
				
				//2.칼럼명으로 접근
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("uname"));
				System.out.println(rs.getInt("kor"));
				System.out.println(rs.getInt("eng"));
				System.out.println(rs.getInt("mat"));
				System.out.println(rs.getInt("tot"));
				System.out.println(rs.getInt("aver"));
				System.out.println(rs.getString("addr"));
				System.out.println(rs.getString("wdate"));
				
				
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
