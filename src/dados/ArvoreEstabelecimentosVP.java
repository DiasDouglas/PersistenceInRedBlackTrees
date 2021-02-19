package dados;


import java.util.ArrayList;

import dados.beans.Cor;
import dados.beans.Estabelecimento;
import dados.beans.NoEstabelecimento;

public class ArvoreEstabelecimentosVP{
	private NoEstabelecimento raiz;
	private NoEstabelecimento sentinela;
	public ArrayList <Estabelecimento> estabelecimentos;
	
	public ArvoreEstabelecimentosVP(){
		this.sentinela = new NoEstabelecimento();
		this.sentinela.setDireito(sentinela);
		this.sentinela.setEsquerdo(sentinela);
		this.sentinela.setPai(sentinela);
		this.sentinela.setCor(Cor.PRETO);
		this.raiz = sentinela;
		this.estabelecimentos = new ArrayList<>();
	}
	
	/*public ArvoreEstabelecimentosVP(NoEstabelecimento raiz){
		this.raiz = raiz;
		this.sentinela = new NoEstabelecimento();
		this.sentinela.ajustarNoEstabelecimento(sentinela);
		this.sentinela.setCor(Cor.PRETO);
		this.raiz.setDireito(sentinela);
		this.raiz.setEsquerdo(sentinela);
		this.raiz.setPai(sentinela);
	}
	*/
	
	public void AdicionarEstabelecimento(ArvoreEstabelecimentosVP T, NoEstabelecimento z){
		NoEstabelecimento y = T.sentinela;
		NoEstabelecimento x = T.getRaiz();																
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
		this.insertFixup(T,z);
		
	}
	
	public void insertFixup(ArvoreEstabelecimentosVP T, NoEstabelecimento z){
		NoEstabelecimento y;
		while(z.getPai().getCor() == Cor.VERMELHO){
			if(/*z.getPai().getPai() != null && */z.getPai() == z.getPai().getPai().getEsquerdo()){
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
						leftRotate(T, z);
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
		this.getRaiz().setCor(Cor.PRETO);
	}
	
	public void leftRotate(ArvoreEstabelecimentosVP T, NoEstabelecimento x){
		NoEstabelecimento y = x.getDireito();
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
	
	public void rightRotate(ArvoreEstabelecimentosVP T, NoEstabelecimento x){
		NoEstabelecimento y = x.getEsquerdo();
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
	
	public int Altura(NoEstabelecimento x){
		if(x == null){
			return -1;
		}
		int h1 = Altura(x.getEsquerdo());
		int h2 = Altura(x.getDireito());
		return(1 + Math.max(h1, h2));
	}
	
	public void Transplant(ArvoreEstabelecimentosVP T,NoEstabelecimento u, NoEstabelecimento v){
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
	
	public void Delete(ArvoreEstabelecimentosVP T,NoEstabelecimento z){
		NoEstabelecimento y = z;
		NoEstabelecimento x;
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
			deleteFixup(T, x);
		}
	}
	
	public void deleteFixup(ArvoreEstabelecimentosVP T, NoEstabelecimento x){
		NoEstabelecimento w;
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
					x = T.getRaiz();
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
					x = T.getRaiz();
				}
			}
		}
		x.setCor(Cor.PRETO);
	}
	
	public NoEstabelecimento Procurar(NoEstabelecimento x, long k){
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
	
	public NoEstabelecimento valorMinimo(NoEstabelecimento aux){
		while(aux.getEsquerdo() != this.sentinela){
			aux = aux.getEsquerdo();
		}
		return aux;
	}
	
	public NoEstabelecimento valorMaximo(NoEstabelecimento aux){
		while(aux.getDireito() != sentinela){
			aux = aux.getDireito();
		}
		return aux;
	}
	
	public NoEstabelecimento Sucessor(NoEstabelecimento ant){
		NoEstabelecimento retorno = sentinela;
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
	
	public void inorderTreeWalk(NoEstabelecimento raiz){
		if(raiz != sentinela){
			inorderTreeWalk(raiz.getEsquerdo());
			estabelecimentos.add(raiz.getDados());
			inorderTreeWalk(raiz.getDireito());
		}
	}
	
	public void listarMontantes(){

		for(int i = 0; i < estabelecimentos.size(); i++){
			for(int j = estabelecimentos.size() - 1; j > 0; j-- ){
				if(estabelecimentos.get(j).getMontante() > estabelecimentos.get(j-1).getMontante()){
					Estabelecimento aux = estabelecimentos.get(j);
					estabelecimentos.set(j, estabelecimentos.get(j - 1));
					estabelecimentos.set(j-1, aux);
				}
			}
		}
		System.out.println(estabelecimentos);
		estabelecimentos.removeAll(estabelecimentos);
	}
	
	public NoEstabelecimento Predecessor(NoEstabelecimento suc){
		NoEstabelecimento retorno = sentinela;
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

	public NoEstabelecimento getRaiz() {
		return raiz;
	}

	public void setRaiz(NoEstabelecimento raiz) {
		this.raiz = raiz;
	}

	public NoEstabelecimento getSentinela() {
		return sentinela;
	}

	public void setSentinela(NoEstabelecimento sentinela) {
		this.sentinela = sentinela;
	}
	
	
}
