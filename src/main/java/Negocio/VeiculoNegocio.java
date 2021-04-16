
package Negocio;

import Entidade.Veiculo;
import Persistencia.VeiculoDAO;

import java.util.ArrayList;
    
    public class VeiculoNegocio implements IVeiculoNegocio{

    private VeiculoDAO veiculoDAO;

    public VeiculoNegocio() {
        veiculoDAO = new VeiculoDAO();
    
    }

    @Override
    public int inserirVeiculo(Veiculo veiculo) {
        return veiculoDAO.inserirVeiculo(veiculo);
    }

    @Override
    public ArrayList<Veiculo> listaVeiculoTodos() {
        return veiculoDAO.listaVeiculoTodos();
    }

    @Override
    public Veiculo listaVeiculoPorModelo(String modelo) {
        return veiculoDAO.listaVeiculoPorModelo(modelo);
    }

    @Override
    public boolean excluirVeiculo(int idVeiculo) {
        return veiculoDAO.excluirVeiculo(idVeiculo);
    }
    

}
