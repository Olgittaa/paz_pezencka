package upjs.sk.Prezencka;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SubjectEditController {

	@FXML
	private ListView<String> studentListView;
	@FXML
	private TextField addStudentTextField;

	@FXML
	private Button addStudentButton;
	@FXML
	private TableView<String> studentTableView;

	@FXML
	void initialize() {
		List<String> students = new ArrayList<>();

		ObservableList<String> studentsModel = FXCollections.observableArrayList(students);
		studentListView.setItems(studentsModel);
		studentTableView.setItems(studentsModel);
		TableColumn<String, String> nameColumn = new TableColumn<String, String>("Meno študenta");
		nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
		studentTableView.getColumns().add(nameColumn);

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
				studentsModel.add(studentName);
				addStudentTextField.setText("");
			}
		});
	}
}