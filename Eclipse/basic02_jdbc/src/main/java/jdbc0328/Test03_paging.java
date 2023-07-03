package jdbc0328;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.print.DocFlavor.STRING;
import javax.sql.RowSetInternal;

public class Test03_paging {

	public static void main(String[] args) {
		//페이징
		//sungjuk 테이블에서  uname 내림차순 정렬후 행번호 4~6만 조회
		int start=4;
		int end=6;
		
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
			sql.append("select * ");
			sql.append("from( select sno, uname, aver,addr, rownum as rnum ");
			sql.append("from( select sno, uname,aver,addr from sungjuk order by uname ) ) ");
			sql.append(" where rnum>= ? and rnum <= ? "); 
			
						
			pstmt= con.prepareStatement(sql.toString());			
			pstmt.setInt(1,start);
			pstmt.setInt(2, end);

			rs =pstmt.executeQuery();						
			if(rs.next()) {		
				System.out.println("자료가 존재함");
				do {
					System.out.print(rs.getInt("rnum")+" ");
					System.out.print(rs.getInt("sno")+" ");
					System.out.print(rs.getString("uname")+" ");
					System.out.print(rs.getInt("aver")+" ");
					System.out.print(rs.getString("addr")+" ");
					
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
