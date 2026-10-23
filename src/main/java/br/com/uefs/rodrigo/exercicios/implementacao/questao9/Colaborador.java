package br.com.uefs.rodrigo.exercicios.implementacao.questao9;


/*9. Implemente uma classe abstrata Colaborador, com atributos privados para nome e
salário-base, um construtor e métodos de acesso.

A classe deve declarar um método abstrato calcularBonus().

Implemente duas subclasses:
• ColaboradorTecnico: bônus de 8% do salário-base.
• ColaboradorGerente: bônus de 15% do salário-base.

Crie também um método que receba um vetor de Colaborador e calcule a soma dos bônus de
todos os elementos, sem verificar explicitamente o tipo de cada objeto com instanceof.
*/

public abstract class Colaborador {

    private String nome;
    private Double salarioBase;

    public Colaborador(String nome, Double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract Double calcularBonus();

    public String getNome() {
        return nome;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }
}

class ColaboradorTecnico extends Colaborador {

    public ColaboradorTecnico(String nome, Double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public Double calcularBonus() {
        return getSalarioBase() * 0.08D;
    }
}

class ColaboradorGerente extends Colaborador {

    public ColaboradorGerente(String nome, Double salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public Double calcularBonus() {
        return getSalarioBase() * 0.15D;
    }
}

class GerenciadorColaboradores {
    public static Double somarBonusDeTodosOsColaboradores(Colaborador[] colaboradores) {
        Double somaBonus = 0.0D;

        for (Colaborador colaborador : colaboradores) {
            somaBonus += colaborador.calcularBonus();
        }

        return somaBonus;

    }
}

class Main {
    static void main(String[] args) {

        Colaborador[] colaboradores = {
          new ColaboradorGerente("Sirius", 2506.64D),
          new ColaboradorTecnico("Rodrigo", 1626.75D),
          new ColaboradorGerente("Rapha", 76.99D)
        };

        Double somaTotal =
                GerenciadorColaboradores.somarBonusDeTodosOsColaboradores(colaboradores);

        System.out.printf("Soma total dos bônus: %.2f", somaTotal);
    }
}