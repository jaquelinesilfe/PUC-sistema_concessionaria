
package Persistencia;

import Entidade.Venda;
import java.sql.*;
import java.util.ArrayList;


public class VendaDAO {
	
	private ConexaoBD conexao;
	
	public VendaDAO() {
		conexao = new ConexaoBD();
	}

    public int inserirVenda(Venda venda) {
    	
    	int isSucesso = 0;
    	
    	try{
            Connection connection = conexao.getConnection();
            
            String sql = "INSERT INTO venda(datavenda, nomevendedor, idcliente, idveiculo) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, venda.getDatavenda());
            ps.setString(2, venda.getNomeVendedor());
            ps.setInt(3, venda.getIdCliente());
            ps.setInt(4, venda.getIdVeiculo());
            
            System.out.println(sql);
            
            isSucesso = ps.executeUpdate();
            
            connection.close();
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
      return isSucesso;
        
    }

    public ArrayList<Venda> listaVendaTodos() {
        
    	ArrayList<Venda> listaVenda = new ArrayList<Venda>();
    	
        try {
        	String sql = "select * from venda";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ResultSet resultado = ps.executeQuery();
        	
        	while(resultado.next()) {
        		Venda venda = new Venda();
        		venda.setDatavenda(resultado.getString("datavenda"));
        		venda.setNomeVendedor(resultado.getString("nomevendedor"));
        		venda.setIdCliente(resultado.getInt("idcliente"));
        		venda.setIdVeiculo(resultado.getInt("idveiculo"));
        		venda.setIdvenda(resultado.getInt("idvenda"));
        		
        		listaVenda.add(venda);
        	}
        	
        	connection.close();
        	
        }catch(Exception erro) {
        	System.out.println("Erro durante listagem de dados!" + erro.getMessage());
        }
        
        return listaVenda;
    }

    public Venda listaVendaPorId(int idVenda) {
    	
    	Venda venda = new Venda();
    	
        try {
        	String sql = "select * from venda where idVenda = ?";
        	Connection connection = conexao.getConnection();
        	PreparedStatement ps = connection.prepareStatement(sql);
        	ps.setInt(1, idVenda);
        	ResultSet resultado = ps.executeQuery();
        	
        	if(resultado.next()) {
        		venda.setIdvenda(resultado.getInt("idvenda"));
        		venda.setDatavenda(resultado.getString("datavenda"));
        		venda.setNomeVendedor(resultado.getString("nomevendedor"));
        		venda.setIdCliente(resultado.getInt("idcliente"));
        		venda.setIdVeiculo(resultado.getInt("idveiculo"));
        		
        	}
        	
        	connection.close();
        	
        }catch (Exception e) {
        	System.out.println("Erro durante listagem de dados!" + e.getMessage());
        }
        
        return venda;
    }

    public boolean excluirVenda(int idVenda) {
    	
    	try {
            
        	Connection connection = conexao.getConnection();
            String sql = "delete from venda where idVenda = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idVenda);
            
            ps.execute();
            
            connection.close();
        	
        } catch (Exception e) {
            System.out.println("Erro durante a exclusão de dados!!!");
        }
        
        return true;
    }

}
