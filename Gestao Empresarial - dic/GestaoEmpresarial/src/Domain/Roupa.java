package Domain;

public class Roupa extends Produto{
    private String tamanho;
    private String cor;
    private String material;


    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }


    public Roupa() {
    }

    public Roupa(String nome, String descricao, double preco, int quantidadeEstoque, Fornecedor fornecedor,
                 CategoriaProduto categoria, String tamanho, String cor, String material) {

        super(nome, descricao, preco, quantidadeEstoque, fornecedor, categoria);

        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }


    @Override
    public double calcularFrete() {
        if (getPreco() > 300)
            return 0.0;
        return 15.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTamanho: " + tamanho +
                "\nCor: " + cor +
                "\nMaterial: " + material +
                "\nFrete: R$ " + calcularFrete();
    }
}
