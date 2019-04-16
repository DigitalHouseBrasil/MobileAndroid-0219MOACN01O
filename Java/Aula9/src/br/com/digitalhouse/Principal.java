package br.com.digitalhouse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Principal {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();

        Pessoa tairo = new Pessoa("Tairo", "Roberto", 30);
        Pessoa jessica = new Pessoa("Jessica", "Milena", 18);
        Pessoa vini = new Pessoa("Vini", "PHP", 35);

        pessoas.add(tairo);
        pessoas.add(jessica);
        pessoas.add(vini);

        /*for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome() + "\nSobrenome: " + pessoa.getSobrenome() + "\n");
        }*/

        Set<Pessoa> pessoaSet = new HashSet<>();
        pessoaSet.add(tairo);
        pessoaSet.add(jessica);
        pessoaSet.add(vini);
        pessoaSet.add(vini);
        pessoaSet.add(vini);

        /*for (Pessoa pessoa : pessoaSet) {
            System.out.println("Nome: " + pessoa.getNome() + "\nSobrenome: " + pessoa.getSobrenome() + "\n");
        }*/

        Map<String, Pessoa> pessoaMap = new HashMap<>();
        pessoaMap.put("tairo", tairo);
        pessoaMap.put("jessica", jessica);
        pessoaMap.put("vini", vini);
        pessoaMap.put("vini", vini);
        pessoaMap.put("vini", vini);

        for (String chave : pessoaMap.keySet()) {
            System.out.println("Nome: " + pessoaMap.get(chave).getNome() +
                    "\nSobrenome: " + pessoaMap.get(chave).getSobrenome() + "\n");
        }


        Map<Integer, String> loteriaDosSonhos = new HashMap<>();
        loteriaDosSonhos.put(0, "Ovos");
        loteriaDosSonhos.put(1, "Água");
        loteriaDosSonhos.put(2, "Escopeta");
        loteriaDosSonhos.put(3, "Cavalo");
        loteriaDosSonhos.put(4, "Dentista");
        loteriaDosSonhos.put(5, "Fogo");

        for (int chave : loteriaDosSonhos.keySet()) {
            System.out.println("Valor da loteria: " + loteriaDosSonhos.get(chave));
        }


        Map<String, List<String>> apelidos = new HashMap<>();

        List<String> apelidosJoao = new ArrayList<>();
        apelidosJoao.add("Juan");
        apelidosJoao.add("Fissura");
        apelidosJoao.add("Maromba");

        List<String> apelidosMiguel = new ArrayList<>();
        apelidosMiguel.add("Night Watch");
        apelidosMiguel.add("Bruce Wayne");
        apelidosMiguel.add("Tampinha");

        apelidos.put("joao", apelidosJoao);
        apelidos.put("miguel", apelidosMiguel);

        for (String chave : apelidos.keySet()) {
            System.out.println("Apelidos do: " + chave);
            for (String apelido : apelidos.get(chave)) {
                System.out.println("\t" + apelido);
            }
        }

    }
}
