package dados;

import java.util.ArrayList;

import dados.beans.Cartao;
import dados.beans.Cor;
import dados.beans.NoCartao;

public class ArvoreCartoesVP {
	public ArrayList<Cartao> cartoes;
	private static int qtdCadastrados;
	private NoCartao raiz;
	private NoCartao sentinela;
	
	public ArvoreCartoesVP(){
		qtdCadastrados = 0;
		sentinela = new NoCartao();
		sentinela.setDireito(sentinela);
		sentinela.setEsquerdo(sentinela);
		sentinela.setPai(sentinela);
		sentinela.setCor(Cor.PRETO);
		raiz = sentinela;
		this.cartoes = new ArrayList<>();
		
	}
	
	/*public ArvoreCartoesVP(NoCartao raiz){
		qtdCadastrados = 1;
		this.raiz = raiz;
		this.sentinela = new NoCartao();
		this.sentinela.ajustarNoCartao(this.sentinela);
		this.sentinela.setCor(Cor.PRETO);
		this.raiz.setDireito(this.sentinela);
		this.raiz.setEsquerdo(this.sentinela);
		this.raiz.setPai(this.sentinela);
	}
	*/
	public void AdicionarCartao(ArvoreCartoesVP T, NoCartao z){
		NoCartao y = T.sentinela;
		NoCartao x = T.getRaiz();
		while(x != T.sentinela){
			y = x;
			if(z.getChave() < x.getChave()){
				x = x.getEsquerdo();
			}
			else{
				x = x.getDireito();
			}
		}
		z.setPai(y);
		if(y == T.sentinela){
			T.setRaiz(z);
		}
		else if(z.getChave() < y.getChave()){
			y.setEsquerdo(z);
		}
		else{
			y.setDireito(z);
		}
		
		z.setEsquerdo(T.sentinela);
		z.setDireito(T.sentinela);
		z.setCor(Cor.VERMELHO);
		insertFixup(T, z);
		qtdCadastrados++;
	}
	
	
	public void insertFixup(ArvoreCartoesVP T, NoCartao z){
		NoCartao y;
		while(z.getPai().getCor() == Cor.VERMELHO){
			if(z.getPai() == z.getPai().getPai().getEsquerdo()){
				y = z.getPai().getPai().getDireito(); 
				if(y.getCor() == Cor.VERMELHO){
					z.getPai().setCor(Cor.PRETO);
					y.setCor(Cor.PRETO);
					z.getPai().getPai().setCor(Cor.VERMELHO);
					z = z.getPai().getPai();
				}
				else{
					if(z == z.getPai().getDireito()){
						z = z.getPai();
						leftRotate(T,z);
					}
					z.getPai().setCor(Cor.PRETO);
					z.getPai().getPai().setCor(Cor.VERMELHO);
					rightRotate(T, z.getPai().getPai());
					
				}
			}
			else{
				y = z.getPai().getPai().getEsquerdo(); 
				if(y.getCor() == Cor.VERMELHO){
					z.getPai().setCor(Cor.PRETO);
					y.setCor(Cor.PRETO);
					z.getPai().getPai().setCor(Cor.VERMELHO);
					z = z.getPai().getPai();
				}
				else{
					if(z == z.getPai().getEsquerdo()){
						z = z.getPai();
						rightRotate(T, z);
					}
					z.getPai().setCor(Cor.PRETO);
					z.getPai().getPai().setCor(Cor.VERMELHO);
					leftRotate(T, z.getPai().getPai());
				}
			}
		}
		T.getRaiz().setCor(Cor.PRETO);
	}
	
	public void leftRotate(ArvoreCartoesVP T, NoCartao x){
		NoCartao y = x.getDireito();
		x.setDireito(y.getEsquerdo());
		if(y.getEsquerdo() != T.sentinela){
			y.getEsquerdo().setPai(x);
		}
		y.setPai(x.getPai());
		if(x.getPai() == T.sentinela){
			T.setRaiz(y);
		}
		else if(x == x.getPai().getEsquerdo()){
			x.getPai().setEsquerdo(y);
		}
		else{
			x.getPai().setDireito(y);
		}
		y.setEsquerdo(x);
		x.setPai(y);
	}
	
	public void rightRotate(ArvoreCartoesVP T, NoCartao x){
		NoCartao y = x.getEsquerdo();
		x.setEsquerdo(y.getDireito());
		if(y.getDireito() != T.sentinela){
			y.getDireito().setPai(x);
		}
		y.setPai(x.getPai());
		if(x.getPai() == T.sentinela){
			T.setRaiz(y);
		}
		else if(x == x.getPai().getDireito()){
			x.getPai().setDireito(y);
		}
		else{
			x.getPai().setEsquerdo(y);
		}
		y.setDireito(x);
		x.setPai(y);
	}
	
	
	
	public int Altura(NoCartao x){
		if(x == sentinela){
			return -1;
		}
		int h1 = Altura(x.getEsquerdo());
		int h2 = Altura(x.getDireito());
		return(1 + Math.max(h1, h2));
	}
	
	public void Transplant(ArvoreCartoesVP T, NoCartao u, NoCartao v){
		if(u.getPai() == T.sentinela){
			T.setRaiz(v);
		}
		else if(u == u.getPai().getEsquerdo()){
			u.getPai().setEsquerdo(v);
		}
		else{
			u.getPai().setDireito(v);
		}
		v.setPai(u.getPai());
	}
	
	public void Delete(ArvoreCartoesVP T, NoCartao z){
		NoCartao y = z;
		NoCartao x;
		Cor corOriginalDeY = y.getCor();
		if(z.getEsquerdo() == T.sentinela){
			x = z.getDireito();
			Transplant(T, z, z.getDireito());
		}
		else if(z.getDireito() == T.sentinela){
			x = z.getEsquerdo();
			Transplant(T, z, z.getEsquerdo());
		}
		else{
			y = valorMinimo(z.getDireito());
			corOriginalDeY = y.getCor();
			x = y.getDireito();
			if(y.getPai() == z){
				x.setPai(y);
			}
			else{
				Transplant(T, y, y.getDireito());
				y.setDireito(z.getDireito());
				y.getDireito().setPai(y);
			}
			Transplant(T, z, y);
			y.setEsquerdo(z.getEsquerdo());
			y.getEsquerdo().setPai(y);
			y.setCor(z.getCor());
		}
		if(corOriginalDeY == Cor.PRETO){
			deleteFixup(T,x);
		}
		qtdCadastrados -= 1;
	}
	
	public void deleteFixup(ArvoreCartoesVP T, NoCartao x){
		NoCartao w;
		while(x != T.getRaiz() && x.getCor() == Cor.PRETO){
			if(x == x.getPai().getEsquerdo()){
				w = x.getPai().getDireito();
				if(w.getCor() == Cor.VERMELHO){
					w.setCor(Cor.PRETO);
					x.getPai().setCor(Cor.VERMELHO);
					leftRotate(T, x.getPai());
					w = x.getPai().getDireito();
				}
				if(w.getEsquerdo().getCor() == Cor.PRETO && w.getDireito().getCor() == Cor.PRETO){
					w.setCor(Cor.VERMELHO);
					x = x.getPai();
				}else{
					if(w.getDireito().getCor() == Cor.PRETO){
						w.getEsquerdo().setCor(Cor.PRETO);
						w.setCor(Cor.PRETO);
						rightRotate(T, w);
						w = x.getPai().getDireito();
					}
					w.setCor(x.getPai().getCor());
					x.getPai().setCor(Cor.PRETO);
					w.getDireito().setCor(Cor.PRETO);
					leftRotate(T, x.getPai());
					x = this.getRaiz();
				}
			}else{
				w = x.getPai().getEsquerdo();
				if(w.getCor() == Cor.VERMELHO){
					w.setCor(Cor.PRETO);
					x.getPai().setCor(Cor.VERMELHO);
					rightRotate(T, x.getPai());
					w = x.getPai().getEsquerdo();
				}
				if(w.getDireito().getCor() == Cor.PRETO && w.getEsquerdo().getCor() == Cor.PRETO){
					w.setCor(Cor.VERMELHO);
					x = x.getPai();
				}else{
					if(w.getEsquerdo().getCor() == Cor.PRETO){
						w.getDireito().setCor(Cor.PRETO);
						w.setCor(Cor.PRETO);
						leftRotate(T, w);
						w = x.getPai().getEsquerdo();
					}
					w.setCor(x.getPai().getCor());
					x.getPai().setCor(Cor.PRETO);
					w.getEsquerdo().setCor(Cor.PRETO);
					rightRotate(T, x.getPai());
					x = this.getRaiz();
				}
			}
		}
		x.setCor(Cor.PRETO);
	}
	
	public NoCartao Procurar(NoCartao x, long k){
		if(x == null || k == x.getChave()){
			return x;
		}
		if(k < x.getChave()){
			return this.Procurar(x.getEsquerdo(), k);
		}
		else{
			return this.Procurar(x.getDireito(), k);
		}
	}
	
	public void inorderTreeWalk(NoCartao raiz){
		if(raiz != sentinela){
			inorderTreeWalk(raiz.getEsquerdo());
			cartoes.add(raiz.getDados());
			inorderTreeWalk(raiz.getDireito());
		}
	}
	
	public void inorderTreeWalkNormal(NoCartao raiz){
		if(raiz != sentinela){
			inorderTreeWalkNormal(raiz.getEsquerdo());
			System.out.println(raiz);
			System.out.println("\n\nPai:\n\n"+raiz.getPai());
			inorderTreeWalkNormal(raiz.getDireito());
		}
	}
	
	public void listarMontantes(){

		for(int i = 0; i < cartoes.size(); i++){
			for(int j = cartoes.size() - 1; j > 0; j-- ){
				if(cartoes.get(j).getLimiteTotal() > cartoes.get(j-1).getLimiteTotal()){
					Cartao aux = cartoes.get(j);
					cartoes.set(j, cartoes.get(j - 1));
					cartoes.set(j-1, aux);
				}
			}
		}
		System.out.println(cartoes);
		cartoes.removeAll(cartoes);
	}
	
	public NoCartao valorMinimo(NoCartao aux){
		while(aux.getEsquerdo() != sentinela){
			aux = aux.getEsquerdo();
		}
		return aux;
	}
	
	public NoCartao valorMaximo(NoCartao aux){
		while(aux.getDireito() != sentinela){
			aux = aux.getDireito();
		}
		return aux;
	}
	
	public NoCartao Sucessor(NoCartao ant){
		NoCartao retorno = sentinela;
		if(ant.getDireito() != sentinela){
			retorno = valorMinimo(ant.getDireito());
		}
		else{
			retorno = ant.getPai();
			while(retorno != sentinela && ant.equals(retorno.getDireito())){
				ant = retorno;
				retorno = retorno.getPai();
			}
		}
		return retorno;
	}
	
	public NoCartao Predecessor(NoCartao suc){
		NoCartao retorno = sentinela;
		if(suc.getEsquerdo() != sentinela){
			retorno = valorMaximo(suc.getEsquerdo());
		}
		else{
			retorno = suc.getPai();
			while(retorno != sentinela && suc.equals(retorno.getEsquerdo())){
				suc = retorno;
				retorno = retorno.getPai();
			}
		}
		return retorno;
	}

	public static int getQtdCadastrados() {
		return qtdCadastrados;
	}

	public static void setQtdCadastrados(int qtdCadastrados) {
		ArvoreCartoesVP.qtdCadastrados = qtdCadastrados;
	}

	public NoCartao getRaiz() {
		return raiz;
	}

	public void setRaiz(NoCartao raiz) {
		this.raiz = raiz;
	}

	public NoCartao getSentinela() {
		return sentinela;
	}

	public void setSentinela(NoCartao sentinela) {
		this.sentinela = sentinela;
	}
	
	
	
}
