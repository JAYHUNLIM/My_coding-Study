package kr.co.mymelon.media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.mymelon.mediagroup.MediagroupDTO;



@Repository
public class MediaDAO {
		@Autowired
		private JdbcTemplate jt;
		private StringBuilder sql=null;
		
	public MediaDAO() {
		System.out.println("mediaDAO객체 생성됨");
		}
	
	
	public List<MediaDTO> list(int mediagroupno){
		List<MediaDTO> list=null;
		try {
			sql = new StringBuilder();
			sql.append(" select mediano,title,rdate,poster,filename,filesize,mview,mediagroupno  ");
			sql.append(" from media ");
			sql.append(" where mview='Y' and mediagroupno= " + mediagroupno);
			sql.append(" order by mediano desc ");
			
			RowMapper<MediaDTO> rowMapper=new RowMapper<MediaDTO>() {
				@Override
				public MediaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
					MediaDTO dto = new MediaDTO();
					dto.setMediano(rs.getInt("mediano"));
					dto.setTitle(rs.getString("title"));
					dto.setRdate(rs.getString("rdate"));
					dto.setPoster(rs.getString("poster"));
					dto.setFilename(rs.getString("filename"));
					dto.setFilesize(rs.getLong("filesize"));
					dto.setMview(rs.getString("mview"));
					dto.setMediagroupno(rs.getInt("mediagroupno"));

					return dto;
				}
			};
			list = jt.query(sql.toString(), rowMapper);

		} catch (Exception e) {
			System.out.println("목록 실패" + e);
		}
		return list;
	}
	
	public int create(MediaDTO dto) {
	int cnt=0;
		try {
			sql=new StringBuilder();
			sql.append(" insert into media(mediano,title,poster,filename,filesize,mediagroupno,rdate) ");
			sql.append(" values(media_seq.nextval,?,?,?,?,?,sysdate) ");
			
			cnt=jt.update(sql.toString(),dto.getTitle(),dto.getPoster(),dto.getFilename(),dto.getFilesize(),dto.getMediagroupno());
			
			
		} catch (Exception e) {
			System.out.println("음원등록 실패"+e);
		}
		
		return cnt;
	}
	
	public MediaDTO read(int mediano) {
		MediaDTO dto=null;
		try {
			sql=new StringBuilder();
			sql.append(" select mediano,title,rdate,poster,filename,filesize,mview,mediagroupno ");
			sql.append("  from media ");
			sql.append(" where mediano=" + mediano);
			
	RowMapper<MediaDTO> rowMapper=new RowMapper<MediaDTO>() {
		
		@Override
		public MediaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MediaDTO dto = new MediaDTO();
			dto.setMediano(rs.getInt("mediano"));
			dto.setTitle(rs.getString("title"));
			dto.setRdate(rs.getString("rdate"));
			dto.setPoster(rs.getString("poster"));
			dto.setFilename(rs.getString("filename"));
			dto.setFilesize(rs.getLong("filesize"));
			dto.setMview(rs.getString("mview"));
			dto.setMediagroupno(rs.getInt("mediagroupno"));
					
			return dto;
		}
	};		
			dto=jt.queryForObject(sql.toString(), rowMapper);
			
		} catch (Exception e) {
		System.out.println("상세보기 실패"+e);
		}
		return dto;
	}
	
	public int delete(int mediano) {
		int cnt=0;
		try {
			sql=new StringBuilder();
			sql.append(" delete from media ");
			sql.append(" where mediano=? ");
			cnt=jt.update(sql.toString(),mediano);
		} catch (Exception e) {
			System.out.println("삭제 실패"+e);
			
		}
		return cnt;
	}
	public int update(MediaDTO dto) {
		int cnt=0;
		try {
			sql=new StringBuilder();
			sql.append(" update media ");
			sql.append(" set title=?,poster=?,filename=?,filesize=? ");
			sql.append(" where mediano=? ");
			
			cnt=jt.update(sql.toString(),dto.getTitle(),dto.getPoster(),dto.getFilename(),dto.getFilesize(),dto.getMediano());
		} catch (Exception e) {
			System.out.println("수정실패"+e);
		}
	return cnt;
	}//update
}
