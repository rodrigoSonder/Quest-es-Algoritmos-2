package br.com.uefs.rodrigo.exercicios.implementacao.questao19;

/* 19. Implemente um método estático genérico:

public static <T> int localizar(T[] elementos, T procurado)

O método deve retornar o índice da primeira ocorrência de procurado no vetor, ou -1 se o
elemento não estiver presente. Utilize equals() para comparar os elementos e considere que o
vetor não contém valores null.

Teste o método com um vetor de String e outro de Integer.

* */

public class Localizador {
    public static <T> int localizar(T[] elementos, T procurado) {
        for (int i = 0; i < elementos.length; i++) {
            /* O equal() poderia dar erro se algum dos elemenos fosse null, mas
             * a questão diz que o array não terá elementos null */
            if (elementos[i].equals(procurado)) {
                return i;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {

        Integer[] numeros = {1,2,3,4,5,6,7};
        String[] palavras = {"oi", "ok", "oie"};

        System.out.println(Localizador.localizar(numeros, 7));
        System.out.println(Localizador.localizar(numeros, 10));

        System.out.println(Localizador.localizar(palavras, "oi"));
        System.out.println(Localizador.localizar(palavras, "olá"));
    }
}
