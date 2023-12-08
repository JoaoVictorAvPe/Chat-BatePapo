package entities.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ClienteEntradaGUI clienteEntrada;
	
	private JPanel pnlNorth;
	private JLabel lblHist;
	
	private JTextArea txtHist = new JTextArea(10, 5);
	
	private JPanel pnlSouth;
	private JPanel pnl6;
	private JLabel lblMsg;

	private JPanel pnl7;
	private JTextField txtMsg;

	private JPanel pnl8;
	private JButton btnEnviar;
	private JButton btnDesconectar;

	public ClienteGUI() {
		iniciarEntrada();
		iniciarFrame();
		componentes();
	}

	private void iniciarEntrada() {
		clienteEntrada = new ClienteEntradaGUI();
	}

	private void iniciarFrame() {
		this.setTitle("Cliente");
		this.setLocation(400, 200);
		this.setSize(450, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}

	private void componentes() {
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(getPnlNorth(), BorderLayout.NORTH);
		txtHist.setEditable(false);
		this.getContentPane().add(new JScrollPane(txtHist), BorderLayout.CENTER);
		this.getContentPane().add(getPnlSouth(), BorderLayout.SOUTH);
	}
	
	private JPanel getPnlNorth() {
		if(pnlNorth == null) {
			pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		lblHist = new JLabel("Historico");
		pnlNorth.add(lblHist);
		return pnlNorth;
	}
	
	private JPanel getPnlSouth() {
		if(pnlSouth == null) {
			pnlSouth = new JPanel(new GridLayout(3, 1));
		}
		pnlSouth.add(getPnl6());
		pnlSouth.add(getPnl7());
		pnlSouth.add(getPnl8());
		
		return pnlSouth;
	}
	

	private JPanel getPnl6() {
		if (pnl6 == null) {
			pnl6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		lblMsg = new JLabel("Mensagem");
		pnl6.add(lblMsg);
		return pnl6;
	}

	private JPanel getPnl7() {
		if (pnl7 == null) {
			pnl7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		txtMsg = new JTextField(30);
		pnl7.add(txtMsg);
		return pnl7;
	}

	private JPanel getPnl8() {
		if (pnl8 == null) {
			pnl8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnEnviar = new JButton("Enviar");
		pnl8.add(btnEnviar);
		
		btnDesconectar = new JButton("Desconectar");
		pnl8.add(btnDesconectar);
		return pnl8;
	}

	

	public JButton getBtnEnviar() {
		return btnEnviar;
	}
	
	public JButton getBtnDesconectar() {
		return btnDesconectar;
	}

	public JTextField getTxtMsg() {
		return txtMsg;
	}
	
	public ClienteEntradaGUI getClienteEntrada() {
		return clienteEntrada;
	}

	public JTextArea getTxtHist() {
		return txtHist;
	}

}
