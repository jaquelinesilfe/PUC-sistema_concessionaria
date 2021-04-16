package Negocio;

import Entidade.Cliente;
import Persistencia.ClienteDAO;
import java.util.ArrayList;

public class ClienteNegocio implements IClienteNegocio {

    private ClienteDAO clienteDAO;

    public ClienteNegocio() {
        clienteDAO = new ClienteDAO();
    }

    @Override
    public int inserirCliente(Cliente cliente) {
        return clienteDAO.inserirCliente(cliente);
    }

    @Override
    public ArrayList<Cliente> listaClienteTodos() {
        return clienteDAO.listaClienteTodos();
    }

    @Override
    public Cliente listaClientePorNome(String nome) {
        return clienteDAO.listaClientePorNome(nome);
    }

    @Override
    public boolean excluirCliente(int idCliente) {
        boolean resultado = false;
        
        resultado = clienteDAO.excluirCliente(idCliente);
        
        
        return resultado;
    }
}
