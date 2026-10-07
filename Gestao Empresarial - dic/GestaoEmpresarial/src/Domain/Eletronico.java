package Domain;

public class Eletronico extends Produto{
    private String marca;
    private String modelo;
    private int garantiaMeses;
    private int voltagem;


    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }
    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    public int getVoltagem() {
        return voltagem;
    }
    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }


    public Eletronico() {
    }

    public Eletronico(String nome, String descricao, double preco, int quantidadeEstoque,
                      Fornecedor fornecedor, CategoriaProduto categoria, String marca, String modelo, int garantiaMeses, int voltagem) {

        super(nome, descricao, preco, quantidadeEstoque, fornecedor, categoria);

        this.marca = marca;
        this.modelo = modelo;
        this.garantiaMeses = garantiaMeses;
        this.voltagem = voltagem;
    }


    @Override
    public double calcularFrete() {
        if (getPreco() >= 5000.0)
            return 0.0;
        return 30.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMarca: " + marca +
                "\nModelo: " + modelo +
                "\nGarantia: " + garantiaMeses + " meses" +
                "\nVoltagem: " + voltagem + "V" +
                "\nFrete: R$ " + calcularFrete();
    }
}
