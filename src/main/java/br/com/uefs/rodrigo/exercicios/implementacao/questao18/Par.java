package br.com.uefs.rodrigo.exercicios.implementacao.questao18;
/*
* 18. Implemente uma classe genérica Par<A, B> que armazene dois valores, possivelmente
  de tipos diferentes.
  A classe deve ter:
  • Um construtor que receba os dois valores.
  • Um método getPrimeiro() que retorne o primeiro valor.
  • Um método getSegundo() que retorne o segundo valor.
  Escreva um exemplo que represente um produto por meio de seu nome (String) e seu código
  numérico (Integer).
* */

public class Par<A, B> {
    private final A v1;
    private final B v2;

    public Par(A v1, B v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public A getPrimeiro() {
        return v1;
    }

    public B getSegundo() {
        return v2;
    }
}

// exemplo com produto

class Main {
    public static void main(String... args) {
        Par<String, Integer> notebook = new Par<>("Notebook", 4_700);

        System.out.println(notebook.getPrimeiro());
        System.out.println(notebook.getSegundo());
    }
}


