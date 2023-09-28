package br.com.challenge.one_t5.hotel_alura.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.text.MaskFormatter;


/**
 * @author Alderson Santos
 *
 */
public class TelaReservas extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	// JFrame
	private JSplitPane splitPaneH1;
	private JLabel jLabelReservas1, jLabelReservas2, jLabelReservas3, jLabelReservas4, jLabelReservas5, jLabelReservas6,
			jLabelReservas7, jLabelReservas8, jLabelReservas9, jLabelReservas10, jLabelReservas11, jJLabelPagamento,
			jLabelReservas13, jLabelReservas14, jLabelReservas15;

	private JPanel jPanelReservas1, jPanelReservas2, jPanelReservas3, jPanelReservas4, jPanelReservas5, jPanelReservas6,
			jPanelReservas7, jPanelReservas8, jPanelReservas9;
	private ImageIcon iconReservas1, iconReservas2;
	private JButton bContinuar, bConfirmar, bVoltar;
	private JFormattedTextField campoTexto1, campoTexto2;
	private JFrame janelaReservas;
	private JRadioButton box2, box3, box1;

	// Imagem
	private String url1 = "bg1.1_reservas.png";
	private String url2 = "bg2_reservas2.png";

	// Dimensoes JFrame
	private Integer divisorReservas = 514;
	private Integer wImagemReservas1 = 558;
	private Integer hImagemReservas1 = 600;
	private Integer wImagemReservas2 = 722;
	private Integer hImagemReservas2 = 600;

	// calcular
	private Integer totalDiasReserva;
	private Integer totalDiasAno;
	private String valorHospedagemTexto;
	private Integer valorReserva = 60;
	private String numeroReservaTexto;

	// valor entrada
	private String dataChegada;
	private String d;
	private String m;
	private String a;
	private Integer diaChegada;
	private Integer mesChegada;
	private Integer anoChegada;

	// data saida
	private String dataSaida;
	private String d2;
	private String m2;
	private String a2;
	private Integer diaSaida;
	private Integer mesSaida;
	private Integer anoSaida;

	// JFormattedText
	private MaskFormatter data;
	private NumberFormat pagamento;

	private TelaRegistroHospede tela_registro;
	private TelaReservas tela_reserva;

	/**
	 * 
	 * configurar elementos graficos
	 * 
	 */
	protected void telaReservas() {

		// Jbutton
		bContinuar = new JButton("Continuar");
		bContinuar.setBounds(520, 472, 100, 30);
		bContinuar.addActionListener(this);
		bContinuar.setEnabled(false);
		//
		bConfirmar = new JButton("Confirmar reserva");
		bConfirmar.setBounds(125, 472, 150, 30);
		bConfirmar.addActionListener(this);
		bConfirmar.setEnabled(true);
		//
		bVoltar = new JButton("Voltar");
		bVoltar.setBounds(20, 472, 100, 30);
		bVoltar.addActionListener(this);
		bVoltar.setEnabled(true);
		//
		campoTexto1 = new JFormattedTextField(textoFormatoData());
		campoTexto1.setText("00000000");
		campoTexto1.setBounds(222, 142, 100, 20);
		//
		campoTexto2 = new JFormattedTextField(textoFormatoData());
		campoTexto2.setText("00000000");
		campoTexto2.setBounds(222, 175, 100, 20);
		//
		box1 = new JRadioButton("Crédito");
		box1.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.99f));
		box1.addActionListener(this);
		//
		box2 = new JRadioButton("Débito");
		box2.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.99f));
		box2.addActionListener(this);
		//
		box3 = new JRadioButton("Boleto");
		box3.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.99f));
		box3.addActionListener(this);
		// JLabel 1
		iconReservas1 = new ImageIcon(getClass().getResource(url1));
		jLabelReservas1 = new JLabel(iconReservas1);
		jLabelReservas1.setVisible(true);
		jLabelReservas1.setMinimumSize(new Dimension(wImagemReservas1, hImagemReservas1));
		jLabelReservas1.setBounds(0, 0, wImagemReservas1, hImagemReservas1);
		// JLabel 2
		iconReservas2 = new ImageIcon(getClass().getResource(url2));
		jLabelReservas2 = new JLabel(iconReservas2);
		jLabelReservas2.setMinimumSize(new Dimension(wImagemReservas2, hImagemReservas2));
		jLabelReservas2.setBounds(0, 0, wImagemReservas2, hImagemReservas2);
		//
		jLabelReservas3 = new JLabel("Data chegada");
		jLabelReservas3.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas4 = new JLabel("Data saída");
		jLabelReservas4.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas5 = new JLabel("Valor da diária");
		jLabelReservas5.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas6 = new JLabel("R$ 60");
		jLabelReservas6.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas15 = new JLabel("Forma de Pagamento");
		jLabelReservas15.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 14));
		//
		jLabelReservas7 = new JLabel("Número da reserva:");
		jLabelReservas7.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas8 = new JLabel("");
		// jLabelReservas8.setText(getT());
		jLabelReservas8.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas9 = new JLabel("Reserva para:");
		jLabelReservas9.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas10 = new JLabel("");
		jLabelReservas10.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas11 = new JLabel("Pagamento:");
		jLabelReservas11.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jJLabelPagamento = new JLabel("");
		jJLabelPagamento.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas13 = new JLabel("Valor total:");
		jLabelReservas13.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jLabelReservas14 = new JLabel("");
		jLabelReservas14.setFont(new Font(Font.SANS_SERIF, Font.LAYOUT_LEFT_TO_RIGHT, 16));
		//
		jPanelReservas9 = new JPanel();
		jPanelReservas9.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.97f));
		jPanelReservas9.setLayout(new FlowLayout(0, 15, 15));
		jPanelReservas9.setBounds(470, 125, 200, 200);
		jPanelReservas9.add(jLabelReservas7);
		jPanelReservas9.add(jLabelReservas8);
		jPanelReservas9.add(jLabelReservas9);
		jPanelReservas9.add(jLabelReservas10);
		jPanelReservas9.add(jLabelReservas11);
		jPanelReservas9.add(jJLabelPagamento);
		jPanelReservas9.add(jLabelReservas13);
		jPanelReservas9.add(jLabelReservas14);
		//
		jPanelReservas8 = new JPanel();
		jPanelReservas8.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.99f));
		jPanelReservas8.setLayout(new FlowLayout(0, 35, 5));
		jPanelReservas8.setPreferredSize(new Dimension(250, 100));
		jPanelReservas8.add(jPanelReservas9);
		jPanelReservas8.add(jLabelReservas15);
		jPanelReservas8.add(box1);
		jPanelReservas8.add(box2);
		jPanelReservas8.add(box3);
		// Jpanel
		jPanelReservas7 = new JPanel();
		jPanelReservas7.setBackground(Color.getHSBColor(0.0f, 0.0f, 0.97f));
		jPanelReservas7.setLayout(new FlowLayout(0, 75, 15));
		jPanelReservas7.setBounds(20, 125, 300, 300);
		jPanelReservas7.add(jLabelReservas2);
		jPanelReservas7.add(jLabelReservas3);
		jPanelReservas7.add(jLabelReservas4);
		jPanelReservas7.add(jLabelReservas5);
		jPanelReservas7.add(jLabelReservas6);
		jPanelReservas7.add(jPanelReservas8);
		// Jpanel
		jPanelReservas1 = new JPanel();
		jPanelReservas1.setLayout(null);
		jPanelReservas1.setMinimumSize(new Dimension(wImagemReservas1, hImagemReservas1));
		jPanelReservas1.setPreferredSize(new Dimension(wImagemReservas1, hImagemReservas1));
		jPanelReservas1.add(jLabelReservas1);
		// Jpanel
		jPanelReservas2 = new JPanel();
		jPanelReservas2.setLayout(null);
		jPanelReservas2.setMinimumSize(new Dimension(wImagemReservas2, hImagemReservas2));//
		jPanelReservas2.setPreferredSize(new Dimension(wImagemReservas2, hImagemReservas2));//
		jPanelReservas2.add(bContinuar);
		jPanelReservas2.add(bVoltar);
		jPanelReservas2.add(bConfirmar);
		jPanelReservas2.add(campoTexto1);
		jPanelReservas2.add(campoTexto2);
		jPanelReservas2.add(jPanelReservas9);
		jPanelReservas2.add(jPanelReservas7);
		jPanelReservas2.add(jLabelReservas2);
		// splitpanel
		splitPaneH1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelReservas1, jPanelReservas2);
		splitPaneH1.setResizeWeight(0.01f);
		splitPaneH1.setOneTouchExpandable(false);
		splitPaneH1.setEnabled(false);
		splitPaneH1.setContinuousLayout(true);
		splitPaneH1.setDividerLocation(divisorReservas);
		// FJrame
		janelaReservas = new JFrame();
		janelaReservas.setTitle("Hotel Alura: Reservas");
		janelaReservas.setVisible(true);
		janelaReservas.setLayout(new BorderLayout(50, 50));
		janelaReservas.setMinimumSize(new Dimension(1000, 600));
		janelaReservas.setSize(755, 600);
		janelaReservas.setExtendedState(Frame.MAXIMIZED_BOTH);
		janelaReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// margens
		jPanelReservas3 = new JPanel();
		janelaReservas.add("North", jPanelReservas3).setPreferredSize(new Dimension(400, 20));
		jPanelReservas4 = new JPanel();
		janelaReservas.add("West", jPanelReservas4).setPreferredSize(new Dimension(10, 50));
		jPanelReservas5 = new JPanel();
		janelaReservas.add("East", jPanelReservas5).setPreferredSize(new Dimension(10, 50));
		jPanelReservas6 = new JPanel();
		janelaReservas.add("South", jPanelReservas6).setPreferredSize(new Dimension(400, 20));
		janelaReservas.add("Center", splitPaneH1);

	}


	/**
	 * 
	 * desabilitar JFrame
	 * 
	 */
	private void setjanelaReservas(boolean janela) {
		this.janelaReservas.setVisible(janela);
	}


	/**
	 * 
	 * numero reserva
	 * 
	 */
	public String getnumeroReserva() {

		numeroReservaTexto = String.valueOf(numeroReserva());		

		return numeroReservaTexto;
	}
	/**
	 * 
	 * gerar numero aleatoria da reserva
	 * 
	 */
	public Integer numeroReserva() {

		Random reserva = new Random();
		Integer numeroReserva = reserva.nextInt(600);
		return numeroReserva;

	}


	/**
	 * 
	 * mascara de texto
	 * 
	 */
	private MaskFormatter textoFormatoData() {

		try {

			return data = new MaskFormatter("##/##/####");

		} catch (ParseException e) {

			e.printStackTrace();

		}
		return data;
	}
	
	/**
	 * 
	 * reset totalDiasReserva
	 * 
	 */
	private void zerarDiasReserva() {

		totalDiasReserva = 0;
		bContinuar.setEnabled(false);

	}
	
	/**
	 * 
	 * selecionar JRadioButton
	 * 
	 */
	public void selecaoBotaoBox(Boolean um, Boolean dois, Boolean tre) {

		box1.setSelected(um);
		box2.setSelected(dois);
		box3.setSelected(tre);
	}
	
	/**
	 * 
	 * calcular dia da reserva
	 * 
	 */	
	private void quantidadeDias() {

		// data chegada
		dataChegada = campoTexto1.getText();

		d = dataChegada.substring(0, 2);
		m = dataChegada.substring(3, 5);
		a = dataChegada.substring(6, 10);

		diaChegada = Integer.valueOf(d);
		mesChegada = Integer.valueOf(m);
		anoChegada = Integer.valueOf(a);

		// data saida
		dataSaida = campoTexto2.getText();

		d2 = dataSaida.substring(0, 2);
		m2 = dataSaida.substring(3, 5);
		a2 = dataSaida.substring(6, 10);

		diaSaida = Integer.valueOf(d2);
		mesSaida = Integer.valueOf(m2);
		anoSaida = Integer.valueOf(a2);
		//

		Integer anosPassado = anoSaida - anoChegada;
		Integer[] ano2023 = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Integer[] ano2024 = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Integer[] ano2025 = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Integer[] ano2026 = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Integer soma2023 = 0;
		Integer soma2024 = 0;
		Integer soma2025 = 0;
		Integer soma2026 = 0;

		if (diaChegada > 0 && diaSaida > 0) {

			if (mesChegada <= 12 && mesSaida <= 12) {

				// 2023
				if (anosPassado == 0) {

					if (anoChegada == 2023) {

						for (Integer i = mesChegada; i < mesSaida; i++) {

							soma2023 += ano2023[i];
						
						}

					} else if (anoChegada == 2024) {

						for (Integer i = mesChegada; i < mesSaida; i++) {

							soma2024 += ano2024[i];
							
						}

					} else if (anoChegada == 2025) {

						for (Integer i = mesChegada; i < mesSaida; i++) {

							soma2025 += ano2025[i];
							
						}

					} else if (anoChegada == 2026) {

						for (Integer i = mesChegada; i < mesSaida; i++) {

							soma2026 += ano2026[i];
							
						}

					}

				} else if (anosPassado > 0) {

					for (Integer i = mesChegada; i <= 12; i++) {

						if (anoChegada == 2024) {

							soma2024 += ano2024[i];
							

						} else {

							soma2023 += ano2023[i];
							
						}
					}

				}

				// 2024 1ano
				if (anosPassado == 1) {

					if (anoChegada == 2023) {

						for (Integer i2 = 0; i2 < mesSaida; i2++) {

							soma2024 += ano2024[i2];
							

						}

					} else if (anoChegada == 2024) {

						for (Integer i2 = 0; i2 < mesSaida; i2++) {

							soma2024 += ano2024[i2];
							

						}
					} else if (anoChegada == 2025) {

						for (Integer i2 = 0; i2 < mesSaida; i2++) {

							soma2025 += ano2025[i2];
							

						}

					} else if (anoChegada == 2026) {

						for (Integer i2 = 0; i2 < mesSaida; i2++) {

							soma2026 += ano2026[i2];
							

						}

					}
				} else if (anosPassado >= 1) {

					for (Integer i2 = 0; i2 <= 12; i2++) {

						soma2024 += ano2024[i2];
						
					}

				}

				// 2025 2ano
				if (anosPassado == 2) {

					for (Integer i3 = 0; i3 < mesSaida; i3++) {

						soma2025 += ano2025[i3];						
					}

				} else if (anosPassado > 2) {

					for (Integer i3 = 0; i3 <= 12; i3++) {

						soma2025 += ano2025[i3];
						
					}
				}
				// 2026 3ano
				if (anosPassado == 3) {

					for (Integer i4 = 0; i4 < mesSaida; i4++) {

						soma2026 += ano2026[i4];
						
					}
				}
			}			
			
		}	

		// calcular dias
		totalDiasAno = soma2023 + soma2024 + soma2025 + soma2026;			
		totalDiasReserva = (totalDiasAno) + ((diaSaida - diaChegada));	
		
		// alerta dia/mes/ano
		popUp_DiaMesAno();
		
		alertaDiaMesChegada();

		alertaDiaMesSaida();


	}
	
	/**
	 * 
	 * JOptionPane alertas
	 * 
	 */
	private void popUp_DiaMes() {

		JOptionPane.showMessageDialog(campoTexto1, "Dia inválido para o mês escolhido", " Digite novamente",
				JOptionPane.ERROR_MESSAGE);
		System.out.println("dia chegada: " + diaChegada + " dia saida:  " + diaSaida);
		jLabelReservas14.setText("");
		campoTexto1.setText(d.concat(m).concat(a));
		bContinuar.setEnabled(false);
		totalDiasReserva = 0;

	}	

	/**
	 * 
	 * alerta dia invalido mes chegada
	 * 
	 */
	public void alertaDiaMesChegada() {

		switch (mesChegada) {

		case 1:
			if (diaChegada > 31) {
				
				popUp_DiaMes();
			}
			break;

		case 2:

			if (diaChegada > 28) {
				
				popUp_DiaMes();

			}

			break;

		case 3:

			if (diaChegada > 31) {
				
				popUp_DiaMes();

			}
			break;

		case 5:

			if (diaChegada > 31) {
				
				popUp_DiaMes();

			}

			break;

		case 7:

			if (diaChegada > 31) {
				
				popUp_DiaMes();

			}

			break;

		case 8:

			if (diaChegada > 31) {

				popUp_DiaMes();

			}
			break;

		case 10:

			if (diaChegada > 31) {
				
				popUp_DiaMes();
			}

			break;

		case 12:

			if (diaChegada > 31) {
				
				popUp_DiaMes();
			}

			break;

		default:
			
			if (diaChegada > 30) {
				
				popUp_DiaMes();

			}

			break;
		}
	}

	/**
	 * 
	 * alerta dia invalido mes saida
	 * 
	 */
	public void alertaDiaMesSaida() {
		
		switch (mesSaida) {

		case 1:
			if (diaSaida > 31) {
				
				popUp_DiaMes();
			}

			break;

		case 2:

			if (diaSaida  > 28) {
				
				popUp_DiaMes();
			}

			break;

		case 3:

			if (diaSaida  > 31) {
			
				popUp_DiaMes();

			}
			break;

		case 5:

			if (diaSaida  > 31) {
			
				popUp_DiaMes();

			}

		case 7:

			if (diaSaida  > 31) {
			
				popUp_DiaMes();

			}
			break;

		case 8:

			if (diaSaida  > 31) {
				
				popUp_DiaMes();

			}
			break;

		case 10:

			if (diaSaida  > 31) {
				
				popUp_DiaMes();
			}

			break;

		case 12:

			if (diaSaida  > 31) {
				
				popUp_DiaMes();

			}

			break;

		default:
			
			if (diaSaida  > 30) {

				System.out.println("default");
				popUp_DiaMes();

			}

			break;
		}
	}

	/**
	 * 
	 * alerta dia | mes | ano invalido
	 * 
	 */
	public void popUp_DiaMesAno() {
		
		if (anoSaida.equals(anoChegada)) {

			if (mesSaida < mesChegada) {

				JOptionPane.showMessageDialog(campoTexto1, "Mês saída inválido", "Digite novamente",
						JOptionPane.ERROR_MESSAGE);
				campoTexto1.setText(d.concat(m).concat(a));
				zerarDiasReserva();

			} else if (mesSaida == mesChegada) {

				if (diaSaida <= diaChegada) {

					JOptionPane.showMessageDialog(campoTexto1, "Dia saída inválido", "Digite novamente",
							JOptionPane.ERROR_MESSAGE);
					campoTexto1.setText(d.concat(m).concat(a));
					zerarDiasReserva();
				}

			}

		}

		if (diaChegada == 00) {

			JOptionPane.showMessageDialog(campoTexto1, "Dia chegada inválido", "Digite novamente",
					JOptionPane.ERROR_MESSAGE);
			campoTexto1.setText(d.concat(m).concat(a));
			zerarDiasReserva();

		} else if (diaSaida == 00) {

			JOptionPane.showMessageDialog(campoTexto1, "Dia saída inválido", "Digite novamente",
					JOptionPane.ERROR_MESSAGE);
			campoTexto1.setText(d.concat(m).concat(a));
			zerarDiasReserva();

		}

		// alerta mes
		if (mesChegada > 12 || mesSaida > 12) {

			JOptionPane.showMessageDialog(campoTexto1, "Mês inválido", "Digite novamente", JOptionPane.ERROR_MESSAGE);
			campoTexto1.setText(d.concat(m).concat(a));
			campoTexto2.setText(d2.concat(m2).concat(a2));
			zerarDiasReserva();

		} else if (mesChegada == 00 || mesSaida == 00) {

			JOptionPane.showMessageDialog(campoTexto1, "Mês inválido", "Digite novamente", JOptionPane.ERROR_MESSAGE);
			campoTexto1.setText(d.concat(m).concat(a));
			campoTexto2.setText(d2.concat(m2).concat(a2));
			zerarDiasReserva();
		}

		// minimo ano
		if (anoChegada < 2023 || anoSaida < 2023) {

			JOptionPane.showMessageDialog(campoTexto1, "Digite o ano da reserva, apartir de 2023", "Digite novamente",
					JOptionPane.ERROR_MESSAGE);
			campoTexto1.setText(d.concat(m).concat(a));
			campoTexto2.setText(d2.concat(m2).concat(a2));
			zerarDiasReserva();

		} else if ((anoChegada > 2026 || anoSaida > 2026)) {

			JOptionPane.showMessageDialog(campoTexto1, "Ano permitido para reserva, ate 2026", "Digite novamente",
					JOptionPane.ERROR_MESSAGE);
			campoTexto1.setText(d.concat(m).concat(a));
			campoTexto2.setText(d2.concat(m2).concat(a2));
			zerarDiasReserva();

		} else if (anoSaida < anoChegada) {

			JOptionPane.showMessageDialog(campoTexto1, "Ano saída inválido", " Digite novamente",
					JOptionPane.ERROR_MESSAGE);
			campoTexto2.setText(d2.concat(m2).concat(a2));
			zerarDiasReserva();

		}
	}

	/**
	 * 
	 * calcula o valor da hospedagem
	 * 
	 */
	private String valorHospedagem(int valor) {

		Integer valorReserva = totalDiasReserva * valor;
		valorHospedagemTexto = String.valueOf(valorReserva);

		//formato valor
		if (valorReserva < 1000) {

			pagamento = new DecimalFormat("0.00");
			valorHospedagemTexto = String.valueOf(pagamento.format(valorReserva));
			return valorHospedagemTexto;

		} else {

			pagamento = new DecimalFormat("0,000.00");
			valorHospedagemTexto = String.valueOf(pagamento.format(valorReserva));
			return valorHospedagemTexto;
		}

	}

	/**
	 * 
	 * mudar de JFrame
	 * 
	 */
	public void mudarTela() {

		new GerenciadorJanelas(tela_registro);
		new TelaRegistroHospede();
		TelaRegistroHospede.setEdicao(false);
		new TelaRegistroHospede().setNumeroReserva(tela_reserva, numeroReservaTexto);
		setjanelaReservas(false);
	}

	/**
	 * 
	 * metodo para detectar escolha do usuario
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent jr) {

		if (jr.getSource().equals(bConfirmar)) {

			quantidadeDias();
			System.out.println("action: " + diaChegada);

			if (totalDiasReserva > 0) {

				jLabelReservas14.setText("R$ " + valorHospedagem(valorReserva));
				jLabelReservas10.setText(totalDiasReserva + " dias");

				if (jJLabelPagamento.getText().equals("")) {

					JOptionPane.showMessageDialog(jLabelReservas15, "Escolha uma forma de pagamento");

				} else {

					bContinuar.setEnabled(true);
					bConfirmar.setEnabled(false);

					jLabelReservas8.setText(getnumeroReserva());

					campoTexto1.setEditable(false);
					campoTexto2.setEditable(false);

				}

			} else {

				jLabelReservas14.setText("R$ " + valorHospedagem(0));
				jLabelReservas10.setText(0 + " dias");
			}
		}
		//

		if (jr.getSource().equals(bContinuar)) {

			int voltar = JOptionPane.showConfirmDialog(bContinuar, "Deseja continuar",
					"Reserva Confirmada:Nº ".concat(numeroReservaTexto), JOptionPane.INFORMATION_MESSAGE);

			if (JOptionPane.NO_OPTION == voltar) {

				bContinuar.setEnabled(false);
				bConfirmar.setEnabled(true);

				campoTexto1.setEditable(true);
				campoTexto2.setEditable(true);

			} else if (JOptionPane.YES_OPTION == voltar) {

				mudarTela();

			}

		}

		//
		if (jr.getSource().equals(box1)) {

			selecaoBotaoBox(true, false, false);

			jJLabelPagamento.setText("Crédito");
			
		}
		//
		if (jr.getSource().equals(box2)) {

			selecaoBotaoBox(false, true, false);

			jJLabelPagamento.setText("Débito");
			

		}
		//
		if (jr.getSource().equals(box3)) {

			selecaoBotaoBox(false, false, true);

			jJLabelPagamento.setText("Boleto");
			

		}
		

		if (jr.getSource().equals(bVoltar)){
			
			new GerenciadorJanelas(new TelaMenuUsuario());					
			this.setjanelaReservas(false);

		}
	}

}
