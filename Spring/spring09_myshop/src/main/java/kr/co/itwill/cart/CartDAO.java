package kr.co.itwill.cart;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itwill.comment.CommentDTO;

@Repository
public class CartDAO {

	public CartDAO() {
		System.out.println("CartDAO() 객체 생성");
	}
	
	@Autowired
	SqlSession sqlSession;
	
	public int CartInsert(CartDTO dto) {
		return sqlSession.insert("cart.insert", dto);
	}
	
	public List<CartDTO> list(String id) {
		return sqlSession.selectList("cart.list",id);
	}
	/*
	
	public int cartDelete(int cartno) throws Exception{
		return sqlSession.delete("cart.delete",cartno);
	}
	
	 */
	public int cartDelete(HashMap<String, Object> map) {
		return sqlSession.delete("cart.delete",map);
	}
	
}
