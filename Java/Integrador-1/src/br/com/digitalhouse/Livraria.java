package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;

public class Livraria {
    private List<Livro> livrosEstoque = new ArrayList<>();
    private List<Colecao> colecaoLivros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        this.livrosEstoque.add(livro);
    }

    public void cadastrarColecao(Colecao colecao) {
        this.colecaoLivros.add(colecao);
    }

    public void consultarLivroPorCodigo(int codigo) {
        Livro livroBuscado = null;
        for (Livro livro : livrosEstoque) {
            if (livro.getCodigo() == codigo) {
                livroBuscado = livro;
            }
        }

        if (livroBuscado != null) {
            System.out.println(livroBuscado);
        } else {
            System.out.println("Livro não encontrado");
        }
    }

    public void efetuarVendaPorCodigo(int codigo) {
        Livro livroEncontrado = null;
        for (Livro livro : livrosEstoque) {
            if (livro.getCodigo() == codigo) {
                livroEncontrado = livro;
            }
        }

        if (livroEncontrado != null) {
            if (livroEncontrado.getQuantidadeEstoque() > 0) {
                System.out.println("Saldo de livros em estoque: " + livroEncontrado.getQuantidadeEstoque());
                livroEncontrado.setQuantidadeEstoque(livroEncontrado.getQuantidadeEstoque() - 1);
                System.out.println(livroEncontrado);
            } else {
                System.out.println("Estoque esgotado");
            }
        } else {
            System.out.println("Livro não existe na Livraria, Vamos buscar as conleções");

            Colecao colecaoEncontrada = null;
            for (Colecao colecao : colecaoLivros) {
                if (colecao.getCodigo() == codigo) {
                    colecaoEncontrada = colecao;
                }
            }

            if (colecaoEncontrada != null) {
                System.out.println("Vendendo a coleção de livros");
                System.out.println(colecaoEncontrada);
                colecaoLivros.remove(colecaoEncontrada);
            } else {
                System.out.println("Coleção não existe na livraria");
            }
        }
    }
}
