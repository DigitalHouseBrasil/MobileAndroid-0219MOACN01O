package com.br.digitalhouse;

public class Fluxo {

    public static void main(String[] args) {
        System.out.println("Inicio do método principal");
        metodo1();
        System.out.println("Fim do método principal");
    }

    public static void  metodo1(){
        System.out.println("Inicio do método 1");
        metodo2();
        System.out.println("Fim do método 1");

    }

    private static void metodo2() {
        System.out.println("Inicio do método 2");
        metodo3();
        System.out.println("Fim do método 2");
    }

    private static void metodo3(){
        System.out.println("Inicio do método 3");
        for (int i = 0; i <= 5 ; i++) {
            System.out.println(i);
        }
        System.out.println("Fim do método 3");
    }

}
