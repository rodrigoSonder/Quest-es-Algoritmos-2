package br.com.uefs.rodrigo.exercicios.implementacao.questao24;

/*
24. Implemente uma classe CatalogoProdutos que utilize um Map<String, Double> para
relacionar códigos de produtos a preços.

A classe deve oferecer:
• cadastrar(String codigo, double preco): registra ou atualiza o preço de um
produto.
• consultarPreco(String codigo): retorna o preço cadastrado ou indica que o código
não existe.
• remover(String codigo): remove um produto do catálogo.
• quantidade(): retorna a quantidade de códigos cadastrados.

Considere que os preços são não negativos. Escreva um exemplo que cadastre três produtos,
atualize um preço, consulte um código e remova outro produto.
*/

import java.util.HashMap;
import java.util.Map;

public class CatalogoProdutos {

    private Map<String, Double> catalogoProduto;

    public CatalogoProdutos() {
        this.catalogoProduto = new HashMap<>();
    }

    public void cadastrar(String codigo, double preco) {
        this.catalogoProduto.put(codigo, preco);
    }

    public double consultarPreco(String codigo) {
        if (this.catalogoProduto.containsKey(codigo)) {
            return this.catalogoProduto.get(codigo);
        }
        throw new UnsupportedOperationException("Não existe esse código de produto");
    }

    public void remover(String codigo) {
        this.catalogoProduto.remove(codigo);
    }

    public int quantidade() {
        return this.catalogoProduto.size();
    }
}

class Main {
    static void main(String[] args) {
        CatalogoProdutos catalogoProdutos = new CatalogoProdutos();

        catalogoProdutos.cadastrar("T0T", 76.99);
        catalogoProdutos.cadastrar("8XI", 9.76);
        catalogoProdutos.cadastrar("XB8", 5.50);

        try {
            System.out.println(catalogoProdutos.consultarPreco("T0T"));
            System.out.println(catalogoProdutos.consultarPreco("9999"));
        } catch (UnsupportedOperationException error) {
            System.out.println(error.getMessage());
        }

        System.out.println("Quantida de produtos: " + catalogoProdutos.quantidade());

        catalogoProdutos.remover("8XI");

        System.out.println("Quantida de produtos: " + catalogoProdutos.quantidade());
    }
}
