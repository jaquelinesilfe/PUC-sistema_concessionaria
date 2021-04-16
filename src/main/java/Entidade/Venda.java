
package Entidade;

public class Venda {
    private int idVenda;
    private String numeroVenda;
    private String dataVenda;
    private String nomeVendedor;
    private int idCliente;
    private int idVeiculo;
    

    public int getIdvenda() {
        return idVenda;
    }

    public void setIdvenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNumerovenda() {
        return numeroVenda;
    }

    public void setNumerovenda(String numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    public String getDatavenda() {
        return dataVenda;
    }

    public void setDatavenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
}
