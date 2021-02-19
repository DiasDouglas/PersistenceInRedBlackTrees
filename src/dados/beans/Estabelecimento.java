package dados.beans;

public class Estabelecimento {
	private String nome;
	private String endereco;
	private HorarioFuncionamento horario;
	private double montante;
	private double valorASerPago;
	
	public Estabelecimento(String nome, String endereco, int horaInicio,
			int horaFim, float montante, float valorASerPago){
		this.nome = nome;
		this.endereco = endereco;
		this.horario = new HorarioFuncionamento(horaInicio, horaFim);
		this.montante = montante;
		this.valorASerPago = valorASerPago;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public HorarioFuncionamento getHorario() {
		return horario;
	}

	public double getMontante() {
		return montante;
	}

	public void setMontante(double montante) {
		this.montante = montante;
	}

	public double getValorASerPago() {
		return valorASerPago;
	}

	public void setValorASerPago(double valorASerPago) {
		this.valorASerPago = valorASerPago;
	}
	
	public boolean equals(Estabelecimento b){
		boolean retorno = false;
		if(b != null){
			retorno = (this.nome.equals(b.nome) && this.endereco.equals(b.endereco)
					&& this.montante == b.montante && this.valorASerPago == b.valorASerPago);
		}
		return retorno;
		
	}
	
	public String toString(){
		return "\n*************************\n"
				+ "Estabelecimento: " + getNome() + "\n"
						+ "Endereço: " + getEndereco() + "\n"
								+ "Horario de funcionamento: " + getHorario().toString() + "\n"
										+ "Montante negociado no mês: R$ " + getMontante() + "\n"
												+ "Valor a ser pago: R$ " + getValorASerPago();
	}
	
}
