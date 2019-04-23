package com.br.digitalhouse;

public class Fluxo {

    public static void main(String[] args) {
        System.out.println("Inicio do método principal");
            try {
                metodo1();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        System.out.println("Fim do método principal");
    }

    public static void  metodo1() throws Exception {
        System.out.println("Inicio do método 1");
        metodo2();
        System.out.println("Fim do método 1");
    }

    private static void metodo2() throws FluxoException {

        System.out.println("Inicio do método 2");
        metodo3();

        System.out.println("Fim do método 2");

        if (0 == 2){
            throw new ArithmeticException("ZERO NÃO É IGUAL A ZERO");
        } else{
            throw new FluxoException("ZERO É DIFERENTE DE ZERO");
        }

    }

    private static void metodo3() {
        System.out.println("Inicio do método 3");
        for (int i = 0; i <= 5 ; i++) {
            System.out.println(i);
            int valor = 3;

            try {
                int resultado = valor / 0;
                Conta conta = null;
                conta.sacar(3);

            }catch (Exception ex){

                System.out.println("Aconteceu uma exceção");
                ex.printStackTrace();
                ex.getMessage();

            }finally {
                System.out.println("ESTAMOS NO FINALLY");
            }
     }
        System.out.println("Fim do método 3");
    }

}
