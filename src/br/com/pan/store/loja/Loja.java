package br.com.pan.store.loja;

import br.com.pan.store.dados.Database;

import java.util.Scanner;

public class Loja {

	public static void main(String[] args) {

//		Database.popularProdutos();
//		Database.listarProdutos();
//
//		Database.popularFormasDePagamento();
//		Database.listarFormasDePagamento();
//
//		Database.baixarProdutoEstoque(1, 10);
//
//		Database.listarProdutos();

		Database.popularProdutos();
		Database.popularFormasDePagamento();

		Scanner sc = new Scanner(System.in);

		int opcao = 0;

		while (true) {

			Database.listarProdutos();

			System.out.println("Escolha um produto ");
			opcao = sc.nextInt();

			if (opcao == 0){
				break;
			}

		}


	}
}
