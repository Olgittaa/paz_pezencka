package upjs.sk.Prezencka.storage;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MysqlSubjectDAO implements SubjectDAO {
	private JdbcTemplate jdbcTemplate;

	public MysqlSubjectDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Subject> getAll() {
		String sql = "SELECT id,subject.name, sas.name as 'student_name'"
				+ " FROM subject left join student_at_subject as sas on subject.id = sas.subject_id order by id;";
		// List<Subject> result = jdbcTemplate.query(sql, new SubjectRowMapper());
		List<Subject> result = jdbcTemplate.query(sql, new SubjectResultSetExtractor());
		return result;
	}

	public Subject save(Subject subject) {
		if (subject == null) {
			return null;
		}
		if (subject.getId() == null) {
			// insert
			SimpleJdbcInsert sjinsert = new SimpleJdbcInsert(jdbcTemplate);
			sjinsert.withTableName("subject");
			sjinsert.usingGeneratedKeyColumns("id");
			sjinsert.usingColumns("name");

			java.util.Map<String, Object> values = new HashMap<String, Object>();
			values.put("name", subject.getName());
			long id = sjinsert.executeAndReturnKey(values).longValue();
			subject.setId(id);
			insertStudents(subject);
		} else {
			// update
			String sql="UPDADE subject SET name=? where id ="+subject.getId();
			jdbcTemplate.update(sql,subject.getName());
			String deleteSql="student_at_subject where subject_id = "+subject.getId();
			jdbcTemplate.update(deleteSql);
			insertStudents(subject);
		}
		return subject;
	}

	private void insertStudents(Subject subject) {
		if (subject.getStudents().size() > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO student_at_subject (subject_id, name) values ");
			sb.append("(").append(subject.getId()).append(",?)");
			for (int i = 1; i < subject.getStudents().size(); i++) {
				sb.append(",(").append(subject.getId()).append(",?)");
			}
			int[] argTypes = new int[subject.getStudents().size()];
			for (int i = 0; i < argTypes.length; i++) {
				argTypes[i] = Types.VARCHAR;
			}
			jdbcTemplate.update(sb.toString(), subject.getStudents().toArray(), argTypes);
		}

	}

}
