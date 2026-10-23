package br.com.uefs.rodrigo.exercicios.implementacao.questao10;

/*10. Implemente uma interface ComparavelPorPreco com um método que permita
comparar o preço de um objeto com o de outro objeto do mesmo tipo.

Implemente uma classe Produto, com nome e preço, que realize essa interface.
Escreva um método que receba dois produtos e retorne o produto de menor preço. Se os preços
forem iguais, o método poderá retornar qualquer um deles.

Explique brevemente por que definir um contrato por meio de uma interface pode facilitar a
extensão do programa.
*/

/* Utilizar uma interface para definir contratos no programa, permite que seja possível
definir comportamentos especificos esperados de cada classe, mas onde cada classe sabe como
implementá-los. Por exemplo, uma classe Aluno, saberá como identificar e comparar se dois
objetos de sua classe são iguais ou não, mas cabe a classe decidir como implementar esse comportamento.
Desse modo, o código fica muito mais flexivel e extensivel. Outros comportamentos que não são comuns
a todos, podem ser usados em interfaces com metodos unicos para isso, Como é o caso da Interface Comparable
* */

public interface ComparavelPorPreco<T> {
    /*Lógica que eu usei: semelhante ao metodo CompareTo:
    * retorna negativo se o produto atual tem preço menor,
    * retorna 0 se os preços forem iguais,
    * retorna positivo se o produto atual tem preço maior */
    int compararPreco(T obj);
}
class Produto implements ComparavelPorPreco<Produto> {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public int compararPreco(Produto outroProduto) {
        if (this.preco > outroProduto.getPreco()) {
            return 1;
        }

        if (this.preco < outroProduto.getPreco()) {
            return -1;
        }

        return 0;
    }

    // Não é necessário, é só pra ver no print
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}

class SeletorDeProdutos {
    // a expressão <T extends ComparavelPorPreco<T>>
    // Permite que o metodo trabalhe com qualquer Classe que implemente a interface
    public static <T extends ComparavelPorPreco<T>> T menorPreco(T o1, T o2) {

        return o1.compararPreco(o2) >= 0 ? o2 : o1;
    }
}

class Main {
    static void main(String[] args) {
        Produto notebook = new Produto("notebook", 4796.75d);
        Produto celular = new Produto("xiomi", 1400.99);

        Produto produtoMenorPreco =
                SeletorDeProdutos.menorPreco(notebook, celular);

        System.out.println(produtoMenorPreco.toString());
    }
}