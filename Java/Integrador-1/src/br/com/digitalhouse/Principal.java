package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Principal {
    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        Livro harryPotter = new Livro(1, "Harry Potter e a Pedra Filosofal", "J.K Rowling", "1997", "1234", 10, 20.50);
        Livro harryPotter2 = new Livro(2, "Harry Potter e a Câmara Secreta", "J.K Rowling", "1997", "12345", 10, 21.50);
        Livro harryPotter3 = new Livro(3, "Harry Potter e o Prisioreiro de Askaban", "J.K Rowling", "1997", "1234", 10, 23.50);

        List<Livro> livrosHarry = new ArrayList<>();
        livrosHarry.add(harryPotter);
        livrosHarry.add(harryPotter2);
        livrosHarry.add(harryPotter3);
        Colecao colecaoHarryPotter = new Colecao(123, "Coleção Harry Portter", 55.20, livrosHarry);

        livraria.cadastrarLivro(harryPotter);
        livraria.cadastrarLivro(harryPotter2);
        livraria.cadastrarLivro(harryPotter3);
        livraria.cadastrarColecao(colecaoHarryPotter);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma das opções");
        System.out.println("Consultar livro - 1");
        System.out.println("Vender livro/coleção - 2");

        int opcao = scanner.nextInt();

        if (opcao == 1){
            System.out.println("Digite o código do livro");
            int codigo = scanner.nextInt();
            livraria.consultarLivroPorCodigo(codigo);
        }

        if (opcao == 2){
            System.out.println("Digite o código do livro/coleção");
            int codigo = scanner.nextInt();
            livraria.efetuarVendaPorCodigo(codigo);
        }

    }
}
