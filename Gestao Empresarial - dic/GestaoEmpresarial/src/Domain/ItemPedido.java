package Domain;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;
    private double subtotal;


    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
        calcularSubtotal();
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        calcularSubtotal();
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
        calcularSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }


    public ItemPedido() {
    }

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
        calcularSubtotal();
    }

    public double calcularSubtotal() {
        this.subtotal = precoUnitario * quantidade;
        return this.subtotal;
    }

    @Override
    public String toString() {
        return "\nProduto: " + produto.getNome() +
                "\nQuantidade: " + quantidade +
                "\nPreço unitário: R$ " + precoUnitario +
                "\nSubtotal: R$ " + subtotal;
    }
}
