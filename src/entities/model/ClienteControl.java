package entities.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import entities.view.ClienteGUI;

public class ClienteControl {
	//192.168.0.13
	
	private ClienteGUI clienteGUI;
	private Socket clienteSocket;
	private PrintWriter writer;
	private String nomeCliente;

	public ClienteControl(ClienteGUI clienteGUI) {
		this.clienteGUI = clienteGUI;
		eventos();
		
	}

	private void eventos() {
		clienteGUI.getClienteEntrada().getBtnConectar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				iniciarCliente();
				Thread thread = new Thread(new ClienteReceiver(clienteGUI, clienteSocket));
				thread.start();
			}
		});

		clienteGUI.getBtnEnviar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMsg();
			}
		});
		
		clienteGUI.getTxtMsg().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMsg();	
			}
		});
		
		clienteGUI.getBtnDesconectar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desconectarCliente();
			}
		});
	}

	private void iniciarCliente() {
		try {
			this.clienteSocket = new Socket(clienteGUI.getClienteEntrada().getTxtIp().getText(), Integer.parseInt(clienteGUI.getClienteEntrada().getTxtPorta().getText()));
			this.nomeCliente = clienteGUI.getClienteEntrada().getTxtNome().getText();
			JOptionPane.showMessageDialog(clienteGUI, "Cliente conectado com sucesso...", "Cliente",JOptionPane.INFORMATION_MESSAGE);
			clienteGUI.setVisible(true);
			clienteGUI.getClienteEntrada().setVisible(false);
			writer = new PrintWriter(clienteSocket.getOutputStream());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(clienteGUI, "Erro inesperado na conexão...", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	private void enviarMsg() {
		try {
			String msg = nomeCliente.toUpperCase() + " --> " + clienteGUI.getTxtMsg().getText();
			writer.println(msg);
			writer.flush();
			clienteGUI.getTxtMsg().setText("");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(clienteGUI, "Erro ao enviar a mensagem...", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void enviarMsg(String txt) {
		try {
			writer.println(txt);
			writer.flush();
			clienteGUI.getTxtMsg().setText("");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(clienteGUI, "Erro ao enviar a mensagem...", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void desconectarCliente() {
		enviarMsg("79466497");
	}

	public ClienteGUI getClienteGUI() {
		return clienteGUI;
	}

	public Socket getClienteSocket() {
		return clienteSocket;
	}
	
}

