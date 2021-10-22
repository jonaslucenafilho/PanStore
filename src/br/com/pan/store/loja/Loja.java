package br.com.pan.store.loja;

import br.com.pan.store.dados.Database;

public class Loja {

	public static void main(String[] args) {
		
		Database.popularProdutos();		
		Database.listarProdutos();
		
		Database.popularFormasDePagamento();
		Database.listarFormasDePagamento();
		
		Database.baixarProdutoEstoque(1, 10);
		
		Database.listarProdutos();
	}
}
