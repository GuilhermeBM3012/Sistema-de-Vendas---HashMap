package Domain;

import java.time.LocalDate;

public class Pix extends Pagamento{
    private double percentualDesconto;


    public double getPercentualDesconto() {
        return percentualDesconto;
    }
    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }


    public Pix() {super();}

    public Pix(double valor, LocalDate dataPagamento, double percentualDesconto) {
        super(valor, dataPagamento);

        this.percentualDesconto = percentualDesconto;
    }


    @Override
    public double calcularValorFinal() {
        return getValor() - (getValor() * percentualDesconto / 100.0);
    }

    @Override
    public void processarPagamento() {
        setProcessado(true);
    }

    @Override
    public void cancelarPagamento() {
        setProcessado(false);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nForma de pagamento: Pix" +
                "\nDesconto: " + percentualDesconto + "%" +
                "\nValor final: R$ " + calcularValorFinal();
    }
}
