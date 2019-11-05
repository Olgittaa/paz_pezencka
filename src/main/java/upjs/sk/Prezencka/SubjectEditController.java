package upjs.sk.Prezencka;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SubjectEditController {

	@FXML
	private ListView<String> studentListView;

	@FXML
	private TextField addStudentTextField;

	@FXML
	private Button addStudentButton;

	@FXML
	private TextField subjectNametTextField;

	@FXML
	private Button saveButton;

	private SubjectFxModel subjectModel;
	private Subject savedSubject;

	public SubjectEditController(Subject selectedSubject) {
		subjectModel = new SubjectFxModel();
		subjectModel.load(selectedSubject);
	}

	public SubjectEditController() {
		subjectModel = new SubjectFxModel();
	}

	@FXML
	void initialize() {
		subjectNametTextField.textProperty().bindBidirectional(subjectModel.nameProperty());
		studentListView.setItems(subjectModel.getStudents());
		addStudentTextField.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (newValue != null && newValue.trim().length() > 0) {
					addStudentButton.setDisable(false);
				} else {
					addStudentButton.setDisable(true);
				}
			}
		});

		addStudentButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String studentName = addStudentTextField.getText();
				subjectModel.getStudents().add(studentName);
				addStudentTextField.setText("");
			}
		});
	}

	@FXML
	void saveButtonClick(ActionEvent event) {
		if (subjectModel.getName() == null || subjectModel.getName().trim().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Nemozem ulozit");
			alert.setHeaderText("Predmet nema nazov");
			alert.setContentText("Zaplnte nazov");
			alert.show();
		} else {
			this.savedSubject=DAOFactory.INSTANCE.getSubjectDAO().save(subjectModel.getSubject());
			saveButton.getScene().getWindow().hide();
		}
	}
	public Subject getSavedSubject() {
		return savedSubject;
	}
}