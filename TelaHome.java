package br.com.challenge.one_t5.hotel_alura.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class TelaHome extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3631128082545969319L;

	private JSplitPane splitPaneH1;
	private JLabel jLabelHome1, jLabelHome2;
	private JPanel jPanelHome1, jPanelHome2,jPanelHome3, jPanelHome4;
	private ImageIcon iconHome1, iconHome2;
	private JButton bHome1, bHome2;
	private JFrame janelaHome;

	private String url1 = "bg1_tela_inicial.png";// tela1
	private String url2 = "bg2_tela_inicial.png";// tela2

	private Integer divisorHome = 800;// 752

	private Integer wImagemHome1 = 840;// 840
	private Integer hImagemHome1 = 600;

	private Integer wImagemHome2 = 440;// 440
	private Integer hImagemHome2 = 600;
	
	private TelaLogin login;
	
		
	protected void telaHome() {

		// Jbutton
		bHome1 = new JButton("Sair");
		bHome1.setBounds(240, 350, 100, 30);
		bHome1.addActionListener(this);

		bHome2 = new JButton("Entrar");
		bHome2.setBounds(100, 350, 100, 30);
		bHome2.addActionListener(this);

		// JLabel 1
		iconHome1 = new ImageIcon(getClass().getResource(url1));
		jLabelHome1 = new JLabel(iconHome1);
		jLabelHome1.setVisible(true);
		jLabelHome1.setMinimumSize(new Dimension( wImagemHome1, hImagemHome1));
		jLabelHome1.setBounds(0, 0,  wImagemHome1, hImagemHome1);

		// JLabel 2
		iconHome2 = new ImageIcon(getClass().getResource(url2));
		jLabelHome2 = new JLabel(iconHome2);
		jLabelHome2.setMinimumSize(new Dimension(wImagemHome2, hImagemHome2));
		jLabelHome2.setBounds(0, 0, wImagemHome2,hImagemHome2);

		// Jpanel
		jPanelHome1 = new JPanel();
		jPanelHome1.setLayout(null);
		jPanelHome1.setMinimumSize(new Dimension(wImagemHome2, hImagemHome2));//
		jPanelHome1.setPreferredSize(new Dimension(wImagemHome2, hImagemHome2));//
		jPanelHome1.add(bHome2);
		jPanelHome1.add(bHome1);
		jPanelHome1.add(jLabelHome2);
		// splitpanel
		splitPaneH1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jLabelHome1, jPanelHome1);
		splitPaneH1.setResizeWeight(0.01f);
		splitPaneH1.setOneTouchExpandable(false);
		splitPaneH1.setEnabled(false);
		splitPaneH1.setContinuousLayout(true);
		splitPaneH1.setDividerLocation(divisorHome);//
		// FJrame
		janelaHome = new JFrame();
		janelaHome.setTitle("Hotel Alura: Home");
		janelaHome.setVisible(true);		
		janelaHome.setLayout(new BorderLayout(50, 50));
		janelaHome.setMinimumSize(new Dimension(1000, 600));
		janelaHome.setSize(755, 600);
		janelaHome.setExtendedState(Frame.MAXIMIZED_BOTH);
		janelaHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		jPanelHome2 = new JPanel();		
		janelaHome.add("North", jPanelHome2).setPreferredSize(new Dimension(400, 50));
		jPanelHome3 = new JPanel();		
		janelaHome.add("West", jPanelHome3).setPreferredSize(new Dimension(10, 50));
		jPanelHome4 = new JPanel();		
		janelaHome.add("East", jPanelHome4).setPreferredSize(new Dimension(10, 50));
		jPanelHome4 = new JPanel();	
		janelaHome.add("South", jPanelHome4).setPreferredSize(new Dimension(400, 50));
		janelaHome.add("Center", splitPaneH1);
		
	}
    //

	protected void setJanelaHome(boolean janelaHome) {
		this.janelaHome.setVisible(janelaHome);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(bHome2)) {	
			
			new GerenciadorJanelas(login);
			setJanelaHome(false);
			System.out.println("home PARA tela Login");
			
		}else if(e.getSource().equals(bHome1)){
			
			int sair = JOptionPane.showConfirmDialog(bHome2.getRootPane(), "Deseja sair  do sitema?", 
					"Home",JOptionPane.INFORMATION_MESSAGE );
			
			if(sair == JOptionPane.YES_OPTION) {				
				System.exit(0);
			}			
		}
	}
}
