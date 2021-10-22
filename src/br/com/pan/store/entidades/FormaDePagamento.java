package br.com.pan.store.entidades;

public class FormaDePagamento {
	
	private Integer id;
    private String nome;
    private Integer nParcelas;
    private Double taxaJuros;
    public Double calculaValor;

    public Double calculaValor() {
		return null;
	}
    
    //public Double getCalculaValor() {
    //    return calculaValor;
    //}

    public Integer getId(int i) {
        return id;
    }

    public String getNome(String string) {
        return nome;
    }

    public Integer getnParcelas() {
        return nParcelas;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

	
   
	//public Double calculaValor() {
	//	return null;
	//}
}
