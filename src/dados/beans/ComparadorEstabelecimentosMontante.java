package dados.beans;

import java.util.Comparator;

public class ComparadorEstabelecimentosMontante implements
	Comparator<Estabelecimento>{

	public int compare(Estabelecimento e1, Estabelecimento e2){
		return (int) Double.compare(e1.getMontante(), e2.getMontante());
	}
}
