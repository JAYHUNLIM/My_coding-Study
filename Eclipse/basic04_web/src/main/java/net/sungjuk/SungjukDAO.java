package net.sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import net.utility.DBClose;
import net.utility.DBOpen;

public class SungjukDAO {
//DATA ACCESS OBJECT
//DB관련 비즈니스 로직 구현	
	
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public SungjukDAO() {
		dbopen= new DBOpen();
	}
	
	public int insert(String uname,int kor, int eng, int mat, int aver, String addr) {
		int cnt=0;
		try {
			con=dbopen.getConnection();//db연결 
			
			sql=new StringBuilder();
			sql.append(" insert into sungjuk(sno,uname,kor,eng,mat,aver,addr,wdate) ");
			sql.append(" values(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,uname);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setInt(5, aver);
			pstmt.setString(6, addr);
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
		System.out.println("행추가 실패"+e);
		}finally {
			DBClose.close(con,pstmt);
		}
		return cnt;
	}
	
	public int create(SungjukDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append("insert into sungjuk(sno,uname,kor,eng,mat,aver,addr,wdate)");
			sql.append("values(sungjuk_seq.nextval,?,?,?,?,?,?,sysdate)");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,dto.getUname());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getAver());
			pstmt.setString(6, dto.getAddr());
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("행추가 실패"+e);
		}finally {
			DBClose.close(con,pstmt);
		}
		return cnt;
	}
	
	public ArrayList<SungjukDTO> list() {
	//데이터 베이스에서 가져온 데이터를 한꺼번에 모아서(arraylist)
	//SUNGJUKLIST.JSP에 전달
		ArrayList<SungjukDTO> list =null;
		
	try {
		con=dbopen.getConnection();
		
		sql=new StringBuilder();
		sql.append(" select sno, uname, kor, eng, mat, wdate ");
		sql.append(" from sungjuk ");
		sql.append(" order by wdate desc ");
		
		pstmt=con.prepareStatement(sql.toString());
		rs=pstmt.executeQuery();
		//dto에 모은 행을 list에 모아서 출력
		
		if(rs.next()){
			list=new ArrayList<>();
			do {	//커서가 가리키는 한줄씩 sungjukDto에 저장
				SungjukDTO dto=new SungjukDTO();
				dto.setSno(rs.getInt("sno"));
				dto.setUname(rs.getString("uname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setWdate(rs.getString("wdate"));
				
				list.add(dto);//list에 저장
			}while(rs.next());
		}else{
			list=null;
		}
		
	}catch(Exception e) {
		System.out.println("목록실패"+e);
	}finally {
		DBClose.close(con, pstmt, rs);
	}
	return list;
	}
	
	
	public SungjukDTO read(int sno) {
		SungjukDTO dto =null;
		
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select sno,uname,kor,eng,mat,aver,addr,wdate ");
			sql.append(" from sungjuk ");
			sql.append(" where sno=? ");
			
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setInt(1, sno);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dto=new SungjukDTO();
				dto.setSno(rs.getInt("sno"));
				dto.setUname(rs.getString("uname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setAver(rs.getInt("aver"));
				dto.setMat(rs.getInt("mat"));
				dto.setAddr(rs.getString("addr"));
				dto.setWdate(rs.getString("wdate"));
			}
			
		} catch (Exception e) {
			System.out.println("상세보기 실패"+e);
		}finally {
			DBClose.close(con, pstmt, rs);
		}
	return dto;
	}
	
	public int delete(int sno)  {
		int cnt=0;		
		try {
			con= dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" Delete from sungjuk ");
			sql.append(" where sno=? ");
			
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setInt(1, sno);
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("삭제 실패"+e);
		}
		
		return cnt;
	}
	
	
	public int update(SungjukDTO dto) {
		int cnt=0;
		try {
			
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" update sungjuk ");
			sql.append(" set uname=?,kor=?,eng=?,mat=?,aver=?,addr=?,wdate=sysdate ");
			sql.append(" where sno=? ");
			
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setString(1,dto.getUname());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getAver());
			pstmt.setString(6, dto.getAddr());
			pstmt.setInt(7, dto.getSno());
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println("업데이트 실패"+e);
			
		}finally {
			DBClose.close(con,pstmt);
		}
		return cnt;
	}
	

	
	}

