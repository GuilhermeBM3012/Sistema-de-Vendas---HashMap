package Service;

import Domain.Produto;
import Infrastructure.ProdutosRepositorio;
import Exception.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EstoqueServico {
    private ProdutosRepositorio produtoRepository;

    public EstoqueServico(ProdutosRepositorio produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void adicionarProduto(int idProduto, int quantidade) {
        Produto produto = buscarProdutoPorId(idProduto);

        if (quantidade <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        produto.setQtdEmEstoque(produto.getQtdEmEstoque() + quantidade);
    }

    public void removerProduto(int idProduto, int quantidade) {
        Produto produto = buscarProdutoPorId(idProduto);

        if (quantidade <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        if (produto.getQtdEmEstoque() < quantidade)
            throw new IllegalArgumentException("Estoque insuficiente.");

        produto.setQtdEmEstoque(produto.getQtdEmEstoque() - quantidade);
    }

    public void atualizarQuantidade(int idProduto, int novaQuantidade) {
        Produto produto = buscarProdutoPorId(idProduto);

        if (novaQuantidade < 0)
            throw new IllegalArgumentException("A quantidade não pode ser negativa.");

        produto.setQtdEmEstoque(novaQuantidade);
    }

    public int consultarQuantidade(int idProduto) {

        Produto produto = buscarProdutoPorId(idProduto);

        return produto.getQtdEmEstoque();
    }

    public boolean verificarDisponibilidade(int idProduto, int quantidade) {
        Produto produto = buscarProdutoPorId(idProduto);

        if (quantidade <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        return produto.getQtdEmEstoque() >= quantidade;
    }

    private Produto buscarProdutoPorId(int idProduto) {
        Produto produto = produtoRepository.buscarProdutoPorID(idProduto);

        if (produto == null)
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");

        return produto;
    }

    public List<Produto> listarProdutosEstoqueBaixo(int limite) {
        if (limite < 0) throw new IllegalArgumentException("O limite não pode ser negativo.");

        List<Produto> produtosEstoqueBaixo = new ArrayList<>();

        for (Produto produto : produtoRepository.listarTodos().values()) {
            if (produto.getQtdEmEstoque() <= limite)
                produtosEstoqueBaixo.add(produto);
        }

        return produtosEstoqueBaixo;
    }

    public int calcularQuantidadeTotalEstoque() {
        int total = 0;

        for (Produto produto : produtoRepository.listarTodos().values()) {
            total += produto.getQtdEmEstoque();
        }

        return total;
    }

    public Map<Integer, Produto> listarProdutosEmEstoque() {
        return produtoRepository.listarTodos();
    }
}
