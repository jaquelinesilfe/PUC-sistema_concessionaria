
package Persistencia;

import Entidade.Veiculo;
import java.sql.*;
import java.util.ArrayList;


public class VeiculoDAO {

	private ConexaoBD conexao;
	
	public VeiculoDAO() {
		conexao = new ConexaoBD();
	}
	
    public int inserirVeiculo(Veiculo veiculo) {
    	int isSucesso = 0;
    	
    	try{
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO veiculo(modelo, fabricante, datalancamento, numeroplaca, cor, ativo) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, veiculo.getModeloVeiculo());
            ps.setString(2, veiculo.getFabricanteVeiculo());
            ps.setString(3, veiculo.getDataLancamento());
            ps.setString(4, veiculo.getNumeroPlaca());
            ps.setString(5, veiculo.getCorVeiculo());
            ps.setInt(6, 1);
            
            System.out.println(sql);
            
            isSucesso = ps.executeUpdate();
            
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
      return isSucesso;
    }

    public ArrayList<Veiculo> listaVeiculoTodos() {
    	
    	ArrayList<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
    	
        try {
        	String sql = "select * from veiculo where ativo = 1";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ResultSet resultado = ps.executeQuery();
        	
        	while(resultado.next()) {
        		Veiculo veiculo = new Veiculo();
        		veiculo.setIdveiculo(resultado.getInt("idveiculo"));
        		veiculo.setCorVeiculo(resultado.getString("cor"));
        		veiculo.setDataLancamento(resultado.getString("datalancamento"));
        		veiculo.setFabricanteVeiculo(resultado.getString("fabricante"));
        		veiculo.setModeloVeiculo(resultado.getString("modelo"));
        		veiculo.setNumeroPlaca(resultado.getString("numeroplaca"));
        		
        		listaVeiculo.add(veiculo);
        	}
        	
        	connection.close();
        	
        }catch(Exception erro) {
        	System.out.println("Erro durante listagem de dados!" + erro.getMessage());
        }
        
        return listaVeiculo;
    }

    public Veiculo listaVeiculoPorModelo(String modelo) {
        
	Veiculo veiculo = new Veiculo();
	    	
	        try {
	        	String sql = "select * from veiculo where modelo = and ativo = 1?";
	        	Connection connection = conexao.getConnection();
	        	PreparedStatement ps = connection.prepareStatement(sql);
	        	ps.setString(1, modelo);
	        	ResultSet resultado = ps.executeQuery();
	        	
	        	if(resultado.next()) {
	        		veiculo.setIdveiculo(resultado.getInt("idveiculo"));
	        		veiculo.setModeloVeiculo(resultado.getString("modelo"));
	        		veiculo.setFabricanteVeiculo(resultado.getString("fabricante"));
	        		veiculo.setDataLancamento(resultado.getString("datalancamento"));
	        		veiculo.setNumeroPlaca(resultado.getString("numeroplaca"));
	        		veiculo.setCorVeiculo(resultado.getString("cor"));
	        	}
	        	
	        	connection.close();
	        	
	        }catch (Exception e) {
	        	System.out.println("Erro durante listagem de dados!" + e.getMessage());
	        }
	        
	        return veiculo;
	    }
    

    public boolean excluirVeiculo(int idVeiculo) {
    	
    	try {
            
        	Connection connection = conexao.getConnection();
            String sql = "update veiculo set veiculo = 0 where idveiculo = ?";
            //String sql = "delete from cliente where idcliente = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idVeiculo);
            
            ps.execute();
            
            connection.close();
        	
        } catch (Exception e) {
            System.out.println("Erro durante a exclusão de dados!!!");
        }
        
        return true;
    }
    
}
