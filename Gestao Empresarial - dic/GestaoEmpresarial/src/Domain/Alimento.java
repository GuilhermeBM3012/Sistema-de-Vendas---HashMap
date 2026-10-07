package Domain;

import java.time.LocalDate;

public class Alimento extends Produto{
    private LocalDate validade;
    private double peso;


    public LocalDate getValidade() {
        return validade;
    }
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean estaVencido() {
        return LocalDate.now().isAfter(validade);
    }


    public Alimento() {
    }

    public Alimento(String nome, String descricao, double preco, int quantidadeEstoque,
                    Fornecedor fornecedor, CategoriaProduto categoria, LocalDate validade, double peso) {

        super(nome, descricao, preco, quantidadeEstoque, fornecedor, categoria);

        this.validade = validade;
        this.peso = peso;
    }


    @Override
    public double calcularFrete() {
        return 10.0 + (peso * 2);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nValidade: " + validade +
                "\nPeso: " + peso + " kg" +
                "\nFrete: R$ " + calcularFrete();
    }
}
