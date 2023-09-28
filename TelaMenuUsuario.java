package br.com.challenge.one_t5.hotel_alura.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class TelaMenuUsuario extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3455362878563902691L;
	
	private JSplitPane splitPaneMenu1;
	private JLabel jLabelMenu1, jLabelMenu2, jLabelMenuData;
	private JPanel jPanelMenu1, jPanelMenu2, jPanelMenu3, jPanelMenu4, jPanelMenu5, jPanelMenu6,jPanelMenuData ;
	private ImageIcon iconMenu1, iconMenu2;
	private JButton bMenu1, bMenu2, bMenu3;
	private JFrame jFrameMenu1;

	private  String url1 = "bg1_menu_usuario.png";// tela1
	private  String url2 = "bg2_menu_usuario2.png";// tela2

	private  Integer divisorMenu = 201;// 752

	private  Integer wImagemMenu1 = 201;// 840
	private  Integer hImagemMenu1 = 600;

	private Integer wImagemMenu2 = 1079;// 440
	private Integer hImagemMenu2 = 600;

	private TelaLogin login_menu;
	private TelaReservas tela_reserva;
	private TelaBuscar tela_buscar;

	
	LocalDateTime data;
	DateTimeFormatter formatoData;
	String dataSistema;
	
	
	
	public void telaMenu() {

		// Jbutton
		bMenu1 = new JButton("Buscar");
		bMenu1.setBounds(80, 260, 100, 30);
		bMenu1.addActionListener(this);

		bMenu2 = new JButton("Reservas");
		bMenu2.setBounds(80, 360, 100, 30);
		bMenu2.addActionListener(this);

		bMenu3 = new JButton("Sair");
		bMenu3.setBounds(80, 460, 100, 30);
		bMenu3.addActionListener(this);

		// JLabel 1
		iconMenu1 = new ImageIcon(getClass().getResource(url1));
		jLabelMenu1 = new JLabel(iconMenu1);
		jLabelMenu1.setVisible(true);
		jLabelMenu1.setMinimumSize(new Dimension( wImagemMenu1,hImagemMenu1));
		jLabelMenu1.setBounds(0, 0, wImagemMenu1,hImagemMenu1);

		// JLabel 2
		iconMenu2 = new ImageIcon(getClass().getResource(url2));
		jLabelMenu2 = new JLabel(iconMenu2);
		jLabelMenu2.setMinimumSize(new Dimension(wImagemMenu2,hImagemMenu2));//
		jLabelMenu2.setBounds(0, 0,wImagemMenu2,hImagemMenu2);//
		//		
		jLabelMenuData = new JLabel();
		jLabelMenuData.setText( dataSistema());		
		
		// Jpanel
		jPanelMenuData = new JPanel();		
		jPanelMenuData.setBounds(175, 19, 80, 18);
		jPanelMenuData.setBackground(Color.white);
		jPanelMenuData.add(jLabelMenuData);		
		//
		jPanelMenu1 = new JPanel();
		jPanelMenu1.setLayout(null);
		jPanelMenu1.setMinimumSize(new Dimension(wImagemMenu2,hImagemMenu2));
		jPanelMenu1.setPreferredSize(new Dimension(wImagemMenu2,hImagemMenu2));
		//
		jPanelMenu1.add(jPanelMenuData);
		jPanelMenu1.add(jLabelMenu2);
		//
		jPanelMenu6 = new JPanel();
		jPanelMenu6.setLayout(null);
		jPanelMenu6.setMinimumSize(new Dimension(wImagemMenu2,hImagemMenu2));
		jPanelMenu6.setPreferredSize(new Dimension(wImagemMenu2,hImagemMenu2));
		jPanelMenu6.add(bMenu1);
		jPanelMenu6.add(bMenu2);
		jPanelMenu6.add(bMenu3);
		jPanelMenu6.add(jLabelMenu1);

		// splitpanel
		splitPaneMenu1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelMenu6, jPanelMenu1);
		splitPaneMenu1.setResizeWeight(0.01f);
		splitPaneMenu1.setOneTouchExpandable(false);
		splitPaneMenu1.setEnabled(false);
		splitPaneMenu1.setContinuousLayout(true);
		splitPaneMenu1.setDividerLocation(divisorMenu);
		// FJrame
		jFrameMenu1 = new JFrame();
		jFrameMenu1.setTitle("Hotel Alura: Menu");
		jFrameMenu1.setVisible(true);
		jFrameMenu1.setLayout(new BorderLayout(50, 50));
		jFrameMenu1.setMinimumSize(new Dimension(1000, 600));
		jFrameMenu1.setSize(755, 600);
		jFrameMenu1.setExtendedState(Frame.MAXIMIZED_BOTH);
		jFrameMenu1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// margens
		jPanelMenu2 = new JPanel();		
		jFrameMenu1.add("North", jPanelMenu2).setPreferredSize(new Dimension(400, 20));
		jPanelMenu3 = new JPanel();		
		jFrameMenu1.add("West", jPanelMenu3).setPreferredSize(new Dimension(10, 50));
		jPanelMenu4 = new JPanel();		
		jFrameMenu1.add("East", jPanelMenu4).setPreferredSize(new Dimension(10, 50));
		jPanelMenu5 = new JPanel();		
		jFrameMenu1.add("South", jPanelMenu5).setPreferredSize(new Dimension(400, 20));
		jFrameMenu1.add("Center", splitPaneMenu1);
		
	}

	private void setjFrameMenu1(boolean jFrameMenu1) {
		this.jFrameMenu1.setVisible(jFrameMenu1);
	}

	public String dataSistema() {	
		
		data = LocalDateTime.now();
		formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataSistema = data.format(formatoData);

		return dataSistema;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bMenu3) {

			new GerenciadorJanelas(login_menu);
			setjFrameMenu1(false);

		}else if(e.getSource() == bMenu2) {
			
			new GerenciadorJanelas(tela_reserva);
			setjFrameMenu1(false);
			
		}else if(e.getSource() == bMenu1) {
			
			new GerenciadorJanelas(tela_buscar);
			setjFrameMenu1(false);
			
		}		

	}

}
