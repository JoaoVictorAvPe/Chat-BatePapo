package entities.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClienteEntradaGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int txtSize = 15;
	
	private JPanel pnl_1;
	private JLabel lblNome;
	
	private JPanel pnl0;
	private JTextField txtNome;
	
	private JPanel pnl1;
	private JLabel lblIp;

	private JPanel pnl2;
	private JTextField txtIp;

	private JPanel pnl3;
	private JLabel lblPorta;

	private JPanel pnl4;
	private JTextField txtPorta;

	private JPanel pnl5;
	private JButton btnConectar;
	
	public ClienteEntradaGUI() {
		iniciarFrame();
		componentes();
		this.pack();
	}
	
	private void iniciarFrame() {
		this.setTitle("Entrada");
		this.setLocation(400, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void componentes() {
		this.getContentPane().setLayout(new GridLayout(7, 1));
		this.getContentPane().add(getPnl_1());
		this.getContentPane().add(getPnl0());
		this.getContentPane().add(getPnl1());
		this.getContentPane().add(getPnl2());
		this.getContentPane().add(getPnl3());
		this.getContentPane().add(getPnl4());
		this.getContentPane().add(getPnl5());
	}
	
	private JPanel getPnl_1() {
		if (pnl_1 == null) {
			pnl_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		lblNome = new JLabel("Nome");
		pnl_1.add(lblNome);
		return pnl_1;
	}
	
	private JPanel getPnl0() {
		if (pnl0 == null) {
			pnl0 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		txtNome = new JTextField(txtSize);
		pnl0.add(txtNome);
		return pnl0;
	}
	
	private JPanel getPnl1() {
		if (pnl1 == null) {
			pnl1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		lblIp = new JLabel("IP");
		pnl1.add(lblIp);
		return pnl1;
	}

	private JPanel getPnl2() {
		if (pnl2 == null) {
			pnl2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		txtIp = new JTextField(txtSize);
		pnl2.add(txtIp);
		return pnl2;
	}

	private JPanel getPnl3() {
		if (pnl3 == null) {
			pnl3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		lblPorta = new JLabel("Porta");
		pnl3.add(lblPorta);
		return pnl3;
	}

	private JPanel getPnl4() {
		if (pnl4 == null) {
			pnl4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		}
		txtPorta = new JTextField(txtSize);
		pnl4.add(txtPorta);
		return pnl4;
	}

	private JPanel getPnl5() {
		if (pnl5 == null) {
			pnl5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		}
		btnConectar = new JButton("Conectar");
		pnl5.add(btnConectar);
		return pnl5;
	}
	
	public JTextField getTxtNome() {
		return txtNome;
	}
	
	public JTextField getTxtIp() {
		return txtIp;
	}

	public JTextField getTxtPorta() {
		return txtPorta;
	}

	public JButton getBtnConectar() {
		return btnConectar;
	}
}
