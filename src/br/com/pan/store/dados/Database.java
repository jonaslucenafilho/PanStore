package br.com.pan.store.dados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.pan.store.entidades.FormaDePagamento;
import br.com.pan.store.entidades.Produto;

public class Database {
	
	private static Map<Integer, Produto> produtos = new HashMap<Integer, Produto>();
	private static Map<Integer, FormaDePagamento> formasDePagamento;
	
	public static Map<Integer, Produto> getProdutos() {
		return produtos;
	}

	public static Map<Integer, FormaDePagamento> getFormasDePagamento() {
		return formasDePagamento;
	}

	public static void popularProdutos() {
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		listaProdutos.add(new Produto(1, "Smart TV 55''", 5, 2999.90, "Samsung  ")) ;
		listaProdutos.add(new Produto(2, "Playstation 5", 3, 3599.90, "Sony     "));
		listaProdutos.add(new Produto(3, "Xbox Series X", 4, 3699.00, "Microsoft"));
		listaProdutos.add(new Produto(4, "Notebook Gamer", 2, 5999.90, "Lenovo   "));
		listaProdutos.add(new Produto(5, "Cadeira Gamer", 8, 999.95, "Husky    "));
		listaProdutos.add(new Produto(6, "Soundbar SN4", 7, 899.90, "LG       "));
		listaProdutos.add(new Produto(7, "ASTRO A40 TR", 5, 1300.00, "Logitech "));
		listaProdutos.add(new Produto(8, "Teclado MX Keys", 8, 609.90, "Logitech "));
		listaProdutos.add(new Produto(9, "Mouse MX Master", 6, 485.00, "Logitech "));
		listaProdutos.add(new Produto(10, "Echo Dot 4ª ", 4, 700.00, "Amazon   "));
		
		for (Produto i : listaProdutos) {
			getProdutos().put(i.getId(), i);
		}	
	}
	
	public static void listarProdutos() {
		System.out.println("=============================================================================");
		System.out.println("| CÓDIGO \t NOME \t\t QUANTIDADE \t PREÇO \t\t  MARCA     |");
		
		for(int i = 1; i <= Database.getProdutos().size(); i++) {
			System.out.printf("|   %d \t     %s \t     %s \t       R$%.2f \t %s  |\n", 
					Database.getProdutos().get(i).getId(),
					Database.getProdutos().get(i).getNome(),
					Database.getProdutos().get(i).getQuantidade(),
					Database.getProdutos().get(i).getPreco(),
					Database.getProdutos().get(i).getMarca());
		}
		
		System.out.println("=============================================================================");
	}
	
//	public static void popularFormasDePagamento() {
//		ArrayList<FormaDePagamento> listaFormasDePagamento = new ArrayList<FormaDePagamento>();
//		
//		listaFormasPagamento.add(new FormaDePagamento(1, "Smart TV 55''", 5, 2999.90, "Samsung  ")) ;
//		listaFormasPagamento.add(new FormaDePagamento(2, "Playstation 5", 3, 3599.90, "Sony     "));
//		listaFormasPagamento.add(new FormaDePagamento(3, "Xbox Series X", 4, 3699.00, "Microsoft"));
//		listaFormasPagamento.add(new FormaDePagamento(4, "Notebook Gamer", 2, 5999.90, "Lenovo   "));
//
//		
//		for (FormaDePagamento i : listaFormasDePagamento) {
//			getFormasDePagamento().put(i.getId(), i);
//		}	
//	}
//	
//	public static void listarFormasDePagamento() {
//		System.out.println("=============================================================================");
//		System.out.println("| CÓDIGO \t NOME \t\t QUANTIDADE \t PREÇO \t\t MARCA      |");
//		
//		for(int i = 1; i <= Database.getProdutos().size(); i++) {
//			System.out.printf("|   %d \t     %s \t     %s \t       R$%.2f \t %s  |\n", 
//					Database.getFormasDePagamento().get(i).getId(),
//					Database.getFormasDePagamento().get(i).getNome(),
//					Database.getFormasDePagamento().get(i).getQuantidade(),
//					Database.getFormasDePagamento().get(i).getPreco(),
//					Database.getFormasDePagamento().get(i).getMarca());
//		}
//		
//		System.out.println("=============================================================================");
//	}
}
