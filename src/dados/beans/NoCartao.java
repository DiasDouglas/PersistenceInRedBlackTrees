package dados.beans;

import dados.ArvoreCartoesVP;

public class NoCartao {
	private long chave;
	private Cor cor;
	private Cartao dados;
	private NoCartao pai;
	private NoCartao esquerdo;
	private NoCartao direito;
	
	public NoCartao(Cartao dados){
		this.dados = dados;
		this.cor = Cor.VERMELHO;
	}
	
	public NoCartao(){
	
	}
	
	public void ajustarNoCartao(ArvoreCartoesVP T, NoCartao a){
		a.pai = T.getSentinela();
		a.esquerdo = T.getSentinela();
		a.direito = T.getSentinela();
	}
	
	public void definirChave(NoCartao n){
		n.setChave(n.getDados().getNumero());
	}

	public long getChave() {
		return chave;
	}

	public void setChave(long chave) {
		this.chave = chave;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Cartao getDados() {
		return dados;
	}

	public void setDados(Cartao dados) {
		this.dados = dados;
	}

	public NoCartao getPai() {
		return pai;
	}

	public void setPai(NoCartao pai) {
		this.pai = pai;
	}

	public NoCartao getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NoCartao esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NoCartao getDireito() {
		return direito;
	}

	public void setDireito(NoCartao direito) {
		this.direito = direito;
	}
	
	/*public boolean equals(NoCartao b){
		boolean retorno = false;
		if(b != null){
			retorno = (this.chave == b.getChave());
		}
		return retorno;
	}
	*/
	public String toString(){
		return "\n*************************\n"
				+ "*************************\nChave: " + getChave() +
				"\nCor: " + getCor() + "\nDados: " + getDados() + "\n*************************\n*************************";
	}
}
