package jdbc0328;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.print.DocFlavor.STRING;

public class Test01_selectavg {

	public static void main(String[] args) {
		
		//문제. 주소가 서울인 행들의 국영수 평균값을 구하시오
		String addr="Seoul";
		
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
			sql.append("select round(avg(kor),2) as avg_kor, round(avg(eng),2)avg_eng, round(avg(mat),2) avg_mat ");
			sql.append("from sungjuk ");
			sql.append("where addr=? ");
			
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setString(1, addr);	
			
			rs =pstmt.executeQuery();
			
			if(rs.next()) {		
				System.out.println("자료가 존재함");
				//1.칼럼 순서 접근
				  System.out.printf("국어평균: %.2f\n",rs.getDouble(1));
				  System.out.printf("영어평균: %.2f\n",rs.getDouble(2));
				  System.out.printf("수학평균: %.2f\n",rs.getDouble(3));
				//2.칼럼명 접근
				  System.out.printf("국어평균: %.2f\n",rs.getDouble("avg_kor"));
				  System.out.printf("영어평균: %.2f\n",rs.getDouble("avg_eng"));
				  System.out.printf("수학평균: %.2f\n",rs.getDouble("avg_mat"));
				  
				
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
