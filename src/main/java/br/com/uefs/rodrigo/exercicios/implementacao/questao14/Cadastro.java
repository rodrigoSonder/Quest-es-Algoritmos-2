package br.com.uefs.rodrigo.exercicios.implementacao.questao14;

/*13. Implemente uma classe Cadastro com o método estático validarIdade(int idade).

O método deve lançar IllegalArgumentException quando a idade for negativa. Caso
contrário, deve imprimir "Idade válida".

Escreva também um método main que teste uma idade válida e uma idade inválida, capturando a
exceção e imprimindo "Idade inválida" quando ela ocorrer.

A exceção deve ser tratada no main, e não dentro de validarIdade().*/

public class Cadastro {
    public static void validarIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida");
        }

        System.out.println("Idade válida");
    }
}

class Main {
    static void main(String[] args) {
        Cadastro.validarIdade(20);

        try {
            Cadastro.validarIdade(-799);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
