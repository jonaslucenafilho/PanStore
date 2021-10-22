package br.com.pan.store.loja;

import br.com.pan.store.dados.Database;

public class Loja {

	public static void main(String[] args) {
		
		Database.popularProdutos();		
		Database.listarProdutos();
	}
}
