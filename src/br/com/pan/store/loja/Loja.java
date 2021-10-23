package br.com.pan.store.loja;

import java.util.Scanner;

import br.com.pan.store.dados.Database;
import br.com.pan.store.entidades.Carrinho;
import br.com.pan.store.entidades.FormaDePagamento;

public class Loja {

    public static void main(String[] args) {

        Database.popularProdutos();
        Database.popularFormasDePagamento();

        Scanner sc = new Scanner(System.in);

        String opcao = "";

        Carrinho carrinho = null;

        Integer sequencia = 0;
        
        System.out.println("========================== BEM VINDO A PANSTORE =============================\n");

        while (true) {

            Database.listarProdutos();

            System.out.println("======================== ESCOLHA O PRODUTO PELO CÓDIGO ======================\n"
            		+ "========================= F PARA FINALIZAR O CARRINHO =======================\n"
            		+ "============================= 0 PARA SAIR DA LOJA ===========================\n");
            
            System.out.print("DIGITE A SUA OPÇÃO: ");
            
            opcao = sc.next();

            if (opcao.equals("0")) {
            	System.out.println("\n======================= OBRIGADO POR USAR A NOSSA LOJA ======================");
                break;
            } else if (!opcao.toUpperCase().equals("F")) {

                if (carrinho == null) {
                	System.out.print("DIGITE O NOME DO CLIENTE: ");
                    String nomeCliente = sc.next();
                    sequencia++;
                    carrinho = new Carrinho(sequencia, nomeCliente);
                    nomeCliente = sc.nextLine();
                }

                System.out.print("DIGITE A QUANTIDADE: ");
                Integer qtd = sc.nextInt();

                if (!carrinho.adicionarItem(Database.getProdutos().get(Integer.valueOf(opcao)), qtd)) {
                    System.out.println("\nNÃO HÁ QUANTIDADE SUFICIENTE PARA O ITEM SELECIONADO\n");
                }

            } else if (opcao.toUpperCase().equals("F")) {

                Database.listarFormasDePagamento();
                System.out.print("ESCOLHA UMA FORMA DE PAGAMENTO: ");

                Integer codigoForma = sc.nextInt();

                FormaDePagamento forma = Database.getFormasDePagamento().get(codigoForma);

                carrinho.gerarCupomFiscal(forma);

                carrinho = null;

            } else {
                System.out.println("OPÇÃO INVÁLIDA");
            }
        }
    }
}
