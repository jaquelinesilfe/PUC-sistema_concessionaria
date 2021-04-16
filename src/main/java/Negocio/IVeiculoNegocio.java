
package Negocio;

import Entidade.Veiculo;
import java.util.ArrayList;


public interface IVeiculoNegocio {
    int inserirVeiculo(Veiculo veiculo);
    ArrayList<Veiculo> listaVeiculoTodos();
    Veiculo listaVeiculoPorModelo(String modelo);
    boolean excluirVeiculo(int idVeiculo);

}
