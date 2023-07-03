package kr.co.mymelon.mediagroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;

@Repository // 모델 클래스로 지정. 스프링컨테이너가 자동으로 객체 생성해 준다
// @Service
public class MediaGroupDAO {

	// DBopen dbopen=new DBopen()과 동일한 형태
	// @Autowired 스프링 컨테이너가 생성해 준 객체를 연결
	@Autowired
	private JdbcTemplate jt;

	StringBuilder sql = null;

	public MediaGroupDAO() {
		System.out.println("MediaGroupDAO()객체 생성됨");
	}

	public int create(MediagroupDTO dto) {
		int cnt = 0;
		try {
			sql = new StringBuilder();

			sql.append(" insert into mediagroup(mediagroupno,title) ");
			sql.append(" values(mediagroup_seq.nextval,?) ");

			// insert,update,delete 실행
			cnt = jt.update(sql.toString(), dto.getTitle());

		} catch (Exception e) {
			System.out.println("미디어 그룹등록 실패" + e);
		}
		return cnt;
	}

	// -------------------------------LIST

	public List<MediagroupDTO> list() {
		List<MediagroupDTO> list = null;
		try {
			sql = new StringBuilder();
			sql.append(" select * ");
			sql.append(" from mediagroup ");
			sql.append(" order by mediagroupno desc ");

			RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {
				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					// RowMapper 선택한 행을 기준으로 담아준다
					// 행의 갯수만큼 알아서 담아준다
					MediagroupDTO dto = new MediagroupDTO();

					// 한줄에 어떻게 담을것인지 설정
					// mediagroupno, title
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}
			};
			 
			list=jt.query(sql.toString(),rowMapper);
			
		} catch (Exception e) {
			System.out.println("미디어그룹 목록 실패" + e);
		}
		return list;
	}

	// --------------------count------------
	
	public int totalRowcount() {
		int cnt=0;
		try {
		sql=new StringBuilder();
		sql.append(" select count(*) from mediagroup ");
		cnt=jt.queryForObject(sql.toString(), Integer.class);
			
		} catch (Exception e) {
			System.out.println("전체 행 갯수"+e);
		}
		return cnt;
	}
	//---------------------delete----------
	public int delete(int mediagroupno) {
		int cnt=0;
		try {
			sql=new StringBuilder();
			sql.append(" delete from mediagroup ");
			sql.append(" where mediagroupno=? ");
			
			cnt=jt.update(sql.toString(),mediagroupno);
	
		} catch (Exception e) {
			System.out.println("삭제 실패"+e);
		}
		return cnt;
	}

	//-------------update
	
	public int update(MediagroupDTO dto) {
	int cnt=0;
	try {
		sql=new StringBuilder();
		sql.append(" update mediagroup ");
		sql.append(" set title=? ");
		sql.append(" where mediagroupno=? ");
		
		cnt=jt.update(sql.toString(),dto.getTitle(),dto.getMediagroupno());
		
		
	} catch (Exception e) {
	System.out.println("미디어 수정 실패"+e);	
	
	}
	return cnt;
	}
	
	//--------------read 
	 
	public MediagroupDTO read(int mediagroupno) {
		MediagroupDTO dto=null;
		try {
			sql=new StringBuilder();
			sql.append(" select title,mediagroupno ");
			sql.append(" from mediagroup ");
			sql.append(" where mediagroupno= " + mediagroupno);
			
			RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {
				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					// RowMapper 선택한 행을 기준으로 담아준다
					// 행의 갯수만큼 알아서 담아준다
					
					MediagroupDTO dto = new MediagroupDTO();

					// 한줄에 어떻게 담을것인지 설정
					// mediagroupno, title
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}
			};
			
			dto=jt.queryForObject(sql.toString(), rowMapper);
			
		} catch (Exception e) {
			System.out.println("불러오기 실패"+e);
		}
		 return dto;
	}
	
	////////////
	
	public int totalRowCount() {
        int cnt=0;
        try {
        	sql=new StringBuilder();
        	sql.append(" SELECT COUNT(*) FROM mediagroup ");
        	
        	cnt=jt.queryForObject(sql.toString(),Integer.class);
			
		} catch (Exception e) {
			System.out.println("전체 행 갯수"+e);
		}
	return cnt;
	}
	
	////////////
	
	public List<MediagroupDTO> list2(int start,int end){
		List<MediagroupDTO> list=null;
		try {
			sql=new StringBuilder();
			sql.append(" select AA.* ");
			sql.append(" FROM( ");
			sql.append(" 	SELECT ROWNUM AS RNUM, BB.* ");
			sql.append("  	FROM( ");
			sql.append("  		SELECT mediagroupno, title ");
			sql.append("  		FROM mediagroup ");
			sql.append(" 			ORDER BY mediagroupno DESC ");
			sql.append("  			)BB ");
			sql.append("  				)AA ");
			sql.append(" WHERE AA.RNUM>="+ start+ "AND AA.RNUM<="+ end);
			
			RowMapper<MediagroupDTO> rowMapper = new RowMapper<MediagroupDTO>() {
				@Override
				public MediagroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						
					MediagroupDTO dto = new MediagroupDTO();
					dto.setMediagroupno(rs.getInt("mediagroupno"));
					dto.setTitle(rs.getString("title"));
					return dto;
				}
			};
			list=jt.query(sql.toString(), rowMapper);
			
		} catch (Exception e) {
			System.out.println("페이징 실패"+e);
		}
		
		return list;
	}
	
	
}
