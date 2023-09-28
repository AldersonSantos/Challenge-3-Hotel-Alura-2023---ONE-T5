package br.com.challenge.one_t5.hotel_alura.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import br.com.challenge.one_t5.hotel_alura.Factory.ConectionFactoryLogin;
import br.com.challenge.one_t5.hotel_alura.dao.UsuarioDAO;

public class TelaLogin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1211367616377463236L;

	private JSplitPane splitPaneL1;
	private JLabel jLabelLogin1, jLabelLogin2, jLabelLogin3, jLabelLogin4;
	private JPanel jPanelLogin1, jPanelLogin2, jPanelLogin3, jPanelLogin4, jPanelLogin5, jPanelLogin6, jPanelLogin7;
	private ImageIcon iconLogin1, iconLogin2;

	private JButton bLogin1;

	private JTextField campoTextoLogin1;

	private JPasswordField senhaLogin1;

	private JFrame janelaLogin;

	private String urlImagemLogin1 = "bg2_login.png";
	private String urlImagemLogin2 = "bg1_login.png";
	private Integer divisorLogin = 752;
	private Integer wImagemLogin1 = 752;
	private Integer hImagemLogin1 = 600;
	private Integer wImagemLogin2 = 528;
	private Integer hImagemLogin2 = 600;
	
	
	private TelaMenuUsuario menu;	
	

	protected void telaLogin() {

	// JButton
	bLogin1 = new JButton("Confirmar");
	bLogin1.setVisible(true);
	bLogin1.addActionListener(this);

	// Jlabel esquerdo
	iconLogin1 = new ImageIcon(getClass().getResource(urlImagemLogin1));
	jLabelLogin1 = new JLabel(iconLogin1);
	jLabelLogin1.setVisible(true);
	jLabelLogin1.setMinimumSize(new Dimension(600, 400));//
	jLabelLogin1.setBounds(0, 0, (wImagemLogin1), hImagemLogin1);//
	// Jlabel direito
	iconLogin2 = new ImageIcon(getClass().getResource(urlImagemLogin2));
	jLabelLogin2 = new JLabel(iconLogin2);
	jLabelLogin2.setVisible(true);
	jLabelLogin2.setMinimumSize(new Dimension(423, 400));//
	jLabelLogin2.setBounds(0, 0, (wImagemLogin2), hImagemLogin2);//
	jLabelLogin3 = new JLabel("Usuário");
	// campo de texto
	campoTextoLogin1 = new JTextField(30);
	// campo de texto
	jLabelLogin4 = new JLabel("Senha");
	senhaLogin1 = new JPasswordField(30);
	//JPanel	
	jPanelLogin4 = new JPanel();
	jPanelLogin4.setLayout(new FlowLayout(0, 0, 12));
	jPanelLogin4.setMinimumSize(new Dimension(200, 200));//
	jPanelLogin4.setPreferredSize(new Dimension(338, 100));
	jPanelLogin4.add(jLabelLogin4);
	jPanelLogin4.add(senhaLogin1);
	jPanelLogin4.add(bLogin1);	
	jPanelLogin4.setBackground(Color.white);

	// Jpanel esquerdo
	jPanelLogin3 = new JPanel();
	jPanelLogin3.setLayout(new FlowLayout(0, 40, 10));
	jPanelLogin3.setMinimumSize(new Dimension(200, 200));//
	jPanelLogin3.setBounds(180, 300, 400, 200);//
	jPanelLogin3.setBackground(Color.white);
	jPanelLogin3.add(jLabelLogin3);
	jPanelLogin3.add(campoTextoLogin1);
	jPanelLogin3.add(jPanelLogin4);

	jPanelLogin1 = new JPanel();
	jPanelLogin1.setLayout(null);
	jPanelLogin1.setMinimumSize(new Dimension(600, 400));//
	jPanelLogin1.setPreferredSize(new Dimension(wImagemLogin1, hImagemLogin1));//
	jPanelLogin1.add(jPanelLogin3);
	jPanelLogin1.add(jLabelLogin1);

	jPanelLogin2 = new JPanel();
	jPanelLogin2.setLayout(null);
	jPanelLogin2.setMinimumSize(new Dimension(423, 400));//
	jPanelLogin2.setPreferredSize(new Dimension(wImagemLogin2, hImagemLogin2));//
	jPanelLogin2.add(jLabelLogin2);

	// splitpanel
	splitPaneL1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelLogin1, jPanelLogin2);
	splitPaneL1.setVisible(true);
	splitPaneL1.setResizeWeight(0.1f);
	splitPaneL1.setOneTouchExpandable(false);
	splitPaneL1.setEnabled(false);
	splitPaneL1.setContinuousLayout(true);
	splitPaneL1.setDividerLocation(divisorLogin);//

	janelaLogin = new JFrame();
	janelaLogin.setTitle("Hotel Alura: Login");
	janelaLogin.setVisible(true);
	janelaLogin.setLayout(new BorderLayout(50, 50));
	janelaLogin.setMinimumSize(new Dimension(1000, 600));
	janelaLogin.setSize(755, 600);
	janelaLogin.setExtendedState(Frame.MAXIMIZED_BOTH);
	janelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// margens
	jPanelLogin4 = new JPanel();	
	janelaLogin.add("North", jPanelLogin4).setPreferredSize(new Dimension(400, 50));
	jPanelLogin5 = new JPanel();	
	janelaLogin.add("West", jPanelLogin5).setPreferredSize(new Dimension(10, 50));
	jPanelLogin6 = new JPanel();	
	janelaLogin.add("East", jPanelLogin6).setPreferredSize(new Dimension(10, 50));
	jPanelLogin7 = new JPanel();	
	janelaLogin.add("South", jPanelLogin7).setPreferredSize(new Dimension(50, 50));	
	janelaLogin.add("Center", splitPaneL1);	

	}

	private void setJanelaLogin(boolean janelaLogin) {
		
		this.janelaLogin.setVisible(janelaLogin);		
	}

	//gerenciar janelas
	private void mudarTela(){
		
		new GerenciadorJanelas(menu);		
		setJanelaLogin(false);			
	}
	
	@Override
	public void actionPerformed(ActionEvent jl) {

		if (jl.getSource().equals(bLogin1)) {

			final String nomeUsuario = String.valueOf(campoTextoLogin1.getText());
			final String senha = String.valueOf(senhaLogin1.getPassword());

			if (nomeUsuario.isBlank()) {

				JOptionPane.showMessageDialog(campoTextoLogin1, "Digite o nome de usuário", "Login", 
						JOptionPane.INFORMATION_MESSAGE );
				return;
			}
			if (senha.isBlank()) {

				JOptionPane.showMessageDialog(senhaLogin1, "Digite a senha de usuário.","Login", 
						JOptionPane.INFORMATION_MESSAGE );
				return;
			}

			//conectar database
			ConectionFactoryLogin con = new ConectionFactoryLogin();
			Connection conexao = con.recuperaConexao();
			UsuarioDAO cadastro = new UsuarioDAO(conexao);

			if (cadastro.loginUsuario(this, nomeUsuario, senha)) {

				JOptionPane.showMessageDialog(senhaLogin1, "Login efetuado com sucesso!", "Login", 
						JOptionPane.INFORMATION_MESSAGE );
				
				campoTextoLogin1.setText("");
				senhaLogin1.setText("");
				// mudar tela
				mudarTela();

			} else {

				JOptionPane.showMessageDialog(senhaLogin1, "Usuário ou senha inválido","Login", 
						JOptionPane.INFORMATION_MESSAGE );
				
				campoTextoLogin1.setText("");
				senhaLogin1.setText("");
			}

		}

	}
	

}
