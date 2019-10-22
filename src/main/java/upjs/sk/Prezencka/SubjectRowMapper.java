package upjs.sk.Prezencka;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SubjectRowMapper implements RowMapper<Subject>{

	public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subject subject = new Subject();
		
		subject.setId(rs.getLong("id"));
		subject.setName(rs.getString("name"));
		
		return subject;
	}

}
