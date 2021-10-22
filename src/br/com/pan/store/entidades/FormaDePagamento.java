package br.com.pan.store.entidades;

public abstract class FormaDePagamento {

    private Integer id;
    private String nome;
    private Integer nParcelas;
    private Double taxaJuros;

    public Double calculaValor() {
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getnParcelas() {
        return nParcelas;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

}
