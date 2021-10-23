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
        System.out.println("=========================================================================");
        System.out.println("                              CUPOM FISCAL");
        System.out.println("=========================================================================");
        System.out.format("%-37s%-12s%-15s%-15s\n", "PRODUTO", "QUANT", "PRECO", "TOTAL");
        for (CarrinhoItem item:itens) {
            System.out.format("%-37s%-12d%-15.2f%-15.2f\n", item.getProduto().getNome(), item.getQuantidade(), item.getPrecoVendido(), item.getQuantidade() * item.getPrecoVendido());
            totalDaCompra += item.getQuantidade() * item.getPrecoVendido();
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("TOTAL: %.2f\n", totalDaCompra);
        System.out.printf("TOTAL COM DESCONTO: %.2f\n", totalComDesconto);
        System.out.println("=========================================================================");
        System.out.printf("Cliente: %s\n", this.nomeCliente);
        System.out.printf("Fatura: %d               Forma Pagamento: %s\n", this.notaFiscal, formaDePagamento.getNome());
        System.out.println("=========================================================================\n");

    }
    
	public void listarProdutosCarrinho() {
		System.out.println("=============================================================================");
		System.out.println("| C�DIGO \t NOME \t\t QUANTIDADE \t PRE�O \t\t  MARCA     |");
		
		for(CarrinhoItem item : itens) {
			System.out.printf("|   %d \t     %s \t     %s \t       R$%.2f \t %s  |\n", 
					item.getProduto().getId(),
					item.getProduto().getNome(),
					item.getProduto().getQuantidade(),
					item.getProduto().getPreco(),
					item.getProduto().getMarca());
		}
		
		System.out.println("=============================================================================\n");
	}
}
