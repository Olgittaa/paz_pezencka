package upjs.sk.Prezencka;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum DAOFactory {
	INSTANCE;
	
	private JdbcTemplate getJdbcTemplate() {
		MysqlDataSource dataSource=new MysqlDataSource();
		dataSource.setDatabaseName("prezencka");
		dataSource.setUser("prezencka");
		dataSource.setPassword("paz1c");
		
		return new JdbcTemplate(dataSource);
	}
}
