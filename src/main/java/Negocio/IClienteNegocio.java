
package Negocio;

import Entidade.Cliente;
import java.util.ArrayList;


public interface IClienteNegocio {
    int inserirCliente(Cliente cliente);
    ArrayList<Cliente> listaClienteTodos();
    Cliente listaClientePorNome(String nome);
    boolean excluirCliente(int idCliente);
}
