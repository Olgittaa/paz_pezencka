package upjs.sk.Prezencka;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SubjectResultSetExtractor implements ResultSetExtractor<List<Subject>> {

	@Override
	public List<Subject> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Subject s = null;
		List<Subject> result = new ArrayList<Subject>();
		while (rs.next()) {
			long id = rs.getLong("id");
			if (s == null || s.getId() != id) {
				s = new Subject();
				s.setId(id);
				s.setName(rs.getString("name"));
				result.add(s);
			}
			String studentName = rs.getString("student_name");
			if (studentName != null) {
				s.addStudent(studentName);
			}

		}
		return result;
	}

}
