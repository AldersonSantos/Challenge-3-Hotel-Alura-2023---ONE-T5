package br.com.challenge.one_t5.hotel_alura.modelo;

/**
 * @author Alderson Santos
 *
 */
public class Hospede {

	int numeroReserva;
	String nome;
	String sobrenome;
	String dataNascimento;
	String nacionalidade;
	String telefone;
	
	/**
	 * dados di hospede
	 *
	 */
	public Hospede(int reserva, String nome, String sobrenome, String nascimento,String nacionalidade, String telefone) {		

		 this.numeroReserva = reserva;
		 this.nome = nome;
		 this.sobrenome = sobrenome;
		 this.dataNascimento = nascimento;
		 this.nacionalidade = nacionalidade;
		 this.telefone = telefone;			
	}
	
	public Hospede(int reserva) {		

		 this.numeroReserva = reserva;
		 	
	}
	public Hospede() {		

		 
		 	
	}

	
	
	public int getNumeroReserva() {
		return numeroReserva;
	}
	
	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDataNascimento() {			
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s,%s, %s", this.numeroReserva, this.nome, this.sobrenome,
				this.dataNascimento,this.nacionalidade, this.telefone );
	}
	
}
