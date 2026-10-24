package br.com.uefs.rodrigo.exercicios.implementacao.questao25;

/*
25. Implemente um método estático:

public static List<Integer> selecionarPares(Collection<Integer> numeros)

O método deve retornar uma nova lista contendo somente os números pares da coleção recebida,
sem modificar a coleção original.

A lista retornada deve preservar a ordem em que os números pares aparecem na coleção de
entrada.

Teste o método utilizando uma ArrayList<Integer> e uma coleção do tipo
LinkedList<Integer>.

Explique por que declarar o parâmetro como Collection<Integer> permite utilizar o método
com diferentes implementações de coleções.
*/

/* Resposta: Declarar o parâmetro como Collection<Integer> permite que o método receba
   diferentes implementações dessa interface, como ArrayList e LinkedList, sem precisar
   conhecer a classe concreta utilizada. Isso reduz o acoplamento com uma implementação
   específica e facilita a reutilização e a extensão do código.
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static List<Integer> selecionarPares(Collection<Integer> numeros) {
        List<Integer> listaPares = new ArrayList<>();

        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                listaPares.add(numero);
            }
        }

        return listaPares;
    }

    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,2,3,4,5,5,7,9);

        List<Integer> listaPares = selecionarPares(new ArrayList<>(numeros));

        List<Integer> listaPares2 = selecionarPares(new LinkedList<>(numeros));

        System.out.println(listaPares);
        System.out.println(listaPares2);
    }
}
