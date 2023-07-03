package jdbc0327;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test06_Update {

	public static void main(String[] args) {
		// 	sno= 141행의 데이터를 아래의 내용으로 수정하시오
		
		int sno=121;
		String uname="JSPark";
		int kor=90,eng=85,mat=100;
		int tot=(kor+eng+mat);
		int aver=tot/3;
		String addr="Suwon";
		
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
			sql.append("set uname=?, kor=?,eng=?,mat=?,tot=?,aver=?,addr=?,wdate=sysdate ");
			sql.append("where sno=?");
			
			
			
			//-> ?특정값으로 대입할 수 있는 표식
			//'?'기호 
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			//->?의 갯수, 순서, 자료형이 일치해야 한다
			
			pstmt.setString(1,uname); // 1 ->첫번째 물음표, uname 칼럼
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setInt(5,tot);
			pstmt.setInt(6,aver);
			pstmt.setString(7,addr);
			pstmt.setInt(8, sno);
			
			int cnt=pstmt.executeUpdate();
			if (cnt==0) {
				System.out.println("행 업데이트 실패");
			}else {
				System.out.println("행 업데이트 성공");
			}
			
		} catch (Exception e) {
			System.out.println("오라클 DB연결 실패:"+ e);
		}
		
		
		
		
	}

}
