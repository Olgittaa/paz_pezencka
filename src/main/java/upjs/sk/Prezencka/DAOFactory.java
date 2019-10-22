package upjs.sk.Prezencka;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum DAOFactory {
	INSTANCE;

	private SubjectDAO subjectDAO;

	public SubjectDAO getSubjectDAO() {
		if (subjectDAO == null) {
			subjectDAO = new MysqlSubjectDAO(getJdbcTemplate());
		}
		return subjectDAO;
	}

	private JdbcTemplate getJdbcTemplate() {
		MysqlDataSource dataSource = new MysqlDataSource();
		//dataSource.setDatabaseName("prezencka");
		dataSource.setUser("prezencka");
		dataSource.setPassword("paz1c");
		dataSource.setUrl("jdbc:mysql://localhost/prezencka?serverTimezone=Europe/Bratislava");

		return new JdbcTemplate(dataSource);
	}
}