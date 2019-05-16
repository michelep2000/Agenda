package controlador;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.AccesoDatos;
import modelo.Persona;
import vista.ControladorEdicion;
import vista.ControladorPrincipal;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	private Stage vistaEdicion;
	private AnchorPane rootLayout;
	static protected AccesoDatos data;
	protected Persona persona;
	static protected ControladorPrincipal cPrincipal;

	@Override
	public void start(Stage primaryStage) {
		data = new AccesoDatos();
		cPrincipal = new ControladorPrincipal();
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("MVC Agenda JavaFX");
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../vista/VistaPrincipal.fxml"));
			rootLayout = (AnchorPane) loader.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarVista(Button btn, String rsc) {
		try {
			FXMLLoader loader2 = new FXMLLoader();

			loader2.setLocation(Main.class.getResource("../vista/VistaEdicion.fxml"));
			rootLayout = (AnchorPane) loader2.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			vistaEdicion = new Stage();
			
			vistaEdicion.setTitle("Persona");
			vistaEdicion.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
			vistaEdicion.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void vistaPrincipal(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
		cPrincipal.setPerson();
		
	}

	public static void main(String[] args) {
	launch(args);
}
}