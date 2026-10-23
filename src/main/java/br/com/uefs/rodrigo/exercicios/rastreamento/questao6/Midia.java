package br.com.uefs.rodrigo.exercicios.rastreamento.questao6;


// Considere o Código:

abstract class Midia {
    public abstract int duracao();
}

class Filme extends Midia {

    private int minutos;

    public Filme(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public int duracao() {
        return minutos;
    }
}

class Podcast extends Midia {

    private int episodios;
    private int minutosPorEpisodio;

    public Podcast(int episodios, int minutosPorEpisodio) {
        this.episodios = episodios;
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public int duracao() {
        return episodios * minutosPorEpisodio;
    }
}

/*
* Considere o trecho:

    Midia[] itens = {
        new Filme(120),
        new Podcast(8, 35),
        new Filme(95)
    };

    int total = 0;
    for (Midia item : itens) {
        System.out.println(item.duracao());
        total += item.duracao();
    }

    System.out.println(total);

a) Qual é a saída completa?
b) Por que o vetor pode armazenar objetos de classes diferentes?
c) O que determina qual implementação de duracao() será executada em cada iteração?

*
*
* Respostas:
* a) Saída completa:
* 120
* 280
* 95
* 495
*
* b) O vetor pode armazenar objetos de classes diferentes pois está sendo utilizada
* generalização, ou seja, Mídia funciona como a classe menos especifica. Como Podcast e
* Filme são um tipo de Mídia, o Java aceita isso.
*
* b) Resposta aprimorada: O vetor pode armazenar objetos de classes diferentes devido
* ao polimorfismo de subtipos. Como Filme e Podcast herdam de Midia, ambos podem ser
* referenciados pelo tipo da superclasse. Dessa forma, um vetor de Midia pode armazenar
* instâncias das duas subclasses.
*
* c) O java chama a implementação do objeto, que são nesse caso o tipo de cada instancia.
* A classe abstrata Mídia apenas diz quais metodos sera possivel acessar por meio daquele objeto,
* enquanto o new diz qual implementação está sendo utilizada (mais precisamente, o tipo
* do objeto naquele momento decidi isso, pois é possivel usar o new novamente para transnformar
* um objeto do tipo estatico Mídia, para referenciar um Filme e depois um Podcast).
*
* c) Resposta aprimorada: A implementação executada depende do tipo real do objeto
*  referenciado em cada iteração. Por meio do despacho dinâmico, Java seleciona em tempo
*  de execução a implementação sobrescrita de duracao() correspondente ao
* objeto, seja Filme ou Podcast. O tipo declarado Midia determina que o
* método pode ser acessado pela referência.
*
* CONCEITO IMPORTANTE para a questão c):
*
* O termo técnico para a escolha da implementação é despacho dinâmico de métodos
*
* O Java considera dois tipos:
-> Tipo estático: Midia, que determina quais métodos podem ser
* chamados diretamente pela referência.
*
-> Tipo dinâmico: Filme, que determina qual implementação sobrescrita
*  será executada em tempo de execução.
* */


