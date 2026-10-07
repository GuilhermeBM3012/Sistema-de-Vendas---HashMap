package Domain;

import java.time.LocalDate;

public class Boleto extends Pagamento{
    private double percentualDesconto;
    private double percentualMulta;
    private LocalDate dataVencimento;


    public double getPercentualDesconto() {
        return percentualDesconto;
    }
    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getPercentualMulta() {
        return percentualMulta;
    }
    public void setPercentualMulta(double percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean estaAtrasado() {
        return LocalDate.now().isAfter(dataVencimento);
    }


    public Boleto() {
        super();
    }

    public Boleto(double valor, LocalDate dataPagamento, double percentualDesconto, double percentualMulta,
                  LocalDate dataVencimento) {

        super(valor, dataPagamento);

        this.percentualDesconto = percentualDesconto;
        this.percentualMulta = percentualMulta;
        this.dataVencimento = dataVencimento;
    }


    @Override
    public double calcularValorFinal() {
        double valorFinal = getValor();

        if (percentualMulta > 0 && percentualDesconto > 0){
            if (estaAtrasado())
                valorFinal += valorFinal * (percentualMulta / 100.0);
            else
                valorFinal -= valorFinal * (percentualDesconto / 100.0);

            return valorFinal;
        }

        throw new IllegalArgumentException("O percentual da multa e do desconto tem que ser maior que 0!!");

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
                "\nForma de pagamento: Boleto" +
                "\nData de vencimento: " + dataVencimento +
                "\nDesconto: " + percentualDesconto + "%" +
                "\nMulta: " + percentualMulta + "%" +
                "\nValor final: R$ " + calcularValorFinal();
    }
}
