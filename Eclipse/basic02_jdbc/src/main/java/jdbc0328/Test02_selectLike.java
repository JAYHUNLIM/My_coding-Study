package jdbc0328;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.print.DocFlavor.STRING;

public class Test02_selectLike {

	public static void main(String[] args) {
		//LIKE 연산자 연습
		//문제 이름에 '나'문자가 있는 행을 조회
		String col="uname";	//검색칼럼	keyfield
		String word="나";	//검색어	keyword
		
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
			
			//검색어가 존재하는지 
			word=word.trim();
			if (word.length()>0) {
				String where=" where "+ col +" LIKE '%"+ word +"%'";
				sql.append(where);
				//where uname like'%나%'
			}
			sql.append(" order by sno desc ");
			
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
