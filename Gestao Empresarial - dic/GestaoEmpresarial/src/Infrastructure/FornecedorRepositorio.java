package Infrastructure;

import Domain.Fornecedor;
import Exception.FornecedorNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class FornecedorRepositorio {
    HashMap<Integer, Fornecedor> dicFornecedor = new HashMap<>();

    public void adicionarFornecedor(Fornecedor fornecedor){dicFornecedor.put(fornecedor.getId(), fornecedor);}

    public boolean existeFornecedorPorID(int id){return dicFornecedor.containsKey(id);}

    public Fornecedor buscarFornecedorPorID(int id){return dicFornecedor.get(id);}

    public void removerFornecedor(int id){
        if (!existeFornecedorPorID(id))
            throw new FornecedorNaoEncontradoException("Fornecedor não encontrado!!! ");

        dicFornecedor.remove(id);
    }

    public boolean existeFornecedorPorCNPJ(String cnpj){return dicFornecedor.containsKey(cnpj);}

    public Fornecedor buscarFornecedorPorCNPJ(String cnpj){return dicFornecedor.get(cnpj);}

    public Map<Integer, Fornecedor> listarTodos(){
        return dicFornecedor;
    }
}
