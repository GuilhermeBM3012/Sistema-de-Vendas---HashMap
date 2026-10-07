package Infrastructure;

import Domain.Pedido;
import Domain.StatusPedido;
import Exception.PedidoNaoEncontradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidosRepositorio {
    HashMap<Integer, Pedido> dicPedido = new HashMap<>();

    public void adicionarPedido(Pedido pedido){dicPedido.put(pedido.getId(), pedido);}

    public boolean existePedidoPorID(int id){return dicPedido.containsKey(id);}

    public Pedido buscarPedidoPorID(int id){return dicPedido.get(id);}

    public void removerPedido(int id){
        if (!existePedidoPorID(id))
            throw new PedidoNaoEncontradoException("Pedido não encontrado!!! ");

        dicPedido.remove(id);
    }

    public List<Pedido> buscarPedidosPorCliente(int idCliente) {
        List<Pedido> pedidosCliente = new ArrayList<>();

        for (Pedido pedido : dicPedido.values()) {
            if (pedido.getCliente().getId() == idCliente)
                pedidosCliente.add(pedido);
        }
        return pedidosCliente;
    }

    public List<Pedido> buscarPedidosPorStatus(StatusPedido status) {
        List<Pedido> pedidosEncontrados = new ArrayList<>();

        for (Pedido pedido : dicPedido.values()) {
            if (pedido.getStatus() == status)
                pedidosEncontrados.add(pedido);
        }
        return pedidosEncontrados;
    }

    public List<Pedido> buscarPedidosPorPeriodo(LocalDate inicio, LocalDate fim) {
        List<Pedido> pedidosEncontrados = new ArrayList<>();

        for (Pedido pedido : dicPedido.values()) {
            if (!pedido.getDataPedido().isBefore(inicio) && !pedido.getDataPedido().isAfter(fim))
                pedidosEncontrados.add(pedido);
        }
        return pedidosEncontrados;
    }

    public Map<Integer, Pedido> listarTodos(){
        return dicPedido;
    }
}
