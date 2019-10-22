package upjs.sk.Prezencka;

import java.util.List;

public class Subject {
	private Long id;
	private String name;
	private List<String> students;
	private List<Practice> practices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudents(List<String> students) {
		this.students = students;
	}

	public void setPractices(List<Practice> practices) {
		this.practices = practices;
	}

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

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", students=" + students + ", practices=" + practices + "]";
	}

	public String getPresentsOfAll() {
		return null;
	}
}
