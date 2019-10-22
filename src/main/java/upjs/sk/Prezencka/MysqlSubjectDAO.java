package upjs.sk.Prezencka;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlSubjectDAO implements SubjectDAO {
	private JdbcTemplate jdbcTemplate;
	
	public MysqlSubjectDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Subject> getAll() {
		String sql="SELECT id, name FROM subject";
		List<Subject> result= jdbcTemplate.query(sql, new SubjectRowMapper());
		return result;
	}

	public Subject save(Subject subject) {
		return null;
	}

}
