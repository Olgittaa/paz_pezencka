package upjs.sk.Prezencka;

import java.util.List;

public class Subject {
	
	private Long id;
	private String name;
	private List<String> students;
	private List<Practice> practices;

	public List<String> getStudents() {
		return students;
	}

	public List<Practice> getPractices() {
		return practices;
	}

	public void addStudent(String studentName) {

	}

	public void modifyStudent(String newName, String oldName) {

	}

	public String getPresentsOfAll() {
		return null;
	}
}
