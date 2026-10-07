package Domain;

public class Endereco {
    private String rua;
    private int numeroRua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;


    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroRua() {
        return numeroRua;
    }
    public void setNumeroRua(int numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public Endereco(String rua, int numeroRua, String complemento, String bairro, String cidade,
                    String estado, String cep){

        this.rua = rua;
        this.numeroRua = numeroRua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "\n" + bairro + " ---> " + rua + ", " + numeroRua + "- " + complemento +
                "\n" + estado + "-" + cidade +
                "\nCep: " + cep;
    }
}
