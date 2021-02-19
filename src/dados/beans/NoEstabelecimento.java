package dados.beans;

import dados.ArvoreEstabelecimentosVP;

public class NoEstabelecimento {
	
	private long chave;
	private Cor cor;
	private Estabelecimento dados;
	private NoEstabelecimento pai;
	private NoEstabelecimento esquerdo;
	private NoEstabelecimento direito;
	
	public NoEstabelecimento(Estabelecimento dados){
		this.dados = dados;
		this.cor = Cor.VERMELHO;
		this.pai = null;
		this.esquerdo = null;
		this.direito = null;
	}
	
	public NoEstabelecimento(){
		
	}
	
	public void ajustarNoEstabelecimento(NoEstabelecimento a){
		a.pai = a;
		a.esquerdo = a;
		a.direito = a;
	}
	
	public void prepararNoEstabelecimento(ArvoreEstabelecimentosVP T, NoEstabelecimento a){
		a.setPai(T.getSentinela());
		a.setEsquerdo(T.getSentinela());
		a.setDireito(T.getSentinela());
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

	public Estabelecimento getDados() {
		return dados;
	}

	public void setDados(Estabelecimento dados) {
		this.dados = dados;
	}

	public NoEstabelecimento getPai() {
		return pai;
	}

	public void setPai(NoEstabelecimento pai) {
		this.pai = pai;
	}

	public NoEstabelecimento getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NoEstabelecimento esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NoEstabelecimento getDireito() {
		return direito;
	}

	public void setDireito(NoEstabelecimento direito) {
		this.direito = direito;
	}
	
	public boolean equals(NoEstabelecimento b){
		boolean retorno = false;
		if(b != null){
			retorno = (this.chave == b.getChave() && this.cor == b.getCor() && this.dados.equals(b.getDados())
					&& this.pai == b.getPai() && this.esquerdo == b.getEsquerdo() && this.direito == b.direito);
		}
		return retorno;
	}
	
	public String toString(){
		return "\n*************************\n"
				+ "*************************\nChave: " + getChave() + "\n"
				+ "Cor: " + getCor() /*+ dados.toString()*/;
	}
}
