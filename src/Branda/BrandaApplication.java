package Branda;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import Member.MemberVO;
import Order.OrderVO;
import oracle.jdbc.pool.OracleDataSource;

public class BrandaApplication {
	private static MemberVO session = new MemberVO();
	private static OrderVO session1 = new OrderVO();
	private static JdbcTemplate template = new JdbcTemplate();
	
	public static void main(String[] args) {
        new BrandaHome().initialize();
    }

    public static MemberVO getSession() {
        return session;
    }
    
    public static OrderVO getSession1() {
        return session1;
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
