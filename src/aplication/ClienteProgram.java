package aplication;

import entities.model.ClienteControl;
import entities.view.ClienteGUI;

public class ClienteProgram {

	public static void main(String[] args) {
		ClienteGUI clienteGUI = new ClienteGUI();
		new ClienteControl(clienteGUI);
	}

}
