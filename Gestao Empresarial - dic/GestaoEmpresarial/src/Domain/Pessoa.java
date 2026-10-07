package Domain;

import Exception.EnderecoInvalidoException;
import Exception.TelefoneInvalidoException;

public class Pessoa {
    private static int proximoId = 1;

    private int id;
    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private String email;
    private Endereco endereco;


    public int getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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


    public Pessoa(){this.id = proximoId++;}

    public Pessoa(String nomeCompleto, String cpf, String telefone, String email, Endereco endereco){
        this.id = proximoId ++;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }


    public void atualizarEndereco(int id, Endereco novoEndereco){
        /*TER FUNÇÃO PARA BUSCAR A PESSOA POR ID*/

        if (novoEndereco == null) {
            throw new EnderecoInvalidoException("O endereço não pode estar vazio!!");
        }

        this.endereco = novoEndereco;
    }

    public void atualizarTelefone(int id, String novoTelefone){
        /*TER FUNÇÃO PARA BUSCAR A PESSOA POR ID*/

        if (novoTelefone == null || novoTelefone.isBlank()){
            throw new TelefoneInvalidoException("O telefone não pode estar vazio!!!");
        }

    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ID: " + id +
                "\nNome Completo: " + nomeCompleto +
                "\nCpf:" + cpf + "\nTelefone: " + telefone +
                "\nEmail: " + email + "\nEndereco: " + endereco;
    }
}
