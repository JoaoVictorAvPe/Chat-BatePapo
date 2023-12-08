package entities.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

import entities.view.ClienteGUI;

public class ClienteReceiver implements Runnable{
	
	private ClienteGUI clienteGUI;
	private Socket cliente;
	
	public ClienteReceiver(ClienteGUI clienteGUI, Socket cliente) {
		this.clienteGUI = clienteGUI;
		this.cliente = cliente;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			String msg;
			while((msg = reader.readLine()) != null) {
				String hist = clienteGUI.getTxtHist().getText();
				clienteGUI.getTxtHist().setText(hist + msg + "\n  ");
			}
			reader.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(clienteGUI, "Erro ao receber a mensagem...", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
