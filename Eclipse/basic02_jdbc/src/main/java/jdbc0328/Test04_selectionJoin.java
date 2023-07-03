package jdbc0328;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.print.DocFlavor.STRING;
import javax.sql.RowSetInternal;

public class Test04_selectionJoin {

	public static void main(String[] args) {
		// 학번 g1001이 수강신청한 과목을 과목코드 별로 조회하시오
		/*
		 		g1001 	d001	html
		 		g1001 	p001	java
		 		g1001 	p002	oracle
		 		g1001 	p003	jsp
		 
		  		hakno gcode gname
		  */
		String hakno="g1001";
		
		
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
			sql.append(" SELECT * ");
			sql.append(" FROM( ");
			sql.append(" select TB.hakno, GW.gcode, GW.gname ");
			sql.append(" from tb_sugang TB join tb_gwamok GW "); 
			sql.append(" on TB.gcode= GW.gcode "); 
			sql.append(" WHERE  hakno = ? ) "); 
			sql.append(" ORDER BY gcode "); 
						
			pstmt= con.prepareStatement(sql.toString());			
			pstmt.setString(1,hakno);

			rs =pstmt.executeQuery();						
			if(rs.next()) {		
				System.out.println("자료가 존재함");
				do {
					System.out.print(rs.getString("hakno")+" ");
					System.out.print(rs.getString("gcode")+" ");
					System.out.print(rs.getString("gname")+" ");
					System.out.println();
				} while (rs.next()); 
				
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