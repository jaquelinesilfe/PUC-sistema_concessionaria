
package Negocio;

import Entidade.Venda;
import Persistencia.VendaDAO;
import java.util.ArrayList;

public class VendaNegocio implements IVendaNegocio {
    
    private VendaDAO vendaDAO;
    
    public VendaNegocio() {
        vendaDAO = new VendaDAO();
    }
  

    @Override
    public int inserirVenda(Venda venda) {
    	return vendaDAO.inserirVenda(venda);
    }

    @Override
    public ArrayList<Venda> listaVendaTodos() {
    	return vendaDAO.listaVendaTodos();
    }

    @Override
    public Venda listaVendaPorId(int idVenda) {
        return vendaDAO.listaVendaPorId(idVenda);
    }

    @Override
    public boolean excluirVenda(int idVenda) {
        return vendaDAO.excluirVenda(idVenda);
    }

}
