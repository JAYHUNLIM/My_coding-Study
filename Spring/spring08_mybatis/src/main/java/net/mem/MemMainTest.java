package net.mem;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemMainTest {

	public static void main(String[] args) {
		try {
			//factory 공장
			//->어떤 특정 정보를 주면 객체로 생성해 줌
			// 객체 생성: new  | bean			
			
			//1.DB연결 환경 설정 파일 가져오기
			String resource="config/jdbc.xml";
			InputStream is=Resources.getResourceAsStream(resource);
			
			//2. DB연결하기 위한 팩토리 빈 생성
			SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(is);
			System.out.println("DB연결 성공");
			
			//3.쿼리문 생성 및 변환 
			// ->Prepared Statement
			SqlSession sql=ssf.openSession(true);
			/////////////////////////////////////
			
			//4.쿼리문 실행
			//int cnt=sql.insert("mem.insertRow",new MemDTO("김영희",70));
			//System.out.println("행추가 결과"+cnt);
			
			////////////////
			//수정 		"num=3" 수정
			//int cnt=sql.update("mem.UpdateRow",new MemDTO(3,"김김김",10));
			//System.out.println("행수정 결과"+cnt);
			
			//삭제
			// 나이가 50이상~
			//int cnt= sql.delete("mem.deleteRow",50);
			//System.out.println("행삭제 결과"+cnt);
			
			//목록 조회
			/*
			List<MemDTO> list=sql.selectList("mem.selectALL");
			for(int i=0;i<list.size();i++) {
				MemDTO dto=list.get(i);
				System.out.print(dto.getNum()+"");
				System.out.print(dto.getName()+"");
				System.out.print(dto.getAge()+"");
				System.out.println();
			}
			*/
			
			//검색
			// 김이라는 사람을 조회
			/*List<MemDTO> list=sql.selectList("mem.search","김");
			for(int i=0;i<list.size();i++) {
				MemDTO dto=list.get(i);
				System.out.print(dto.getNum()+"");
				System.out.print(dto.getName()+"");
				System.out.print(dto.getAge()+"");
				System.out.println();
			}
			 */
			
			//상세보기
			// 김김김 상세보기
			MemDTO dto=sql.selectOne("mem.selectRead",3);
			System.out.print(dto.getNum()+"");
			System.out.print(dto.getName()+"");
			System.out.print(dto.getAge()+"");
			System.out.println();
			
			//전체 행 갯수
			System.out.println("전체 행 갯수:"+sql.selectOne("mem.rowCount"));
			
		} catch (Exception e) {
			System.out.println("실패"+e);
		}

	}

}
