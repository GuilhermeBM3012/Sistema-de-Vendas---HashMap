package Domain;

import Exception.EnderecoInvalidoException;

public class Fornecedor {
    private static int proximoId = 1;

    private int id;
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;
    private String email;
    private Endereco endereco;


    public int getId() {
        return id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public Fornecedor() {
        this.id = proximoId++;
    }

    public Fornecedor(String nomeEmpresa, String cnpj, String telefone, String email, Endereco endereco) {
        this.id = proximoId++;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }


    public void alterarEndereco(Endereco novoEndereco) {
        if (novoEndereco == null) {
            throw new EnderecoInvalidoException("O endereço não pode ser nulo.");
        }
        this.endereco = novoEndereco;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome da Empresa: " + nomeEmpresa +
                "\nCNPJ: " + cnpj +
                "\nTelefone: " + telefone +
                "\nEmail: " + email +
                "\nEndereço: " + endereco;
    }
}
