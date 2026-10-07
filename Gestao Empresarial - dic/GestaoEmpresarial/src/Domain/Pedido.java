package Domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int proximoId = 1;

    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private Pagamento pagamento;
    private LocalDate dataPedido;


    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public StatusPedido getStatus() {
        return status;
    }
    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }


    public Pedido() {
        this.id = proximoId++;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
        this.dataPedido = LocalDate.now();
    }

    public Pedido(Cliente cliente) {
        this.id = proximoId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
        this.dataPedido = LocalDate.now();
    }


    public double calcularSubtotal() {
        double subtotal = 0;

        for (ItemPedido item : itens) {
            subtotal += item.calcularSubtotal();
        }

        return subtotal;
    }

    public double calcularPesoTotal() {
        double pesoTotal = 0;

        for (ItemPedido item : itens) {
            if (item.getProduto() instanceof Alimento alimento) {
                pesoTotal += alimento.getPeso() * item.getQuantidade();
            }
        }

        return pesoTotal;
    }

    public double calcularFrete() {
        double frete = 10.0 + (calcularPesoTotal() * 2);

        return frete;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularFrete();
    }

    @Override
    public String toString() {
        return "\nPedido: " + id +
                "\nCliente: " + cliente.getNomeCompleto() +
                "\nData: " + dataPedido +
                "\nStatus: " + status +
                "\nSubtotal: R$ " + calcularSubtotal() +
                "\nPeso total: " + calcularPesoTotal() + " kg" +
                "\nFrete: R$ " + calcularFrete() +
                "\nTotal: R$ " + calcularTotal();
    }
}
