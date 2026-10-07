package Service;

import Domain.CategoriaProduto;
import Domain.Produto;
import Infrastructure.ProdutosRepositorio;
import Exception.*;

import java.util.List;
import java.util.Map;

public class ProdutoServico {
    private ProdutosRepositorio produtoRepository;

    public ProdutoServico(ProdutosRepositorio produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(Produto produto) {
        if (produto == null)
            throw new IllegalArgumentException("Produto não pode ser nulo.");

        if (produtoRepository.existeProdutoPorID(produto.getId()))
            throw new IllegalArgumentException("Já existe um produto com esse ID.");

        if (produto.getPreco() <= 0)
            throw new IllegalArgumentException("O preço do produto deve ser maior que zero.");

        if (produto.getQtdEmEstoque() < 0)
            throw new QuantidadeInvalidaException("A quantidade em estoque não pode ser negativa.");

        produtoRepository.adicionarProduto(produto);
    }

    public Produto buscarProdutoPorId(int id) {
        Produto produto = produtoRepository.buscarProdutoPorID(id);

        if (produto == null)
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");

        return produto;
    }

    public void removerProduto(int id) {
        produtoRepository.removerProduto(id);
    }

    public void atualizarPreco(int id, double novoPreco) {
        Produto produto = buscarProdutoPorId(id);

        if (novoPreco <= 0)
            throw new IllegalArgumentException("O preço deve ser maior que zero.");

        produto.setPreco(novoPreco);
    }

    public void adicionarEstoque(int id, int quantidade) {
        Produto produto = buscarProdutoPorId(id);

        if (quantidade <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        produto.setQtdEmEstoque(produto.getQtdEmEstoque() + quantidade);
    }

    public void removerEstoque(int id, int quantidade) {
        Produto produto = buscarProdutoPorId(id);

        if (quantidade <= 0)
            throw new QuantidadeInvalidaException("A quantidade deve ser maior que zero.");

        if (produto.getQtdEmEstoque() < quantidade)
            throw new IllegalArgumentException("Estoque insuficiente.");

        produto.setQtdEmEstoque(produto.getQtdEmEstoque() - quantidade);
    }

    public List<Produto> buscarProdutosPorCategoria(CategoriaProduto categoria) {
        if (categoria == null)
            throw new IllegalArgumentException("A categoria não pode ser nula.");

        return produtoRepository.buscarProdutosPorCategoria(categoria);
    }

    public List<Produto> buscarProdutosPorFornecedor(int idFornecedor) {
        return produtoRepository.buscarProdutosPorFornecedor(idFornecedor);
    }

    public List<Produto> buscarProdutosPorNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");

        return produtoRepository.buscarProdutoPorNome(nome);
    }

    public List<Produto> listarProdutosDisponiveis() {
        return produtoRepository.buscarProdutosDisponiveis();
    }

    public boolean verificarDisponibilidade(int id, int quantidade) {
        Produto produto = buscarProdutoPorId(id);

        return produto.getQtdEmEstoque() >= quantidade;
    }

    public List<Produto> buscarProdutosPorFaixaDePreco(double precoMinimo, double precoMaximo) {
        if (precoMinimo < 0 || precoMaximo < 0)
            throw new IllegalArgumentException("Os preços não podem ser negativos.");

        if (precoMinimo > precoMaximo)
            throw new IllegalArgumentException("O preço mínimo não pode ser maior que o preço máximo.");

        return produtoRepository.buscarProdutosPorFaixaDePreco(precoMinimo, precoMaximo);
    }

    public Map<Integer, Produto> listarTodosProdutos() {
        return produtoRepository.listarTodos();
    }
}
