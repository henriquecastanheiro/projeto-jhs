package Aula02.PlataformaVendas;

import java.util.ArrayList;
import java.util.List;

public class PlataformaVenda {
    private List<Produto> catalogo;

    public PlataformaVenda() {
        this.catalogo = new ArrayList<>();
    }

    public void cadastrarProduto(String nome, double preco, String codigo) {
        Produto produto = new Produto(nome, preco, codigo);
        catalogo.add(produto);
        System.out.println("Produto " + nome + " cadastrado com sucesso.");
    }

    public Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : catalogo) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        System.out.println("Produto com código " + codigo + " não encontrado.");
        return null;
    }

    public void exibirCatalogo() {
        System.out.println("Catálogo de Produtos:");
        for (Produto produto : catalogo) {
            System.out.println("- " + produto.getNome() + " | Preço: R$ " + produto.getPreco() + " | Código: " + produto.getCodigo());
        }
    }

    public static void main(String[] args) {
        PlataformaVenda venda = new PlataformaVenda();

        venda.cadastrarProduto("Notebook", 3000.00, "001");
        venda.cadastrarProduto("Smartphone", 1500.00, "002");
        venda.cadastrarProduto("Fone de Ouvido", 200.00, "003");

        venda.exibirCatalogo();

        CarrinhoCompra carrinho = new CarrinhoCompra();
        Produto produto1 = venda.buscarProdutoPorCodigo("001");
        Produto produto2 = venda.buscarProdutoPorCodigo("003");

        if (produto1 != null) carrinho.adicionarProduto(produto1);
        if (produto2 != null) carrinho.adicionarProduto(produto2);

        carrinho.exibirCarrinho();

        carrinho.aplicarDesconto(10);
        carrinho.exibirCarrinho();
    }
}
