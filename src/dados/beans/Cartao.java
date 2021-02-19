package dados.beans;

public class Cartao {
	private long numero;
	private String bandeira;
	private String nomeCliente;
	private double limiteTotal;
	private double limiteDisponivel;
	
	public Cartao(long numero, String bandeira, String nomeCliente,
			double limiteTotal, double limiteDisponivel){
		this.numero = numero;
		this.bandeira = bandeira;
		this.nomeCliente = nomeCliente;
		this.limiteTotal = limiteTotal;
		this.limiteDisponivel = limiteDisponivel;
	}
	
	public Cartao(){
		this.numero = 0;
		this.bandeira = null;
		this.nomeCliente = null;
		this.limiteTotal = 0;
		this.limiteDisponivel = 0;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getLimiteTotal() {
		return limiteTotal;
	}

	public void setLimiteTotal(double limiteTotal) {
		this.limiteTotal = limiteTotal;
	}

	public double getLimiteDisponivel() {
		return limiteDisponivel;
	}

	public void setLimiteDisponivel(double limiteDisponivel) {
		this.limiteDisponivel = limiteDisponivel;
	}
	
	public boolean equals(Cartao b){
		boolean retorno = false;
		if(b != null){
			retorno = (this.numero == b.numero && this.limiteTotal == b.limiteTotal
					&& this.limiteDisponivel == b.limiteDisponivel);
		}
		return retorno;
	}
	
	public String toString(){
		return "\n*************************\nNome do Cliente: " + getNomeCliente() + "\n"
				+ "Número do Cartão: " + getNumero() + "\n"
						+ "Bandeira: " + getBandeira() + "\n"
								+ "Limite Total: R$ " + getLimiteTotal() + "\n"
										+ "Limite Disponível: R$ " + getLimiteDisponivel()+ "\n\n";
	}
}
