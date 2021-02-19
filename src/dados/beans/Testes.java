package dados.beans;

import dados.ArvoreCartoesVP;
import dados.ArvoreEstabelecimentosVP;
import java.util.Scanner;

public class Testes {
	private static int geradorCodigoLojas = 0;
	private static int geradorCodigoCartao = 0;
	
	public static void main(String[] args) {
		int cond = 1, op;
		Scanner entrada = new Scanner(System.in);
		
		Cartao c1 = new Cartao(1, "MasterCard Maestro", "Douglas Dias da Silva", 500, 400);
		Cartao c2 = new Cartao(2, "Visa", "Bruna Raíssa Santos Ferreira", 1000, 648);
		Cartao c3 = new Cartao(3, "MasterCard", "Linus Torvalds", 6000, 3500);
		Cartao c4 = new Cartao(4, "Visa", "Silvio Santos", 1000000, 50000);
		Cartao c5 = new Cartao(5, "MGS", "Hideo Kojima", 10000, 7000);
		
		ArvoreCartoesVP cartree = new ArvoreCartoesVP();
		
		NoCartao nc1 = new NoCartao(c1);
		geradorCodigoCartao++;
		nc1.setChave(geradorCodigoCartao);
		nc1.ajustarNoCartao(cartree, nc1);
		
		NoCartao nc2 = new NoCartao(c2);
		geradorCodigoCartao++;
		nc2.setChave(geradorCodigoCartao);
		nc2.ajustarNoCartao(cartree, nc2);
		
		NoCartao nc3 = new NoCartao(c3);
		geradorCodigoCartao++;
		nc3.setChave(geradorCodigoCartao);
		nc3.ajustarNoCartao(cartree, nc3);
	
		NoCartao nc4 = new NoCartao(c4);
		geradorCodigoCartao++;
		nc4.setChave(geradorCodigoCartao);
		nc4.ajustarNoCartao(cartree, nc4);
		
		NoCartao nc5 = new NoCartao(c5);
		geradorCodigoCartao++;
		nc5.setChave(geradorCodigoCartao);
		nc5.ajustarNoCartao(cartree, nc5);
		
		
		cartree.AdicionarCartao(cartree, nc1);
		cartree.AdicionarCartao(cartree, nc2);
		cartree.AdicionarCartao(cartree,nc3);
		cartree.AdicionarCartao(cartree,nc4);
		cartree.AdicionarCartao(cartree,nc5);
		
		
		ArvoreEstabelecimentosVP estabtree = new ArvoreEstabelecimentosVP();
		
		
		Estabelecimento e1 = new Estabelecimento("Livraria Cultura", "Rua Nova Esperança, 5", 12, 22, 0, 0);
		NoEstabelecimento ne1 = new NoEstabelecimento(e1);
		ne1.prepararNoEstabelecimento(estabtree, ne1);
		geradorCodigoLojas++;
		ne1.setChave(geradorCodigoLojas);
		
		Estabelecimento e2 = new Estabelecimento("Supermercado Todo Dia", "PE-05, No 2000", 7, 22, 0, 0);
		NoEstabelecimento ne2 = new NoEstabelecimento(e2);
		ne2.prepararNoEstabelecimento(estabtree, ne2);
		geradorCodigoLojas++;
		ne2.setChave(geradorCodigoLojas);
		
		Estabelecimento e3 = new Estabelecimento("Lojas Americanas", "Av Dr Francisco Corrêa, No 650", 8, 20, 0, 0);
		NoEstabelecimento ne3 = new NoEstabelecimento(e3);
		ne3.prepararNoEstabelecimento(estabtree, ne3);
		geradorCodigoLojas++;
		ne3.setChave(geradorCodigoLojas);
		
		Estabelecimento e4 = new Estabelecimento("Atacadão", "Av Belmiro Correa, No 210", 8, 20, 0, 0);
		NoEstabelecimento ne4 = new NoEstabelecimento(e4);
		ne4.prepararNoEstabelecimento(estabtree, ne4);
		geradorCodigoLojas++;
		ne4.setChave(geradorCodigoLojas);
		
		
		estabtree.AdicionarEstabelecimento(estabtree,ne1);
		estabtree.AdicionarEstabelecimento(estabtree,ne2);
		estabtree.AdicionarEstabelecimento(estabtree,ne3);
		estabtree.AdicionarEstabelecimento(estabtree,ne4);
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		while(cond == 1){
			System.out.println("*********************************\n"
					+ "*\tMAQUINETAS TIERRA\t*\n*********************************");
			System.out.println("-> INDIQUE A OPERAÇÃO:\n\t"
					+ "1 - CADASTRAR CARTÃO\n\t"
					+ "2 - CADASTRAR ESTABELECIMENTO\n\t"
					+ "3 - CONSULTAR CONDIÇÕES DE COMPRA\n\t"
					+ "4 - RELATÓRIO DE ESTABELECIMENTOS\n\t"
					+ "5 - RELATÓRIO DE CLIENTES\n\t"
					+ "6 - PROCURAR CLIENTE\n\t"
					+ "7 - PROCURAR ESTABELECIMENTO\n\t"
					+ "8 - REMOVER ESTABELECIMENTO\n\t"
					+ "9 - REMOVER CLIENTE\n\t"
					+ "10 - SAIR\n\tOPÇÃO: ");
			op = entrada.nextInt();
			switch(op){
			case 1:
				entrada.nextLine();
				System.out.println("Insira o nome do cliente: ");
				String nome = entrada.nextLine();
				System.out.println("Numero do cartão será gerado. ");
				geradorCodigoCartao++;
				long numero = geradorCodigoCartao;
				System.out.println("Numero do cartão gerado: " + geradorCodigoCartao);
				entrada.nextLine();
				System.out.println("Insira a bandeira do cartão: ");
				String bandeira = entrada.nextLine();
				entrada.nextLine();
				System.out.println("Insira o limite do cartão: ");
				double limite = entrada.nextDouble();
				System.out.println("Insira o saldo disponível: ");
				double disponivel = entrada.nextDouble();
				
				Cartao c = new Cartao(numero, bandeira, nome, limite, disponivel);
				NoCartao nc = new NoCartao(c);
				nc.setChave(geradorCodigoCartao);
				nc.ajustarNoCartao(cartree, nc);
				
				cartree.AdicionarCartao(cartree, nc);
				
				break;
			case 2:
				entrada.nextLine();
				System.out.println("Insira o nome do estabelecimento: ");
				String nomeEstab = entrada.nextLine();
				System.out.println("Insira o endereço do estabelecimento: ");
				String endereco = entrada.nextLine();
				entrada.nextLine();
				System.out.println("Insira a hora de abertura do estabelecimento (0 - 23): ");
				int abre = entrada.nextInt();
				System.out.println("Insira a hora de fechamento do estabelecimento (0 - 23): ");
				int fecha = entrada.nextInt();
				Estabelecimento e = new Estabelecimento(nomeEstab, endereco, abre, fecha, 0, 0);
				NoEstabelecimento ne = new NoEstabelecimento(e);
				ne.prepararNoEstabelecimento(estabtree, ne);
				geradorCodigoLojas++;
				ne.setChave(geradorCodigoLojas);
				
				estabtree.AdicionarEstabelecimento(estabtree, ne);
				
				break;
			case 3:
				System.out.println("Informe o código da loja: ");
				int codLoj = entrada.nextInt();
				NoEstabelecimento estCheck = null;
				try{
					estCheck = estabtree.Procurar(estabtree.getRaiz(), codLoj);
				}catch(java.lang.StackOverflowError ste){
					System.out.println("Loja não cadastrada. Em caso de erro, volte ao menu apertando enter: ");
					entrada.nextLine();
					entrada.nextLine();
					break;
				}
				System.out.println(estCheck.getDados());
				System.out.println("\n\nPra fins didádicos, a hora será informada pelo usuário.\n\nInforme a hora:");
				int hora = entrada.nextInt();
				if(estCheck.getDados().getHorario().getHoraInicio() > hora || estCheck.getDados().getHorario().getHoraFim() < hora){
					System.out.println("Compra não pode ser efetuada fora do horário de funcionamento.");
					System.out.println("Pressione enter para voltar ao menu principal...");
					entrada.nextLine();
					entrada.nextLine();
					break;
				}
				System.out.println("Insira o número do cartão de crédito: ");
				long cartNum = entrada.nextLong();
				NoCartao cartCheck = null;
				try{
					cartCheck = cartree.Procurar(cartree.getRaiz(), cartNum);
				}catch(java.lang.StackOverflowError soe){
					System.out.println("Cartão não cadastrado. Em caso de erro, volte ao menu apertando enter: ");
					entrada.nextLine();
					entrada.nextLine();
					break;
				}
				System.out.println(cartCheck.getDados());
				System.out.println("Digite o valor da compra: ");
				double compra = entrada.nextDouble();
				if(cartCheck.getDados().getLimiteDisponivel() > 0){
					if(compra > cartCheck.getDados().getLimiteDisponivel()){
						System.out.println("O cliente não possui limite suficiente para a compra.");
						System.out.println("Pressione enter para voltar ao menu principal...");
						entrada.nextLine();
						entrada.nextLine();
						break;
					}
					else{
						cartCheck.getDados().setLimiteDisponivel(cartCheck.getDados().getLimiteDisponivel() - compra);
						System.out.println("Insira o número de parcelas: ");
						double parcelas = entrada.nextDouble();
						estCheck.getDados().setMontante(estCheck.getDados().getMontante() + compra);
						estCheck.getDados().setValorASerPago(compra/parcelas);
						System.out.println("____________________________________\n\tCompra efetuada com sucesso!\n____________________________________\n\n");
						System.out.println("Atualização da Loja: ");
						System.out.println(estCheck.getDados());
						entrada.nextLine();
						entrada.nextLine();
						System.out.println("\n\nAtualização do Cliente: ");
						System.out.println(cartCheck.getDados());
						System.out.println("\n\nPressione enter para continuar...");
						entrada.nextLine();
					}
				}
				break;
			case 4:
				estabtree.inorderTreeWalk(estabtree.getRaiz());
				estabtree.listarMontantes();
				System.out.println("\n\nPressione qualquer tecla para continuar...");
				entrada.nextLine();
				entrada.nextLine();
				break;
			case 5:
				cartree.inorderTreeWalk(cartree.getRaiz());
				cartree.listarMontantes();
				System.out.println("\n\nPressione qualquer tecla para continuar...");
				entrada.nextLine();
				entrada.nextLine();
				break;
			case 6:
				System.out.println("Insira o número do cartão: ");
				int num = entrada.nextInt();
				try{
					System.out.println(cartree.Procurar(cartree.getRaiz(), num));
				}catch(java.lang.StackOverflowError soe){
					System.out.println("Cartão não existe.");
				}
				System.out.println("\n\nPressione qualquer tecla para continuar...");
				entrada.nextLine();
				entrada.nextLine();
				break;
			case 7:
				System.out.println("Insira o código do estabelecimento: ");
				long cod = entrada.nextLong();
				try{
					System.out.println(estabtree.Procurar(estabtree.getRaiz(), cod));
				}
				catch(java.lang.StackOverflowError soe){
					System.out.println("Estabelecimento não existe ou não cadastrado.");
				}
				System.out.println("\n\nPressione qualquer tecla para continuar...");
				entrada.nextLine();
				entrada.nextLine();
				break;
			case 8:
				System.out.println("Insira o código do estabelecimento: ");
				long codEstab = entrada.nextLong();
				NoEstabelecimento del = null;
				try{
					del = estabtree.Procurar(estabtree.getRaiz(), codEstab);
				}catch(java.lang.StackOverflowError soe){
					System.out.println("Estabelecimento não existe ou não está cadastrado.");
				}
				if(del != null){
					estabtree.Delete(estabtree, del);
					System.out.println("Estabelecimento removido com sucesso.");
					entrada.nextLine();
					entrada.nextLine();
				}
				break;
			case 9:
				System.out.println("Insira o número do cartão: ");
				long codCart = entrada.nextLong();
				NoCartao delCart = null;
				try{
					delCart = cartree.Procurar(cartree.getRaiz(), codCart);
				}catch(java.lang.StackOverflowError soe){
					System.out.println("Estabelecimento não existe ou não está cadastrado.");
				}
				if(delCart != null){
					cartree.Delete(cartree, delCart);
					System.out.println("Usuario removido com sucesso.");
					entrada.nextLine();
					entrada.nextLine();
				}
				break;
			case 10:
				int exit;
				System.out.println("Deseja encerrar a aplicação?\n1 para sim, 2 para não: ");
				exit = entrada.nextInt();
				if(exit == 1){
					cond = 0;
				}
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
			}
				
			
		}
		
		/*
		System.out.println(nc1.getPai());
		System.out.println(nc2.getPai());
		System.out.println(nc3.getPai());
		System.out.println(nc4.getPai());
		System.out.println(nc5.getPai());
		*/
		
		//System.out.println(cartree.getRaiz());
		cartree.inorderTreeWalkNormal(cartree.getRaiz());
		entrada.close();
		
	}

}
