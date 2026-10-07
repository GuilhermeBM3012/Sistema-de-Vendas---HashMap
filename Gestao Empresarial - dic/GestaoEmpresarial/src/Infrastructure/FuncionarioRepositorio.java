package Infrastructure;

import Domain.Funcionario;
import Exception.FuncionarioNaoEncontradoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuncionarioRepositorio {
    HashMap<Integer, Funcionario> dicFuncionario = new HashMap<>();

    public void adicionarFuncionario(Funcionario funcionario){dicFuncionario.put(funcionario.getId(), funcionario);}

    public boolean existeFuncionarioPorID(int id){return dicFuncionario.containsKey(id);}

    public Funcionario buscarFuncionarioPorID(int id){return dicFuncionario.get(id);}

    public void removerFuncionario(int id){
        if (!existeFuncionarioPorID(id))
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado!!! ");

        dicFuncionario.remove(id);
    }

    public boolean existeFuncionarioPorMatricula(String matricula){return dicFuncionario.containsKey(matricula);}

    public Funcionario buscarFuncionarioPorMatricula(String matricula){return dicFuncionario.get(matricula);}

    public List<Funcionario> buscarFuncionariosPorFaixaSalarial(double salarioMinimo, double salarioMaximo) {
        List<Funcionario> funcionariosEncontrados = new ArrayList<>();

        for (Funcionario funcionario : dicFuncionario.values()) {
            if (funcionario.getSalarioBase() >= salarioMinimo && funcionario.getSalarioBase() <= salarioMaximo)
                funcionariosEncontrados.add(funcionario);
        }

        return funcionariosEncontrados;
    }

    public List<Funcionario> buscarFuncionariosPorNome(String nome) {
        List<Funcionario> funcionariosEncontrados = new ArrayList<>();

        for (Funcionario funcionario : dicFuncionario.values()) {
            if (funcionario.getNomeCompleto().toLowerCase().contains(nome.toLowerCase()))
                funcionariosEncontrados.add(funcionario);
        }

        return funcionariosEncontrados;
    }

    public Map<Integer, Funcionario> listarTodos(){
        return dicFuncionario;
    }
}
