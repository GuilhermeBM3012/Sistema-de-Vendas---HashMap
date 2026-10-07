package Infrastructure;

import Domain.Cliente;
import Exception.ClienteNaoEncontradoException;

import java.util.HashMap;
import java.util.Map;

public class ClienteRepositorio {
    HashMap<Integer, Cliente> dicCliente = new HashMap<>();

    public void adicionarCliente(Cliente cliente){dicCliente.put(cliente.getId(), cliente);}

    public boolean exiteClientePorID(int id){return dicCliente.containsKey(id);}

    public Cliente buscarClientePorID(int id){return dicCliente.get(id);}

    public void removerCliente(int id){
        if (!exiteClientePorID(id))
            throw new ClienteNaoEncontradoException("Cliente não encontrado !!!");

        dicCliente.remove(id);
    }

    public boolean exiteClientePorCPF(String cpf){return dicCliente.containsKey(cpf);}

    public Cliente buscarClientePorCpf(String cpf){return dicCliente.get(cpf);}

    public void listarTodos(){
        for (Map.Entry<Integer, Cliente> cli : dicCliente.entrySet()){
            System.out.println(cli.getKey() + " = " + cli.getValue());
        }
    }
}
