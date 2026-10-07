package Domain;

import java.time.LocalDate;

public class Estoquista extends Funcionario{
    private double horasExtras;
    private double valorHoraExtra;
    private CategoriaProduto categoriaResponsavel;


    public double getHorasExtras() {
        return horasExtras;
    }
    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }
    public void setValorHoraExtra(double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public CategoriaProduto getCategoriaResponsavel() {
        return categoriaResponsavel;
    }
    public void setCategoriaResponsavel(CategoriaProduto categoriaResponsavel) {
        this.categoriaResponsavel = categoriaResponsavel;
    }


    public Estoquista(){}

    public Estoquista(String nomeCompleto, String cpf, String telefone, String email, Endereco endereco,
                      String matricula, double salarioBase, LocalDate dataContratacao,
                      CategoriaProduto categoriaResponsavel, double horasExtras, double valorHoraExtra){

        super(nomeCompleto, cpf, telefone, email, endereco, matricula, salarioBase, dataContratacao);

        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
        this.categoriaResponsavel = categoriaResponsavel;
    }


    @Override
    public double calcularSalario() {
        return getSalarioBase() + calcularValorHorasExtras();
    }

    public double calcularValorHorasExtras() {
        return horasExtras * valorHoraExtra;
    }

    public double calcularValorHorasExtras(double horas) {
        return horas * valorHoraExtra;
    }

    public void registrarHorasExtras(double horas) {
        horasExtras += horas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nHoras Extras: " + horasExtras +
                "\nValor por Hora Extra: R$ " + valorHoraExtra +
                "\nValor das Horas Extras: R$ " + calcularValorHorasExtras() +
                "\nSetor de estoque: " + categoriaResponsavel;
    }
}
