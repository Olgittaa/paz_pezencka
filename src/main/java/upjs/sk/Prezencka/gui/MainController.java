package upjs.sk.Prezencka.gui;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import upjs.sk.Prezencka.storage.DAOFactory;
import upjs.sk.Prezencka.storage.Subject;
import upjs.sk.Prezencka.storage.SubjectDAO;

public class MainController {
	
	@FXML
	private ComboBox<Subject> subjectCombobox;
	private SubjectDAO subjectDao = DAOFactory.INSTANCE.getSubjectDAO();
	private ObservableList<Subject> subjectsModel;

	@FXML
	void initialize() {
		subjectsModel = FXCollections.observableArrayList(subjectDao.getAll());
		subjectCombobox.setItems(subjectsModel);
		subjectCombobox.getSelectionModel().selectFirst();
	}

	private void showSubjectEditWindow(SubjectEditController controller) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SubjectEdit.fxml"));
			fxmlLoader.setController(controller);
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage modalStage = new Stage();
			modalStage.setScene(scene);
			modalStage.initModality(Modality.APPLICATION_MODAL);
			modalStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void addSubjectButtonClick(ActionEvent event) {
		SubjectEditController controller = new SubjectEditController();
		showSubjectEditWindow(controller);
		
		if (controller.getSavedSubject()!=null) {
			refreshSubjectComboBox(controller.getSavedSubject());
		}
	}

	@FXML
	void editSubjectButtonClick(ActionEvent event) {
		Subject selectedSubject = subjectCombobox.getSelectionModel().getSelectedItem();
		SubjectEditController controller = new SubjectEditController(selectedSubject);
		showSubjectEditWindow(controller);
		refreshSubjectComboBox(selectedSubject);
	}

	private void refreshSubjectComboBox(Subject selectedSubject) {
		List<Subject> actualSubjects = subjectDao.getAll();
		subjectsModel.setAll(actualSubjects);
		Subject current = null;
		for (Subject actual : actualSubjects) {
			if (actual.equals(selectedSubject)) {
				current = actual;
				break;
			}
		}
		subjectCombobox.getSelectionModel().select(current);
	}
}