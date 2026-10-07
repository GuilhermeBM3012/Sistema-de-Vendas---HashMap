package Domain;

import Exception.QtdPontosInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private double limiteCredito;
    private int pontosFidelidade;
    private List<Pedido> pedidos;


    public double getLimiteCredito() {
        return limiteCredito;
    }
    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }
    public void setPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }


    public Cliente(){
        super();
        this.pontosFidelidade = 0;
        pedidos = new ArrayList<>();
    }

    public Cliente(String nomeCompleto, String cpf, String telefone, String email, Endereco endereco,
                   double limiteCredito){

        super(nomeCompleto, cpf, telefone, email, endereco);

        this.limiteCredito = limiteCredito;
        this.pontosFidelidade = 0;
        this.pedidos = new ArrayList<>();
    }


    public void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public void excluirPedido(Pedido pedido){
        pedidos.remove(pedido);
    }

    public void adicionarPontosFidelidade(int pontos){
        if (pontosFidelidade < 10)
            pontosFidelidade += pontos;

        throw new QtdPontosInvalidoException("A quantidade máxima de pontos de fidelidade é 10!!");
    }

    public void removerPontosFidelidade(int pontos){
        if (pontos <= pontosFidelidade)
            pontosFidelidade -= pontos;

        throw new QtdPontosInvalidoException("Não da para diminuir uma quantidade de pontos maior do " +
                "que a que você tem");
    }

    public boolean possuiLimite(double valor) {
        return limiteCredito >= valor;
    }

    public void utilizarLimite(double valor) {
        if (possuiLimite(valor)) {
            limiteCredito -= valor;
        }
    }

    public void restaurarLimite(double valor) {
        limiteCredito += valor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLimite de crédito: R$" + limiteCredito +
                "\nPontos de Fidelidade: " + pontosFidelidade +
                "\nQuantidade de pedidos: " + pedidos.size();
    }
}
