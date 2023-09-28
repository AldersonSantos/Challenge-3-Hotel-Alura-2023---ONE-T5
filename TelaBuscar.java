package br.com.challenge.one_t5.hotel_alura.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.challenge.one_t5.hotel_alura.Controller.HospedeController;
import br.com.challenge.one_t5.hotel_alura.modelo.Hospede;

/**
 * @author Alderson Santos
 *
 */
public class TelaBuscar implements ActionListener, KeyListener {	

	//JFrame
	private JSplitPane splitPaneH1;
	private JLabel jLabelBuscarImg1, jLabelBucarImg2;

	private JPanel jPanelBuscar1, jPanelBuscar2, jPanelBuscar3, jPanelBuscar4, jPanelBuscar5, jPanelBuscar6,
			jPanelBuscar7, jPanelBuscar8 ;
	
	private Container  jPanelTabela;
	
	private ImageIcon iconBucar1, iconBuscar2;
	
	private JButton bEditar, bBuscar, bVoltar;	
	
	private JFrame jFrameBuscar;
	
	private JTextField jTextBusca;
	
	private JTable jTableBuscar ;	

    //Imagem
	private String url1 = "bg1_busca.png";// tela1
	private String url2 = "bg2_busca.png";// tela2

	// Dimensoes JFrame
	private Integer divisorBuscar =545;// 752
	
	private Integer wImagemBuscar1 = 590;// 840
	private Integer hImagemBuscar1 = 600;
	private Integer wImagemBuscar2 = 688;// 440
	private Integer hImagemBuscar2 = 600;	
	
	private DefaultTableModel tabela; 
	
	private JComboBox <String> jCompoBusca;		
	
	private TelaRegistroHospede tela_registro;
	
	boolean textoInvalido ;	
	private boolean edicao = false;
	Boolean buscaRealizada = false;
	
	private int index;
	
	/**
	 * 
	 * configurar JFrame
	 * 
	 */
	public void telaBuscar() {

		// Jbutton
		bEditar = new JButton("Editar");
		bEditar.setBounds(160, 440, 100, 30);
		bEditar.addActionListener(this);
		bEditar.setEnabled(true);		
		//
		bBuscar = new JButton("Buscar");
		bBuscar.setBounds(130, 472, 150, 30);
		bBuscar.addActionListener(this);
		bBuscar.setEnabled(true);
		//
		bVoltar = new JButton("Voltar");
		bVoltar.setBounds(55, 440, 100, 30);		
		bVoltar.addActionListener(this);
		bVoltar.setEnabled(true);
		//
		jCompoBusca = new JComboBox<>();
		jCompoBusca.setBounds(60, 100, 150, 25);
		jCompoBusca.addItem("Numero reserva");
		jCompoBusca.addItem("Sobrenome");
		jCompoBusca.addItem("Todos Hospedes");
		//
		jTextBusca = new JTextField(20);
		jTextBusca.setPreferredSize(new Dimension(150, 25));
		jTextBusca.addKeyListener(this);		
		//
		tabela = new DefaultTableModel();
		//
		jTableBuscar = new JTable(tabela);
		jTableBuscar.setPreferredScrollableViewportSize(new Dimension(582, 275));
		jTableBuscar.setFillsViewportHeight(true);
		//
		tabela.addColumn("Numero reserva ");
		tabela.addColumn("Nome");
		tabela.addColumn("Sobrenome");
		tabela.addColumn("Nascimento");
		tabela.addColumn("Nacionalidade");
		tabela.addColumn("Telefone");
		tabela.fireTableStructureChanged();
		//
		JScrollPane jScrollPaneBuscar = new JScrollPane(jTableBuscar);
		jScrollPaneBuscar.setPreferredSize(new Dimension(582, 275));
		//	
		jPanelTabela = new JPanel();
		jPanelTabela.setBackground(Color.white);
		jPanelTabela.setBounds(55, 150, 582, 282);
		jPanelTabela.add(jScrollPaneBuscar);
		//
		iconBucar1 = new ImageIcon(getClass().getResource(url1));
		jLabelBuscarImg1 = new JLabel(iconBucar1);
		jLabelBuscarImg1.setVisible(true);
		jLabelBuscarImg1.setMinimumSize(new Dimension(wImagemBuscar1, hImagemBuscar1));
		jLabelBuscarImg1.setBounds(0, 0, wImagemBuscar1, hImagemBuscar1);
		// JLabel 2
		iconBuscar2 = new ImageIcon(getClass().getResource(url2));
		jLabelBucarImg2 = new JLabel(iconBuscar2);
		jLabelBucarImg2.setMinimumSize(new Dimension(wImagemBuscar2, hImagemBuscar1));
		jLabelBucarImg2.setBounds(0, 0, wImagemBuscar2, hImagemBuscar1);
		// Jpanel		
		jPanelBuscar7 = new JPanel();
		jPanelBuscar7.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.97f));
		jPanelBuscar7.setLayout(new FlowLayout(0, 75, 15));
		jPanelBuscar7.setBounds(20, 125, 300, 300);
		jPanelBuscar7.add(jLabelBucarImg2);
		// Jpanel
		jPanelBuscar1 = new JPanel();
		jPanelBuscar1.setLayout(null);
		jPanelBuscar1.setMinimumSize(new Dimension(wImagemBuscar1, hImagemBuscar1));
		jPanelBuscar1.setPreferredSize(new Dimension(wImagemBuscar1, hImagemBuscar1));
		jPanelBuscar1.add(jLabelBuscarImg1);
		//
		jPanelBuscar8 = new JPanel();
		jPanelBuscar8.setBackground(Color.white);
		jPanelBuscar8.setLayout(new FlowLayout(1,1,1));
		jPanelBuscar8.setBounds(46, 110, 440, 25);
		jPanelBuscar8.add(jCompoBusca);
		jPanelBuscar8.add(jTextBusca);		
		jPanelBuscar8.add(bBuscar);		
		// Jpanel
		jPanelBuscar2 = new JPanel();
		jPanelBuscar2.setLayout(null);
		jPanelBuscar2.setMinimumSize(new Dimension(wImagemBuscar2, hImagemBuscar2));//
		jPanelBuscar2.setPreferredSize(new Dimension(wImagemBuscar2, hImagemBuscar2));//
		jPanelBuscar2.add(jPanelBuscar8);			
		jPanelBuscar2.add(bEditar);	
		jPanelBuscar2.add(bVoltar);	
		jPanelBuscar2.add(jPanelTabela);
		jPanelBuscar2.add(jLabelBucarImg2);
		// splitpanel
		splitPaneH1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelBuscar1, jPanelBuscar2);
		splitPaneH1.setResizeWeight(0.01f);
		splitPaneH1.setOneTouchExpandable(false);
		splitPaneH1.setEnabled(false);
		splitPaneH1.setContinuousLayout(true);
		splitPaneH1.setDividerLocation(divisorBuscar);
		// FJrame
		jFrameBuscar = new JFrame();
		jFrameBuscar.setTitle("Hotel Alura: Reservas");
		jFrameBuscar.setVisible(true);
		jFrameBuscar.setLayout(new BorderLayout(50, 50));
		jFrameBuscar.setMinimumSize(new Dimension(1000, 600));
		jFrameBuscar.setSize(755, 600);
		jFrameBuscar.setExtendedState(Frame.MAXIMIZED_BOTH);
		jFrameBuscar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		jPanelBuscar3 = new JPanel();		
		//jPanelBuscar3.setBackground(Color.red);
		jFrameBuscar.add("North", jPanelBuscar3).setPreferredSize(new Dimension(400, 20));
		//
		jPanelBuscar4 = new JPanel();
		/// jPanelReservas4.setBackground(Color.red);
		jFrameBuscar.add("West", jPanelBuscar4).setPreferredSize(new Dimension(10, 50));
		//
		jPanelBuscar5 = new JPanel();
		// jPanelReservas5.setBackground(Color.red);
		jFrameBuscar.add("East", jPanelBuscar5).setPreferredSize(new Dimension(10, 50));
		//
		jPanelBuscar6 = new JPanel();
		// jPanelReservas6.setBackground(Color.red);
		jFrameBuscar.add("South", jPanelBuscar6).setPreferredSize(new Dimension(400, 20));
		//
		jFrameBuscar.add("Center", splitPaneH1);
		// janelaReservas.getContentPane().add(sp
	}	
	/**
	 * 
	 * consultar banco de dados
	 * 
	 */
	protected void buscarReserva() {

		String texto = jTextBusca.getText().strip();
		//Boolean isvalido;
		Integer reserva = null;

		// reserva || sobrenome en branco
		if (texto.isEmpty()) {

			JOptionPane.showMessageDialog(bBuscar, "Digite o número da reserva", "Número inválido",
					JOptionPane.ERROR_MESSAGE);
			jTextBusca.setText("");

			return;
		} else {

			reserva = Integer.valueOf(texto);

		}

		// conectar
		List<Hospede> listaTodosHospede = new ArrayList<>();
		listaTodosHospede.addAll(new HospedeController().buscarReserva(reserva));

		if (listaTodosHospede.isEmpty()) {

			JOptionPane.showMessageDialog(jTextBusca, "Reserva não encontrada", "Reserva inválida",
					JOptionPane.ERROR_MESSAGE);
			
			jTextBusca.setText("");
			edicao = false;

		} else {

			edicao = true;
			
			for (Hospede lista : listaTodosHospede) {
				
				
				tabela.addRow(new Object[] { lista.getNumeroReserva(), lista.getNome(), lista.getSobrenome(),
						lista.getDataNascimento(), lista.getNacionalidade(), lista.getTelefone() });					
				
				tabela.fireTableDataChanged();
				
				jTextBusca.setText("");

			}

		}
		
	}	

	/**
	 * 
	 * consultar banco de dados
	 * 
	 */
		protected void buscarReservaSobrenome() {

			String texto = jTextBusca.getText();
			//Boolean isvalido;

			// reserva || sobrenome en branco
			if (texto.isEmpty()) {

				JOptionPane.showMessageDialog(bBuscar, "Digite o sobrenome", "Sobrenome inválido",
						JOptionPane.ERROR_MESSAGE);
				jTextBusca.setText("");
				return;
			}
			
			// conectar
			List<Hospede> listaTodosHospede = new ArrayList<>();
			listaTodosHospede.addAll(new HospedeController().buscarReservaSobrenome(texto));

			if (listaTodosHospede.isEmpty()) {

				JOptionPane.showMessageDialog(jTextBusca, "Sobrenome não encontrado", "Sobrenome não existe",
						JOptionPane.ERROR_MESSAGE);
				jTextBusca.setText("");

			} else {

				for (Hospede lista : listaTodosHospede) {
				
					
					tabela.addRow(new Object[] { lista.getNumeroReserva(), lista.getNome(), lista.getSobrenome(),
							lista.getDataNascimento(), lista.getNacionalidade(), lista.getTelefone() });
					tabela.fireTableDataChanged();
					jTextBusca.setText("");

				}

			}

		}	
		/**
		 * 
		 * consultar banco de dados
		 * 
		 */
		protected void buscarTodosHospedes() {

			List<Hospede> listaTodosHospede = new ArrayList<>();
			listaTodosHospede.addAll(new HospedeController().listaHospede());

			if (listaTodosHospede.isEmpty()) {

				JOptionPane.showMessageDialog(jTextBusca, "Não existe Hospede cadastrado", "Hotel vazio",
						JOptionPane.ERROR_MESSAGE);				

			} else {

				for (Hospede lista : listaTodosHospede) {

					
					tabela.addRow(new Object[] { lista.getNumeroReserva(), lista.getNome(), lista.getSobrenome(),
						lista.getDataNascimento().replaceFirst("564", "2"), lista.getNacionalidade(), lista.getTelefone() });
					tabela.fireTableDataChanged();
					
					jTextBusca.setText("");

				}

			}

		}			

		/**
		 * 
		 * detectar escrita do usuario no campo de texto
		 * 
		 */
		public void formatadoTexto(KeyEvent e) {
			
			
			char caracterInput = e.getKeyChar();
			textoInvalido = false;
			
			
			String inputUsuario =  String.valueOf(caracterInput);	
			
			
			List<String> stringPermitido = new ArrayList<>();
			stringPermitido.add("0");
			stringPermitido.add("1");
			stringPermitido.add("2");
			stringPermitido.add("3");
			stringPermitido.add("4");
			stringPermitido.add("5");
			stringPermitido.add("6");
			stringPermitido.add("7");
			stringPermitido.add("8");
			stringPermitido.add("9");
		
			
			int tamanhoArray = stringPermitido.size();			
			int contador = 0;
			
			for(int i = 0; i < tamanhoArray; i++) {
				
				
				if(!inputUsuario.contains(stringPermitido.get(i))){
					
				
					contador++;
				}				
			}
			
			if(contador > 9) {
				
				textoInvalido = true;		         
			}		
			
			
		}
		
		/**
		 * 
		 * mudar de JFrame
		 * 
		 */
		private void mudarTelaBusca(){		
				
				new GerenciadorJanelas(tela_registro);	
				new TelaRegistroHospede();
				TelaRegistroHospede.setEdicao(true);				
				new TelaRegistroHospede().setNumeroReservaEditar(this, getNumeroReserva());
				new TelaRegistroHospede().setNomeEditar(this, getNome());
				new TelaRegistroHospede().setSobrenomeEditar(this, getSobrenome());
				new TelaRegistroHospede().setDataNascimetoEditar(this, getNascimento());
				new TelaRegistroHospede().setTelefoneEditar(this, getTelefone());				
				this.jFrameBuscar.setVisible(false);			
		}
		
		
		/**
		 * 
		 *getter
		 * 
		 */
		public String getNumeroReserva() {
			
			Object  t = jTableBuscar.getValueAt(0, 0);
			String numeroreserva = String.valueOf(t);
			return numeroreserva;
		}
		
		/**
		 * 
		 * getter
		 * 
		 */
		public String getNome() {
			
			Object  t = jTableBuscar.getValueAt(0, 1);	
			String nome = String.valueOf(t);
			return nome;
		}		

		/**
		 * 
		 * getter
		 * 
		 */
		public String getSobrenome() {			

			Object  t = jTableBuscar.getValueAt(0, 2);	
			String sobrenome= String.valueOf(t);
			return sobrenome;
		}	
		/**
		 * 
		 * getter
		 * 
		 */
		public String getNascimento() {

			Object  t = jTableBuscar.getValueAt(0, 3);	
			
			String nascimento = String.valueOf(t);				
			
			String d = nascimento .substring(0, 2);
			String m = nascimento .substring(3, 5);
			String a = nascimento .substring(6, 10);
			
			String data = d.concat(m).concat(a);			
		
			return data;
		}
		/**
		 * 
		 * getter
		 * 
		 */
		public String getTelefone() {
			
			Object  t = jTableBuscar.getValueAt(0, 5);	
			String telefone = String.valueOf(t);
			return telefone ;
		}
		
		/**
		 * 
		 *detectar escolha do usuario
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent tb) {

			index = tabela.getRowCount() - 1;

			if (tb.getSource().equals(bBuscar)) {

				if (jCompoBusca.getSelectedItem().equals("Numero reserva")) {
					
					buscaRealizada = false;
					//apagar registro
					for (int i = index; i >= 0; i--) {

						tabela.removeRow(i);
					}

					if (textoInvalido) {

						JOptionPane.showMessageDialog(jTextBusca, "A reserva contem somente números", "Caracter inválido",
								JOptionPane.ERROR_MESSAGE);
						jTextBusca.setText("");
						textoInvalido = false;

					} else {

						buscarReserva();

					}

				}

				if (jCompoBusca.getSelectedItem().equals("Sobrenome")) {
					
					buscaRealizada = false;
					
					//apagar registro
					for (int i = index; i >= 0; i--) {

						tabela.removeRow(i);
					}

					buscarReservaSobrenome();
				}

				if (jCompoBusca.getSelectedItem().equals("Todos Hospedes")) {
												
					if(!buscaRealizada){
						
						//apagar registro
						for (int i = index; i >= 0; i--) {

							tabela.removeRow(i);
						}
						
						buscarTodosHospedes();
						
					}else {						

						JOptionPane.showMessageDialog(jTextBusca, "Busca já foi realizada", "Busca",
								JOptionPane.ERROR_MESSAGE);						
					}
					
					buscaRealizada = true;
				
				}
			}

			if (tb.getSource().equals(bEditar)) {				
							
				buscaRealizada = false;
				
				jCompoBusca.setSelectedItem("Numero reserva");			
				
				if(jTextBusca.getText().isBlank()) {				
					
					JOptionPane.showMessageDialog(jTextBusca, "Digite o numero da reserva", "Caracter inválido",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				for (int i = index; i >= 0; i--) {

					tabela.removeRow(i);
				}
				
				buscarReserva();						

					if (edicao) {

						mudarTelaBusca();

					}		
			
			}
			
			if (tb.getSource().equals(bVoltar)){
				
				new GerenciadorJanelas(new TelaMenuUsuario());					
				this.jFrameBuscar.setVisible(false);	
			}
			
		}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {

	
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {			
			
			System.out.println("SIM");
		
			return;

		}else if(e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
			
			return;			
		}
		

		if (jCompoBusca.getSelectedItem().equals("Numero reserva")) {
			
			
			
			if (textoInvalido) {

				JOptionPane.showMessageDialog(jTextBusca, "A reserva contem somente números", "Caracter inválido",
						JOptionPane.ERROR_MESSAGE);
				jTextBusca.setText("");
				textoInvalido = false;

			} else {

				
				formatadoTexto(e);

			}

		}		

		if (jCompoBusca.getSelectedItem().equals("Todos Hospedes")) {
			
			JOptionPane.showMessageDialog(jTextBusca, "Buscar todos não precisar inserir texto", "Buscar", JOptionPane.ERROR_MESSAGE);
			jTextBusca.setText("");
		}

	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	
	
	

}
