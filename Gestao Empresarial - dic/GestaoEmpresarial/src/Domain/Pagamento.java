package Domain;

import java.time.LocalDate;

public abstract class Pagamento {
    private static int proximoId = 1;

    private int id;
    private double valor;
    private LocalDate dataPagamento;
    private boolean processado;

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean isProcessado() {
        return processado;
    }

    protected void setProcessado(boolean processado) {
        this.processado = processado;
    }

    public Pagamento() {
        this.id = proximoId++;
        this.processado = false;
    }

    public Pagamento(double valor, LocalDate dataPagamento) {
        this.id = proximoId++;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.processado = false;
    }


    public abstract double calcularValorFinal();

    public abstract void processarPagamento();

    public abstract void cancelarPagamento();

    @Override
    public String toString() {
        return "\nID do pagamento: " + id +
                "\nValor: R$ " + valor +
                "\nData do pagamento: " + dataPagamento;
    }
}
