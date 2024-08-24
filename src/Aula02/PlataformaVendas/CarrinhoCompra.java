package Aula02.PlataformaVendas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {
    private List<Produto> produtos;
    private double desconto;

    public CarrinhoCompra() {
        this.produtos = new ArrayList<>();
        this.desconto = 0.0;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto " + produto.getNome() + " adicionado ao carrinho.");
    }

    public void removerProduto(Produto produto) {
        if (produtos.remove(produto)) {
            System.out.println("Produto " + produto.getNome() + " removido do carrinho.");
        } else {
            System.out.println("Produto " + produto.getNome() + " não encontrado no carrinho.");
        }
    }

    public void aplicarDesconto(double desconto) {
        if (desconto >= 0 && desconto <= 100) {
            this.desconto = desconto;
            System.out.println("Desconto de " + desconto + "% aplicado.");
        } else {
            System.out.println("Valor de desconto inválido.");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        if (desconto > 0) {
            total -= total * (desconto / 100);
        }
        return total;
    }

    public void exibirCarrinho() {
        System.out.println("Produtos no carrinho:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + " | Preço: R$ " + produto.getPreco());
        }
        System.out.println("Total (com desconto, se aplicado): R$ " + calcularTotal());
    }
}
