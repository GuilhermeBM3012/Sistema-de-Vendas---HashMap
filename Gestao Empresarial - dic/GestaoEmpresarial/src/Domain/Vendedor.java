package Domain;

import java.time.LocalDate;

public class Vendedor extends Funcionario{
    private double percentualComissao;
    private double precoTotalVendas;


    public double getprecoTotalVendas() {
        return precoTotalVendas;
    }
    public void setprecoTotalVendas(double precoTotalVendas) {
        this.precoTotalVendas = precoTotalVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }
    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }


    public Vendedor(){}

    public Vendedor(String nomeCompleto, String cpf, String telefone, String email, Endereco endereco,
                    String matricula, double salarioBase, LocalDate dataContratacao, double percentualComissao,
                    double precoTotalVendas){

        super(nomeCompleto, cpf, telefone, email, endereco, matricula, salarioBase, dataContratacao);

        this.percentualComissao = percentualComissao;
        this.precoTotalVendas = precoTotalVendas;
    }


    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularComissao();
    }

    public double calcularComissao() {
        return precoTotalVendas * (percentualComissao / 100.0);
    }

    public double calcularComissao(double valorVenda) {
        return valorVenda * (percentualComissao / 100.0);
    }

    public void registrarVenda(double valorVenda) {
        precoTotalVendas += valorVenda;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPercentual de comissão: " + percentualComissao + "%" +
                "\nQuantidade de vendas (em reais): R$" + precoTotalVendas +
                "\nComissão: R$" + calcularComissao();
    }
}
