package vista;

import controlador.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import modelo.Persona;

public class ControladorEdicion extends Main {

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtApellido;

	@FXML
	private TextField txtTelefono;

	@FXML
	private Button btnOk;

	@FXML
	public void initialize() {
		if (editPosition != -1) {
			txtNombre.setText(data.getPersonData().get(editPosition).getNombre());
			txtApellido.setText(data.getPersonData().get(editPosition).getApellido());
			txtTelefono.setText(data.getPersonData().get(editPosition).getTelefono());
		}
	}

	public void guardar(ActionEvent event) {
		if (!(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtTelefono.getText().equals(""))) {
			if (editPerson) {
				data.getPersonData().set(editPosition,
						new Persona(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText()));
				editPerson = false;
				editPosition = -1;
			} else
				data.addPersona(new Persona(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText()));
			vistaPrincipal(event);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No content in text fields");
			alert.setContentText("You have to fill the text field");
			alert.show();
		}

	}

	public void cancel(ActionEvent event) {
		vistaPrincipal(event);
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(getTxtApellido());
	}

	public String getTxtTelefono() {
		return txtTelefono.getText();
	}

	public void setTxtTelefono(String txtTelefono) {
		this.txtTelefono.setText(txtTelefono);
	}

}
