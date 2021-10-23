package br.com.pan.store.entidades;

import br.com.pan.store.dados.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Carrinho {
    private Integer id;
    private String nomeCliente;
    private FormaDePagamento formaPagamento;
    private Integer notaFiscal;
    private ArrayList<CarrinhoItem> itens = new ArrayList<CarrinhoItem>();

    public Carrinho(Integer id, String nomeCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
    }
    
    public ArrayList<CarrinhoItem> getItens() {
		return itens;
	}

	public void adicionarItem(CarrinhoItem carrinhoItem){
        this.itens.add(carrinhoItem);
    }

    public boolean adicionarItem(Produto produto, Integer quantidade) {
        CarrinhoItem item = new CarrinhoItem(produto,quantidade,produto.getPreco());
        if(produto.reduzirQuantidade(quantidade)) {
            System.out.printf("\n%d %s ADICIONADO(S) AO CARRINHO\n", quantidade, produto.getNome());
            adicionarItem(item);
            return true;
        } else return false;
    }

    public void gerarCupomFiscal(FormaDePagamento formaDePagamento){
        this.formaPagamento = formaDePagamento;

        this.notaFiscal = Database.getVendasRealizadas().size()+1;

        Database.getVendasRealizadas().add(this);
        Double totalDaCompra = 0.0;
        Double totalComDesconto = formaDePagamento.calculaValor(this);
        System.out.println("\n=========================================================================");
        System.out.println("                              CUPOM FISCAL");
        System.out.println("=========================================================================");
        System.out.format("%-37s%-12s%-15s%-15s\n", "PRODUTO", "QUANT", "PRECO", "TOTAL");
        for (CarrinhoItem item:itens) {
            System.out.format("%-37s%-12d%-15.2f%-15.2f\n", item.getProduto().getNome().toUpperCase(), item.getQuantidade(), item.getPrecoVendido(), item.getQuantidade() * item.getPrecoVendido());
            totalDaCompra += item.getQuantidade() * item.getPrecoVendido();
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("TOTAL: %.2f\n", totalDaCompra);
        System.out.printf("TOTAL COM DESCONTO: %.2f\n", totalComDesconto);
        System.out.println("=========================================================================");
        System.out.printf("CLIENTE: %s\n", this.nomeCliente);
        System.out.printf("FATURA: %d            FORMA DE PAGAMENTO: %s\n", this.notaFiscal, formaDePagamento.getNome());
        System.out.println("=========================================================================\n");

    }
}
