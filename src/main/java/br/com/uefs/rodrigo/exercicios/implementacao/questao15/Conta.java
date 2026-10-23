package br.com.uefs.rodrigo.exercicios.implementacao.questao15;

/* 15. Implemente uma classe Conta com um atributo privado saldo, inicializado pelo
construtor.

O método sacar(double valor) deve:
• Lançar IllegalArgumentException se o valor for menor ou igual a zero.
• Lançar IllegalStateException se o valor for superior ao saldo.
• Subtrair o valor do saldo quando o saque for válido.

Escreva um exemplo de utilização que tente realizar um saque válido e um saque superior ao
saldo, tratando as exceções com mensagens diferentes.
*/

import java.util.function.Consumer;

public class Conta {

    private double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "Valores nulos ou negativos não são permitidos"
            );
        }

        if (valor > saldo) {
            throw new IllegalStateException(
                    "Saldo insuficiente para esse valor"
            );
        }

        this.saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

class Banco {
    static void main(String[] args) {

        Conta conta = new Conta(1616.75D);

        try {
            conta.sacar(-100);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }

        try {
            conta.sacar(20000000);
        } catch (IllegalStateException illegalStateException) {
            System.out.println(illegalStateException.getMessage());
        }

        System.out.println("Saldo atual: " + conta.getSaldo());

        System.out.println("Sacando R$100,00...");
        conta.sacar(100);

        System.out.println("Saldo após saque: " + conta.getSaldo());
    }
}
