package Service;

import Domain.Pagamento;
import Domain.Pedido;
import Infrastructure.PedidosRepositorio;
import Exception.*;

public class PagamentoServico {
    private PedidosRepositorio pedidoRepository;

    public PagamentoServico(PedidosRepositorio pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void registrarPagamento(int idPedido, Pagamento pagamento) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pagamento == null)
            throw new IllegalArgumentException("O pagamento não pode ser nulo.");

        if (pedido.getPagamento() != null)
            throw new IllegalArgumentException("O pedido já possui um pagamento.");

        if (pagamento.getValor() <= 0)
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero.");

        if (pagamento.getValor() != pedido.calcularTotal())
            throw new IllegalArgumentException("O valor do pagamento deve ser igual ao total do pedido.");

        pedido.setPagamento(pagamento);
    }

    public void processarPagamento(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido.getPagamento() == null)
            throw new IllegalArgumentException("O pedido não possui pagamento.");

        pedido.getPagamento().processarPagamento();
    }

    public boolean pagamentoFoiProcessado(int idPedido) {

        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido.getPagamento() == null) {
            return false;
        }

        return pedido.getPagamento().isProcessado();
    }

    public void cancelarPagamento(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido.getPagamento() == null)
            throw new IllegalArgumentException("O pedido não possui pagamento.");

        if (!pedido.getPagamento().isProcessado())
            throw new IllegalArgumentException("O pagamento ainda não foi processado.");

        pedido.getPagamento().cancelarPagamento();
    }

    public Pagamento consultarPagamento(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        if (pedido.getPagamento() == null)
            throw new IllegalArgumentException(
                    "O pedido ainda não possui pagamento.");

        return pedido.getPagamento();
    }

    public boolean pedidoPossuiPagamento(int idPedido) {
        Pedido pedido = buscarPedidoPorId(idPedido);

        return pedido.getPagamento() != null;
    }

    private Pedido buscarPedidoPorId(int idPedido) {
        Pedido pedido = pedidoRepository.buscarPedidoPorID(idPedido);

        if (pedido == null)
            throw new PedidoNaoEncontradoException("Pedido não encontrado.");

        return pedido;
    }
}
