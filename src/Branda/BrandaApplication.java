package Branda;

import java.awt.Point;
//import java.nio.channels.OverlappingFileLockException;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import Member.MemberVO;
import PastOrd.PastOrdVO;
import ProdOrd.OrderVO;
import oracle.jdbc.pool.OracleDataSource;

public class BrandaApplication {
   private static MemberVO session = new MemberVO();
 
		   
   private static JdbcTemplate template = new JdbcTemplate();
   
   public static void main(String[] args) {
        new BrandaHome().initialize();
    }

    public static MemberVO getSession() {
        return session;
    }
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@192.168.34.53:1521:xe");
            dataSource.setUser("PROJECT1");
            dataSource.setPassword("JAVA");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }

}