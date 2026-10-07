package Domain;

import java.time.LocalDate;

public abstract class Funcionario extends Pessoa{
    private String matricula;
    private double salarioBase;
    private LocalDate dataContratacao;


    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salario) {
        this.salarioBase = salario;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }


    public Funcionario() {
    }

    public Funcionario(String nomeCompleto, String cpf, String telefone, String email, Endereco endereco,
                       String matricula, double salarioBase, LocalDate dataContratacao) {

        super(nomeCompleto, cpf, telefone, email, endereco);

        this.matricula = matricula;
        this.salarioBase = salarioBase;
        this.dataContratacao = dataContratacao;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {
        return super.toString() +
                "\nMatrícula: " + matricula +
                "\nSalário: " + salarioBase +
                "\ncData de contratação: " + dataContratacao;
    }
}
