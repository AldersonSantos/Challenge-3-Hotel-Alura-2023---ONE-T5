package br.com.challenge.one_t5.hotel_alura.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import br.com.challenge.one_t5.hotel_alura.Controller.HospedeController;
import br.com.challenge.one_t5.hotel_alura.Factory.ConectionFactoryHospede;
import br.com.challenge.one_t5.hotel_alura.dao.HospedeDAO;
import br.com.challenge.one_t5.hotel_alura.modelo.Hospede;


/**
 * @author Alderson Santos
 *
 */
public class TelaRegistroHospede implements ActionListener {

	private JSplitPane splitPaneRh1;
	private JLabel jLabelRegistro1, jLabelRegistro2, jLabelRegistro3, jLabelRegistro4, jLabelRegistro5, jLabelRegistro6,
			jLabelRegistro7, jLabelRegistro8;

	private static JLabel jLabelRegistroNreserva;

	private JPanel jPanelRegistro1, jPanelRegistro2, jPanelRegistro3, jPanelRegistro4, jPanelRegistro5, jPanelRegistro6,
			jPanelRegistro7;

	private ImageIcon iconRegistro1, iconRegistro2;
	private JButton bSalvar;
	private static JButton bExcluir;
	private static JFormattedTextField dataNasT, telefoneT;
	private static JTextField nomeT, sobreNomeT;

	private JFrame janelaRegistro1;
	private static MaskFormatter dataT, foneT;

	private String url1 = "bg1_registro_hospede.png";// tela1
	private String url2 = "bg2_registro_hospede.png";// tela2
	private Integer divisorRegistro = 560;// 752
	private Integer wImagemRegistro1 = 560;// 840
	private Integer hImagemRegistro1 = 600;
	private Integer wImagemRegistro2 = 690;// 440
	private Integer hImagemRegistro2 = 600;

	private String numeroReserva;
	private String nome;
	private String sobreNome;
    private String dataNas;
	private String telefone;
	
	private Integer alertaDiaNas;

	private JComboBox<String> nacionalidade;	
	
	private Hospede hospedeHotel;
	private TelaMenuUsuario tela_menu_usuario;	
	
	
	private static Boolean edicao = false;
	private static Boolean excluir = false;

	/**
	 * 
	 * configurar elementos graficos
	 * 
	 */
	protected void telaRegistro() {
		
		// Jbutton
		bSalvar = new JButton("Salvar");
		bSalvar.setBounds(290, 380, 100, 30);
		bSalvar.setEnabled(true);
		bSalvar.addActionListener(this);
		//
		bExcluir= new JButton("Excluir");
		bExcluir.setBounds(400, 380, 100, 30);	
		bExcluir.setVisible(edicao);
		bExcluir.addActionListener(this);	
		// JLabel 1
		iconRegistro1 = new ImageIcon(getClass().getResource(url1));
		jLabelRegistro1 = new JLabel(iconRegistro1);
		jLabelRegistro1.setVisible(true);
		jLabelRegistro1.setMinimumSize(new Dimension(wImagemRegistro1, hImagemRegistro1));
		jLabelRegistro1.setBounds(0, 0, wImagemRegistro1, hImagemRegistro1);
		//
		iconRegistro2 = new ImageIcon(getClass().getResource(url2));
		jLabelRegistro2 = new JLabel(iconRegistro2);
		jLabelRegistro2.setMinimumSize(new Dimension(wImagemRegistro2, hImagemRegistro2));
		jLabelRegistro2.setBounds(0, 0, wImagemRegistro2, hImagemRegistro2);
		//
		jLabelRegistroNreserva = new JLabel("--");		
		//
		jLabelRegistro3 = new JLabel("Número reserva:");
		jLabelRegistro3.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		//
		jLabelRegistro4 = new JLabel("Nome:");
		jLabelRegistro4.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		//
		jLabelRegistro5 = new JLabel("Sobrenome:");
		jLabelRegistro5.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		//
		jLabelRegistro6 = new JLabel("Data de nascimento:");
		jLabelRegistro6.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		//
		jLabelRegistro7 = new JLabel("Nacionalidade:");
		jLabelRegistro7.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		//
		jLabelRegistro8 = new JLabel("Telefone:");
		jLabelRegistro8.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 14));

		// JTextField
		nomeT = new JTextField(20);
		sobreNomeT = new JTextField(20);
		// JFormattedTextField
		dataNasT = new JFormattedTextField(textoFormatoData());
		dataNasT.setText("00000000");
		dataNasT.setPreferredSize(new Dimension(75, 20));
		//
		telefoneT = new JFormattedTextField(textoFormatoFone());
		telefoneT.setPreferredSize(new Dimension(100, 20));
		// string nacionalidade
		String brasileiro = "Brasileiro(a)";
		String argentino = "Argentino(a)";
		String paraguaio = "Paraguaio(a)";
		String chileno = "Chileno(a)";
		String colombiano = "Colombiano(a)";
		String mexicano = "Mexicano(a)";
		String canadence = "Canadense(a)";
		String peru = "Peruano(a)";
		String equador = "Equatoriano(a)";
		String estadosUnidos = "Estadunidense(a)";
		String cuba = "Cubano(a)";
		String china = "Chinês(a)";
		String italia = "Italiano(a)";
		String japao = "japonês(a)";
		String africa = "Africano(a)";
		String holanda = "Holandês(a)";
		String arabiasaudita = "Saudita";
		String egito = "Egípseo(a)";
		String israel = "Israelense(a)";
		// JComboBox<>
		nacionalidade = new JComboBox<>();
		nacionalidade.setPreferredSize(new Dimension(150, 20));
		nacionalidade.addItem(brasileiro);
		nacionalidade.addItem(argentino);
		nacionalidade.addItem(paraguaio);
		nacionalidade.addItem(chileno);
		nacionalidade.addItem(mexicano);
		nacionalidade.addItem(canadence);
		nacionalidade.addItem(colombiano);
		nacionalidade.addItem(peru);
		nacionalidade.addItem(equador);
		nacionalidade.addItem(estadosUnidos);
		nacionalidade.addItem(cuba);
		nacionalidade.addItem(china);
		nacionalidade.addItem(italia);
		nacionalidade.addItem(japao);
		nacionalidade.addItem(africa);
		nacionalidade.addItem(holanda);
		nacionalidade.addItem(arabiasaudita);
		nacionalidade.addItem(egito);
		nacionalidade.addItem(israel);
		// JPanel
		jPanelRegistro1 = new JPanel();
		jPanelRegistro1.setLayout(null);
		jPanelRegistro1.setMinimumSize(new Dimension(wImagemRegistro1, hImagemRegistro1));
		jPanelRegistro1.setPreferredSize(new Dimension(wImagemRegistro1, hImagemRegistro1));
		jPanelRegistro1.add(jLabelRegistro1);
		//
		jPanelRegistro6 = new JPanel();
		jPanelRegistro6.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.96f));
		jPanelRegistro6.setLayout(new FlowLayout(0, 40, 15));
		jPanelRegistro6.setBounds(260, 149, 300, 216);
		jPanelRegistro6.add(jLabelRegistroNreserva);
		jPanelRegistro6.add(nomeT);
		jPanelRegistro6.add(sobreNomeT);
		jPanelRegistro6.add(dataNasT);
		jPanelRegistro6.add(nacionalidade);
		jPanelRegistro6.add(telefoneT);
		//
		jPanelRegistro7 = new JPanel();
		jPanelRegistro7.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.96f));
		jPanelRegistro7.setLayout(new FlowLayout(2, 40, 15));
		jPanelRegistro7.setBounds(120, 149, 180, 216);
		jPanelRegistro7.add(jLabelRegistro3);
		jPanelRegistro7.add(jLabelRegistro4);
		jPanelRegistro7.add(jLabelRegistro5);
		jPanelRegistro7.add(jLabelRegistro6);
		jPanelRegistro7.add(jLabelRegistro7);
		jPanelRegistro7.add(jLabelRegistro8);
		//
		jPanelRegistro2 = new JPanel();
		jPanelRegistro2.setLayout(null);
		jPanelRegistro2.setMinimumSize(new Dimension(wImagemRegistro2, hImagemRegistro2));
		jPanelRegistro2.setPreferredSize(new Dimension(wImagemRegistro2, hImagemRegistro2));
		jPanelRegistro2.add(bSalvar);
		jPanelRegistro2.add(bExcluir);	
		jPanelRegistro2.add(jPanelRegistro6);
		jPanelRegistro2.add(jPanelRegistro7);
		jPanelRegistro2.add(jLabelRegistro2);
		// splitpanel
		splitPaneRh1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelRegistro1, jPanelRegistro2);
		splitPaneRh1.setResizeWeight(0.01f);
		splitPaneRh1.setOneTouchExpandable(false);
		splitPaneRh1.setEnabled(false);
		splitPaneRh1.setContinuousLayout(true);
		splitPaneRh1.setDividerLocation(divisorRegistro);
		// JFrame
		janelaRegistro1 = new JFrame();
		janelaRegistro1.setTitle("Hotel Alura: Registro Hóspede");
		janelaRegistro1.setVisible(true);
		janelaRegistro1.setLayout(new BorderLayout(50, 50));
		janelaRegistro1.setMinimumSize(new Dimension(1000, 600));
		janelaRegistro1.setSize(755, 600);
		janelaRegistro1.setExtendedState(Frame.MAXIMIZED_BOTH);
		janelaRegistro1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//margens
		jPanelRegistro3 = new JPanel();		
		janelaRegistro1.add("North", jPanelRegistro3).setPreferredSize(new Dimension(400, 20));	
		jPanelRegistro4 = new JPanel();		
		janelaRegistro1.add("West", jPanelRegistro4).setPreferredSize(new Dimension(10, 50));		
		jPanelRegistro5 = new JPanel();	
		janelaRegistro1.add("East", jPanelRegistro5).setPreferredSize(new Dimension(10, 50));		
		jPanelRegistro6 = new JPanel();		
		janelaRegistro1.add("South", jPanelRegistro6).setPreferredSize(new Dimension(400, 20));	
		
		janelaRegistro1.add("Center", splitPaneRh1);
			
	}
	
	/**
	 * 
	 * editar dados do hospede de outra classe
	 * 
	 */
	//------------------------editar dadaos-----------------------------
	protected void setNumeroReservaEditar(TelaBuscar reserva, String t) {

		this.numeroReserva = t;		
		jLabelRegistroNreserva.setText(String.valueOf(numeroReserva));

	}	
	//
	protected void setNomeEditar(TelaBuscar nome, String t) {

		this.nome = t;		
		nomeT.setText(t);

	}	
	protected void setSobrenomeEditar(TelaBuscar sobre, String t) {

		this.sobreNome = t;		
		sobreNomeT.setText(sobreNome);

	}
	protected void setDataNascimetoEditar(TelaBuscar nascimento, String t) {

		this.dataNas= t;		
		dataNasT.setText(t);

	}
	
	protected void setTelefoneEditar(TelaBuscar telefone, String t) {

		this.telefone= t;		
		telefoneT.setText(t);

	}	
	//
	protected void setNumeroReserva(TelaReservas reserva, String t) {

		this.numeroReserva = t;		
		jLabelRegistroNreserva.setText(String.valueOf(numeroReserva));

	}
	//
	
	public static void setEdicao(Boolean edicao5) {
		
		edicao = edicao5;
		bExcluir.setVisible(edicao5);
	}
	//	
	public static void setExcluir(Boolean excluir) {
		TelaRegistroHospede.excluir = excluir;
	}	
	
	/**
	 * 
	 *pegar numero da reserva
	 * 
	 */
	private Integer getNumeroReserva() {

		String text = jLabelRegistroNreserva.getText();
		Integer numeroReserva = Integer.valueOf(text);
		
		return numeroReserva;
	}
	/**
	 * 
	 * se o numero da reserva existir, será 
	 * acrescentad 1 no valor atual
	 * 
	 */
	protected Integer getNumeroReservaAtualizado() {

		String text = jLabelRegistroNreserva.getText();
		Integer t = 1;
		Integer numeroReservaUp = Integer.valueOf(text) + t;
		
		return numeroReservaUp;
	}
	/**
	 * 
	 * formatar a data de nascimento
	 * 
	 */
	private String getDataNascimento() {

		String text = dataNasT.getText();
		String d = text.substring(0, 2);
		String m = text.substring(3, 5);
		String a = text.substring(6, 10);

		String data = a.concat("-").concat(m).concat("-").concat(d);
		
		return data;
	}
	/**
	 * 
	 * getter
	 * 
	 */
	private String getNacionalidade() {

		String textoSelecionado = String.valueOf(nacionalidade.getSelectedItem());		
		return textoSelecionado;
	}
	/**
	 * 
	 * não permitir dados invalido
	 * 
	 */
	private Boolean alertaDadosInvalido() {

		Integer t = 14;
		
		if (nomeT.getText().isBlank()) {

			JOptionPane.showMessageDialog(nomeT, "Digite seu nome", "Dado inválido", JOptionPane.ERROR_MESSAGE);
			
			return  true;
		} else if (sobreNomeT.getText().isBlank()) {

			JOptionPane.showMessageDialog(nomeT, "Digite seu sobrenome", "Dado inválido", JOptionPane.ERROR_MESSAGE);
			
			return  true;

		} else if (alertaMesDia() > 0) {

			alertaDiaNas = 0;
			
			return  true;

		} else if (telefoneT.getText().strip().length() < t) {

			JOptionPane.showMessageDialog(nomeT, "Número de telefone inválido", "Dado inválido",
					JOptionPane.ERROR_MESSAGE);
			
			return  true;

		} else {

			return  false;

		}
		

	}

	/**
	 * 
	 * JOptionPane alerta
	 * 
	 */
	private Integer alertaMesDia() {

		String text = dataNasT.getText();
		alertaDiaNas = 0;

		String d = text.substring(0, 2);
		String m = text.substring(3, 5);
		String a = text.substring(6, 10);

		Integer dia = Integer.valueOf(d);
		Integer mes = Integer.valueOf(m);
		Integer ano = Integer.valueOf(a);
		
		
		if(dia == 0) {
			
			JOptionPane.showMessageDialog(nomeT, "Data inválida", "Dado inválido", JOptionPane.ERROR_MESSAGE);
			alertaDiaNas++;
			
		}
		//
		if (mes == 0) {			
		
				JOptionPane.showMessageDialog(nomeT, "Data inválida", "Dado inválido", JOptionPane.ERROR_MESSAGE);
				alertaDiaNas++;
		}
		//
		if( ano == 0) {
			
			JOptionPane.showMessageDialog(nomeT, "Data inválida", "Dado inválido", JOptionPane.ERROR_MESSAGE);
			alertaDiaNas++;
			
		}
		//

		if (mes > 12) {

			JOptionPane.showMessageDialog(nomeT, "Mês inválido", "Dado inválido", JOptionPane.ERROR_MESSAGE);
			alertaDiaNas++;
		}

		//
		if (dia > 0) {

			switch (mes) {
			case 1:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}
				break;

			case 2:
				if (dia > 29) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}
				break;

			case 3:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}

				break;

			case 5:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}

				break;

			case 7:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}
				break;

			case 8:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}

				break;

			case 10:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}

				break;

			case 12:
				if (dia > 31) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}
				break;

			default:
				if (dia > 30) {

					JOptionPane.showMessageDialog(nomeT, "Dia inválido para mês digitado", "Dado inválido",
							JOptionPane.ERROR_MESSAGE);
					alertaDiaNas++;
				}

				break;
			}

		}
		return alertaDiaNas;

	}

	/**
	 * 
	 *mascara de texto
	 * 
	 */
	private MaskFormatter textoFormatoData() {

		try {

			return dataT = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();
			
		}
		return dataT;
	}

	/**
	 * 
	 * mascara de texto
	 * 
	 */
	private MaskFormatter textoFormatoFone() {

		try {

			return foneT = new MaskFormatter("(##)#####-####");

		} catch (ParseException e) {

			e.printStackTrace();
			
		}
		return foneT;
	}

	/**
	 * 
	 *medar de JFrame
	 * 
	 */
	private void mudarTelaRegistro(){		
		
		
		if(excluir) {
			
			JOptionPane.showMessageDialog(bSalvar, "registro excluído", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			new GerenciadorJanelas(tela_menu_usuario);
			excluir = false;
			this.janelaRegistro1.setVisible(false);		
			return;
			
		}
		
		if(!edicao) {
			
			JOptionPane.showMessageDialog(bSalvar, "Hóspede cadastro", "Cadastro", JOptionPane.INFORMATION_MESSAGE);	
			new GerenciadorJanelas(tela_menu_usuario);
			this.janelaRegistro1.setVisible(false);		
			
		}else if(edicao) {
			
			JOptionPane.showMessageDialog(bSalvar, "Cadastro atualizado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			new GerenciadorJanelas(tela_menu_usuario);
			this.janelaRegistro1.setVisible(false);		
			
		}
			
			
	}
	
	/**
	 * 
	 *detectar escolha do usuario
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent tl) {
			 		 
			if (tl.getSource().equals(bSalvar) && edicao) {


				if (!alertaDadosInvalido()) {

					ConectionFactoryHospede conH = new ConectionFactoryHospede();
					Connection conexaoH = conH.recuperaConexaoHospede();
					HospedeDAO hospede = new HospedeDAO(conexaoH);					

						hospede.atualizarHospede(hospedeHotel, getNumeroReserva(), nomeT.getText(),
						sobreNomeT.getText(), getDataNascimento(), getNacionalidade(), telefoneT.getText());

						mudarTelaRegistro();
					}


				}
				 	 
		 	 

		if (tl.getSource().equals(bSalvar) && !edicao) {
			

			if (!alertaDadosInvalido()) {

				ConectionFactoryHospede conH = new ConectionFactoryHospede();
				Connection conexaoH = conH.recuperaConexaoHospede();
				HospedeDAO hospede = new HospedeDAO(conexaoH);

				// existe numero da reserva?
				if (!hospede.checkNumeroReserva(hospedeHotel, getNumeroReserva())) {					

					hospede.salvarHospede(hospedeHotel, getNumeroReserva(), nomeT.getText(), sobreNomeT.getText(),
							getDataNascimento(), getNacionalidade(), telefoneT.getText());

					mudarTelaRegistro();
				

				} else {
					

					hospede.salvarHospede(hospedeHotel, getNumeroReservaAtualizado(), nomeT.getText(),
							sobreNomeT.getText(), getDataNascimento(), getNacionalidade(), telefoneT.getText());

					mudarTelaRegistro();
				}

			}
		}
		
		if(tl.getSource().equals(bExcluir)) {
			

			if (!alertaDadosInvalido()) {
				excluir = true;
				ConectionFactoryHospede conH = new ConectionFactoryHospede();
				Connection conexaoH = conH.recuperaConexaoHospede();
				HospedeDAO hospede = new HospedeDAO(conexaoH);				

				hospede.deletarHospede(hospedeHotel, getNumeroReserva());
			

				mudarTelaRegistro();
				

			}
			
			
		}
		
	}

}
