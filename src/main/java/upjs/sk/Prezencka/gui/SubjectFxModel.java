package upjs.sk.Prezencka.gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import upjs.sk.Prezencka.storage.Subject;

public class SubjectFxModel {

	private Long id;
	private StringProperty name = new SimpleStringProperty();
	private ObservableList<String> students;

	public void load(Subject subject) {
		id = subject.getId();
		setName(subject.getName());
		students = FXCollections.observableArrayList(subject.getStudents());
	}

	public Subject getSubject() {
		Subject subject = new Subject();
		subject.setId(id);
		subject.setName(getName());
		subject.setStudents(getStudents());

		return subject;
	}

	public String getName() {
		return name.get();
	}

	public StringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public ObservableList<String> getStudents() {
		return students;
	}
}