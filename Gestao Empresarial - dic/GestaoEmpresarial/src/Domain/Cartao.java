package Domain;

import java.time.LocalDate;

public class Cartao extends Pagamento{
    private int quantidadeParcelas;
    private double percentualJuros;


    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }
    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getPercentualJuros() {
        return percentualJuros;
    }
    public void setPercentualJuros(double percentualJuros) {
        this.percentualJuros = percentualJuros;
    }


    public Cartao() {super();}

    public Cartao(double valor, LocalDate dataPagamento, int quantidadeParcelas, double percentualJuros) {
        super(valor, dataPagamento);

        this.quantidadeParcelas = quantidadeParcelas;
        this.percentualJuros = percentualJuros;
    }


    public double calcularValorParcela() {
        if (quantidadeParcelas > 0 )
            return calcularValorFinal() / quantidadeParcelas;

        throw new IllegalArgumentException("A quantidade de parcelas tem que ser maior que 0!!");
    }

    @Override
    public double calcularValorFinal() {
        return getValor() + (getValor() * percentualJuros / 100.0);
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
                "\nForma de pagamento: Cartão" +
                "\nParcelas: " + quantidadeParcelas +
                "\nJuros: " + percentualJuros + "%" +
                "\nValor final: R$ " + calcularValorFinal() +
                "\nValor da parcela: R$ " + calcularValorParcela();
    }
}
