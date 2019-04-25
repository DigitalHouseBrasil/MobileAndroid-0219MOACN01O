package br.com.digitalhouse;

import java.util.List;

public class Colecao {
    private List<Livro> livros;
    private int codigo;
    private double preco;
    private String descricao;

    public Colecao() {
    }

    public Colecao(int codigo, String descricao, double preco, List<Livro> livros) {
        this.codigo = codigo;
        this.preco = preco;
        this.descricao = descricao;
        this.livros = livros;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Códifo coleção: " + this.codigo +
                " \n Preço: " + this.preco +
                " \n Descrição: " + this.descricao +
                " \n Livros: { " + this.livros + " }";
    }
}
