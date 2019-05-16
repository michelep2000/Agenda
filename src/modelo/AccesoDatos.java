package modelo;

import controlador.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccesoDatos extends Main{
	
	static protected ObservableList<Persona> personData;
	
	public AccesoDatos() {
		personData = FXCollections.observableArrayList();
		personData.add(new Persona("Adrian","cactus","123456789"));
	}
	
	public void newPerson(Persona person) {
		personData.add(person);
	}
	public ObservableList<Persona> getPersonData() {
		return personData;
	}
	
	

}
