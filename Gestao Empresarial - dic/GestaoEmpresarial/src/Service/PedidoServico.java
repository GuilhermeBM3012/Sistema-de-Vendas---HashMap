package Service;

import Domain.*;
import Infrastructure.ClienteRepositorio;
import Infrastructure.PedidosRepositorio;
import Infrastructure.ProdutosRepositorio;
import Exception.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PedidoServico {
    private PedidosRepositorio pedidoRepositorio;
    private ClienteRepositorio clienteRepositorio;
    private ProdutosRepositorio produtoRepositorio;

    private int idPedido;

    public PedidoServico(PedidosRepositorio pedidoRepositorio, ClienteRepositorio clienteRepositorio,
                         ProdutosRepositorio produtoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.produtoRepositorio = produtoRepositorio;
    }

    public Pedido criarPedido(int idCliente) {
        Cliente cliente = clienteRepositorio.buscarClientePorID(idCliente);

        if (cliente == null)
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");

        Pedido pedido = new Pedido(cliente);

        pedidoRepositorio.adicionarPedido(pedido);

        cliente.getPedidos().add(pedido);

        return pedido;
    }

    public Pedido buscarPedidoPorId(int id) {
        Pedido pedido = pedidoRepositorio.buscarPedidoPorID(id);

        if (pedido == null)
            throw new PedidoNaoEncontradoException("Pedido não encontrado.");

        return pedido;
    }

    public void adicionarProduto(int idPedido, int idProduto, int quantidade) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        Produto produto = produtoRepositorio.buscarProdutoPorID(idProduto);

        if (produto == null)
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");

        if (quantidade <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        if (produto.getQtdEmEstoque() < quantidade)
            throw new IllegalArgumentException("Estoque insuficiente.");

        ItemPedido item = new ItemPedido(produto, quantidade);

        pedido.getItens().add(item);

        produto.setQtdEmEstoque(produto.getQtdEmEstoque() - quantidade);
    }

    public void removerProduto(int idPedido, int idProduto) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().getId() == idProduto) {
                pedido.getItens().remove(item);

                item.getProduto().setQtdEmEstoque(item.getProduto().getQtdEmEstoque() +
                        item.getQuantidade());

                return;
            }
        }

        throw new ProdutoNaoEncontradoException("Produto não encontrado no pedido.");
    }

    public void alterarQuantidade(int idPedido, int idProduto, int novaQuantidade) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (novaQuantidade <= 0)
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");

        for (ItemPedido item : pedido.getItens()) {
            if (item.getProduto().getId() == idProduto) {
                int diferenca = novaQuantidade - item.getQuantidade();

                if (diferenca > 0 && item.getProduto().getQtdEmEstoque() < diferenca)
                    throw new IllegalArgumentException("Estoque insuficiente.");

                item.getProduto().setQtdEmEstoque(item.getProduto().getQtdEmEstoque() - diferenca);

                item.setQuantidade(novaQuantidade);

                return;
            }
        }

        throw new ProdutoNaoEncontradoException("Produto não encontrado no pedido.");
    }

    public void aprovarPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido.getStatus() != StatusPedido.PENDENTE)
            throw new IllegalArgumentException("Somente pedidos pendentes podem ser aprovados.");

        pedido.setStatus(StatusPedido.APROVADO);
    }

    public void cancelarPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido.getStatus() == StatusPedido.CANCELADO)
            throw new IllegalArgumentException("O pedido já está cancelado.");

        if (pedido.getStatus() == StatusPedido.FINALIZADO)
            throw new IllegalArgumentException("Não é possível cancelar um pedido finalizado.");

        for (ItemPedido item : pedido.getItens()) {
            item.getProduto().setQtdEmEstoque(item.getProduto().getQtdEmEstoque() + item.getQuantidade());
        }

        pedido.setStatus(StatusPedido.CANCELADO);
    }

    public boolean podeFinalizarPedido(int idPedido) {

        Pedido pedido = buscarPedidoPorId(idPedido);

        return pedido.getStatus() == StatusPedido.APROVADO && pedido.getPagamento() != null
                && !pedido.getItens().isEmpty();
    }

    public void finalizarPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (!podeFinalizarPedido(idPedido))
            throw new IllegalArgumentException("O pedido não pode ser finalizado!");

        pedido.setStatus(StatusPedido.FINALIZADO);
    }

    public Map<Integer, Pedido> listarTodosPedidos() {
        return pedidoRepositorio.listarTodos();
    }

    public List<Pedido> buscarPedidosPorCliente(int idCliente) {

        if (!clienteRepositorio.exiteClientePorID(idCliente))
            throw new ClienteNaoEncontradoException("Cliente não encontrado.");

        return pedidoRepositorio.buscarPedidosPorCliente(idCliente);
    }

    public List<Pedido> buscarPedidosPorStatus(StatusPedido status) {

        if (status == null)
            throw new IllegalArgumentException("O status não pode ser nulo.");

        return pedidoRepositorio.buscarPedidosPorStatus(status);
    }

    public double calcularTotalPedido(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        return pedido.calcularTotal();
    }

    public void registrarPagamento(int idPedido, Pagamento pagamento) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pagamento == null)
            throw new IllegalArgumentException("O pagamento não pode ser nulo.");

        if (pedido.getPagamento() != null)
            throw new IllegalArgumentException("O pedido já possui um pagamento.");

        pedido.setPagamento(pagamento);
    }

    public List<Pedido> buscarPedidosPorPeriodo(LocalDate inicio, LocalDate fim) {
        if (inicio == null || fim == null)
            throw new IllegalArgumentException("As datas não podem ser nulas.");

        if (inicio.isAfter(fim))
            throw new IllegalArgumentException("A data inicial não pode ser posterior à data final.");

        return pedidoRepositorio.buscarPedidosPorPeriodo(inicio, fim);
    }
}
