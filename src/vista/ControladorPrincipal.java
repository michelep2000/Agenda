package vista;

import controlador.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

public class ControladorPrincipal extends Main {

	@FXML
	private TableView<Persona> tblViewPersonas;

	@FXML
	private TableColumn<Persona, String> nombres;

	@FXML
	private TableColumn<Persona, String> apellidos;

	@FXML
	private TableColumn<Persona, String> telefonos;

	@FXML
	private Button btnNuevo;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnBorrar;

	@FXML
	public void initialize() {

		// enlazar columnas con fxId
		nombres.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		apellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellido"));
		telefonos.setCellValueFactory(new PropertyValueFactory<Persona, String>("telefono"));
		setPerson();
	}

	public void setPerson() {

		try {
			// enlazar listas con tableview
			tblViewPersonas.setItems(data.getPersonData());
		} catch (Exception e) {
		}

	}

	public void newPerson() {
		cambiarVista(btnNuevo, "../vista/VistaEdicion.fxml");
	}

	public void deletePerson() {
		if (!tblViewPersonas.getSelectionModel().isEmpty()) {
			data.deletePerson(tblViewPersonas.getSelectionModel().getSelectedIndex());
			tblViewPersonas.getSelectionModel().clearSelection();
			setPerson();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No content in table");
			alert.setContentText("You have to select a person, if the table is empty please enter a new person");
			alert.show();
		}
	}

	public void editPerson() {
		if (!tblViewPersonas.getSelectionModel().isEmpty()) {
			
			editPosition = tblViewPersonas.getSelectionModel().getSelectedIndex();
			editPerson = true;
			cambiarVista(btnEditar, "../vista/VistaEdicion.fxml");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No content in table");
			alert.setContentText("You have to select a person, if the table is empty please enter a new person");
			alert.show();
		}
	}

}
