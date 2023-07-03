package kr.co.itwill.order;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
public OrderDAO() {
System.out.println("OrderDAO 객체 생성");}
 @Autowired
 SqlSession sqlSession;
 
 public String orderno(String date) {
	 return sqlSession.selectOne("order.orderno",date);		 
 }
 
 public int totalamount(String s_id) {
	 return sqlSession.selectOne("order.totalamount", s_id);
 }
 
 public int orderlistInsert(OrderDTO dto) {
	 return sqlSession.insert("order.orderlistInsert", dto);
 }
 
 public int orderdetailInsert(HashMap<String, String>map) {
	 return sqlSession.delete("order.orderdetailInsert", map);
 }

 public int cartDelete(String s_id) {
	 return sqlSession.delete("order.cartDelete", s_id);
 }
 
}
