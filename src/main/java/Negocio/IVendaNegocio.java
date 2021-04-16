
package Negocio;

import Entidade.Venda;
import java.util.ArrayList;

public interface IVendaNegocio {
    
    int inserirVenda(Venda venda);
    ArrayList<Venda> listaVendaTodos();
    Venda listaVendaPorId(int idVenda);
    boolean excluirVenda(int idVenda);

}
