package Oprod;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import Branda.BrandaApplication;
import ProdOrd.OrderVO;

public class OprodDAO {
   private static OprodDAO instance = new OprodDAO ();
   private OprodDAO () {}
   Scanner scanner = new Scanner(System.in);
   
   private JdbcTemplate template = BrandaApplication.getTemplate();
   
   public static OprodDAO getInstance() 
   {
      return instance;
   }
   public int insertOprod(OprodVO vo) {
	   
	   return template.update("");
   }
   
   //주문 상품 확인용
   public OprodVO findByOrd(String memId) {
      return template.queryForObject("   select * from(SELECT A.ORD_CODE,a.MEM_ID,A.PROD_ID,B.PROD_NAME,c.OPROD_QTY,B.PROD_PRICE\r\n"
            + "    FROM PASTORD A, PROD B, OPROD C, MEMBER D \r\n"
            + "    WHERE A.PROD_ID = B.PROD_ID\r\n"
            + "   AND A.ORD_CODE = C.ORD_CODE\r\n"
            + "  and A.MEM_ID = D.MEM_ID) where mem_id = ? \r\n" , new BeanPropertyRowMapper<>(OprodVO.class), memId);
   }


}