package Domain;

import Exception.QuantidadeInvalidaException;

public abstract class Produto {
    private static int proximoId = 1;

    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int qtdEmEstoque;
    private Fornecedor fornecedor;
    private CategoriaProduto categoria;


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEmEstoque() {
        return qtdEmEstoque;
    }
    public void setQtdEmEstoque(int qtdEmEstoque) {
        this.qtdEmEstoque = qtdEmEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }
    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public Produto(){this.id = proximoId++;}

    public Produto(String nome, String descricao, double preco, int qtdEmEstoque,
                   Fornecedor fornecedor, CategoriaProduto categoria){

        this.id = proximoId++;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEmEstoque = qtdEmEstoque;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
    }


    public void adicionarNoEstoque(int quantidade) {
        qtdEmEstoque += quantidade;
    }

    public void removerDoEstoque(int quantidade) {
        if (quantidade > qtdEmEstoque) {
            throw new QuantidadeInvalidaException("Quantidade insuficiente em estoque");
        }
        qtdEmEstoque -= quantidade;
    }

    public abstract double calcularFrete();

    @Override
    public String toString() {
        return "Id: " + id +
                "\nNome: " + nome +
                "\nDescrição: " + descricao +
                "\nPreco: R$" + preco +
                "Quantidade em Estoque: " + qtdEmEstoque +
                "\nFornecedor: " + fornecedor;
    }
}
