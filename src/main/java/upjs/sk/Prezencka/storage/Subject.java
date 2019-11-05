package upjs.sk.Prezencka.storage;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private Long id;
	private String name;
	private List<String> students=new ArrayList<>();

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

	public List<String> getStudents() {
		return students;
	}

	public void addStudent(String studentName) {
		
	}

	public void modifyStudent(String newName, String oldName) {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getPresentsOfAll() {
		return null;
	}
}
