package kr.co.itwill.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO {

	public CommentDAO() {
		System.out.println("---CommentDAO 객체 생성");
	}

	@Autowired
	SqlSession sqlSession;

	public int commentInsert(CommentDTO comment) {
		return sqlSession.insert("comment.insert", comment);
	}

	public List<CommentDTO> commentlist(int product_code) {
		return sqlSession.selectList("comment.list", product_code);
	}
	
	public int commentDelete(int cno) throws Exception{
		return sqlSession.delete("comment.delete",cno);
	}
	public int commentUpdate(CommentDTO comment){
		return sqlSession.update("comment.update",comment);
	}
}
