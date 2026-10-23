package br.com.uefs.rodrigo.exercicios.rastreamento.questao7;


// Considere o seguinte código:

interface Exportavel {
    String exportar();
}
abstract class Relatorio implements Exportavel {

    protected String titulo;

    public Relatorio(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}

class RelatorioTexto extends Relatorio {

    public RelatorioTexto(String titulo) {
        super(titulo);
    }

    @Override
    public String exportar() {
        return "TXT: " + titulo;
    }
}

class RelatorioHtml extends Relatorio {

    public RelatorioHtml(String titulo) {
        super(titulo);
    }

    @Override
    public String exportar() {
        return "<h1>" + titulo + "</h1>";
    }
}

/*  Analise:

    Exportavel a = new RelatorioTexto("Vendas");
    Exportavel b = new RelatorioHtml("Estoque");

    System.out.println(a.exportar());
    System.out.println(b.exportar());


a) Qual é a saída?
b) Por que Exportavel pode ser usado como tipo das variáveis a e b?
c) Qual seria o problema de tentar instanciar diretamente Relatorio?

Respostas:

a)  TXT: Vendas
    <h1>Estoque</h1>

b) a classe abstrata relatorio tem como um de seus contratos que os subtipos devem
prover a implementação para o metodo exportar(), vindo da interface Exportavel.
Os subtipos concretos de interfaces devem prover a implementação ou serem
abstratos e delegarem isso para os subtipos concretos. Desse modo, RelatorioTexto
e RelatorioHtml são subtipos da classe abstrata relatorio, que prove tambem um atributo
protegido, uma implementação e um construtor.Isso é uma relação de Herança Polimorfica.
Desse modo, por serem subtipos de exportavel, o metodo da interface pode ser chamado,
 porem não poderiam ser chamados o metodo de getTitulo(), por exemplo.

b) resposta aprimorada: Exportavel pode ser utilizado como tipo das variáveis
porque RelatorioTexto e RelatorioHtml são subtipos da interface, já que herdam
de Relatorio, que implementa Exportavel. Isso permite utilizar o polimorfismo
de subtipos, atribuindo objetos de diferentes classes a referências
do tipo Exportavel. O tipo da referência permite acessar os métodos declarados
na interface, enquanto a implementação executada de exportar() depende do tipo real do objeto

c) Relatorio é uma classe abstrata, portanto não pode ser instanciada. Apenas as classes concretas
podem ser instanciadas como RelatorioTexto e RelatorioHtml, mas Relatorio poderia ser utilizada
como tipo estatico. Apesar de não poder ser instanciada, seus construtores ainda podem ser
utilizadas, como visto no codigo.
* */