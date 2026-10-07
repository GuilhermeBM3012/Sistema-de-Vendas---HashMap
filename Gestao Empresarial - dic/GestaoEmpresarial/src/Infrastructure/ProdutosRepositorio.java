package Infrastructure;

import Domain.CategoriaProduto;
import Domain.Produto;
import Exception.ProdutoNaoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutosRepositorio {
    HashMap<Integer, Produto> dicProduto = new HashMap<>();

    public void adicionarProduto(Produto produto){dicProduto.put(produto.getId(), produto);}

    public boolean existeProdutoPorID(int id){return dicProduto.containsKey(id);}

    public Produto buscarProdutoPorID(int id){return dicProduto.get(id);}

    public void removerProduto(int id){
        if (!existeProdutoPorID(id))
            throw new ProdutoNaoEncontradoException("Produto não encontrado!!! ");

        dicProduto.remove(id);
    }

    public List<Produto> buscarProdutosPorCategoria(CategoriaProduto categoria) {
        List<Produto> produtosEncontrados = new ArrayList<>();

        for (Produto produto : dicProduto.values()) {
            if (produto.getCategoria() == categoria)
                produtosEncontrados.add(produto);
        }
        return produtosEncontrados;
    }

    public List<Produto> buscarProdutosPorFornecedor(int idFornecedor) {
        List<Produto> produtosEncontrados = new ArrayList<>();

        for (Produto produto : dicProduto.values()) {
            if (produto.getFornecedor().getId() == idFornecedor)
                produtosEncontrados.add(produto);
        }
        return produtosEncontrados;
    }

    public List<Produto> buscarProdutoPorNome(String nome) {
        List<Produto> produtosEncontrados = new ArrayList<>();

        for (Produto produto : dicProduto.values()) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase()))
                produtosEncontrados.add(produto);
        }
        return produtosEncontrados;
    }

    public List<Produto> buscarProdutosDisponiveis() {
        List<Produto> produtosDisponiveis = new ArrayList<>();

        for (Produto produto : dicProduto.values()) {
            if (produto.getQtdEmEstoque() > 0)
                produtosDisponiveis.add(produto);
        }
        return produtosDisponiveis;
    }

    public List<Produto> buscarProdutosPorFaixaDePreco(double precoMinimo, double precoMaximo) {
        List<Produto> produtosEncontrados = new ArrayList<>();

        for (Produto produto : dicProduto.values()) {
            if (produto.getPreco() >= precoMinimo && produto.getPreco() <= precoMaximo)
                produtosEncontrados.add(produto);
        }

        return produtosEncontrados;
    }

    public Map<Integer, Produto> listarTodos(){
        return dicProduto;
    }
}
