package br.com.pan.store.loja;

import br.com.pan.store.dados.Database;
import br.com.pan.store.entidades.Carrinho;
import br.com.pan.store.entidades.FormaDePagamento;

import javax.xml.crypto.Data;
import java.util.Locale;
import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {

        Database.popularProdutos();
        Database.popularFormasDePagamento();

        Scanner sc = new Scanner(System.in);

        String opcao = "";

        Carrinho carrinho = null;

        Integer sequencia = 0;

        while (true) {

            Database.listarProdutos();

            showMenu();

            opcao = sc.next();

            if (opcao.equals("0")) {
                break;
            } else if (!opcao.toUpperCase().equals("F")) {

                if (carrinho == null) {
                    String nomeCliente = sc.next();
                    sequencia++;
                    carrinho = new Carrinho(sequencia, nomeCliente);

                }

                System.out.println("Digite a quantidade");
                Integer qtd = sc.nextInt();

                if (!carrinho.adicionarItem(Database.getProdutos().get(Integer.valueOf(opcao)), qtd)) {
                    System.out.println("Nao ha quantidade suficiente para o item selecionado");
                }

            } else if (opcao.equals("F")) {

                Database.listarFormasDePagamento();
                System.out.println("Escolha uma forma de pagamento");

                Integer codigoForma = sc.nextInt();

                FormaDePagamento forma = Database.getFormasDePagamento().get(codigoForma);

                carrinho.gerarCupomFiscal(forma);

                carrinho = null;

            } else {
                System.out.println("Opcao invalida");
            }

        }


    }


    private static void showMenu() {
        System.out.println("Escolha o produto ou F para finalizar o carrinho e 0 para sair da loja");
    }
}
