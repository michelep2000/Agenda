package vista;

import controlador.Main;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

	public void guardar() {
		data.getPersonData().add(new Persona(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText()));
		cPrincipal.setPerson();
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
