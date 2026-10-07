package Domain;

import java.time.LocalDate;

public class Gerente extends Funcionario{
    private int bonusEmPorcentagem;
    private String setor;


    public int getBonusEmPorcentagem() {
        return bonusEmPorcentagem;
    }
    public void setBonusEmPorcentagem(int bonusEmPorcentagem) {
        this.bonusEmPorcentagem = bonusEmPorcentagem;
    }

    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }


    public Gerente(){}

    public Gerente(String nomeCompleto, String cpf, String telefone, String email, Endereco endereco,
                   String matricula, double salarioBase, LocalDate dataContratacao,
                   int bonusEmPorcentagem, String setor){

        super(nomeCompleto, cpf, telefone, email, endereco, matricula, salarioBase, dataContratacao);

        this.bonusEmPorcentagem = bonusEmPorcentagem;
        this.setor = setor;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (getSalarioBase() * (bonusEmPorcentagem / 100.0));
    }

    /*public double aprovarPedido(Pedido pedido){
        pedido.setStatus(StatusPedido.APROVADO);
    }

    FAZER O GERAR RELATORIO DPS
    */

    @Override
    public String toString() {
        return super.toString() +
                "\nBônus: " + bonusEmPorcentagem + "%" +
                "\nSetor: " + setor;
    }
}
