package Views;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidade.Cliente;
import Entidade.Veiculo;
import Entidade.Venda;
import Negocio.ClienteNegocio;
import Negocio.IClienteNegocio;
import Negocio.IVeiculoNegocio;
import Negocio.IVendaNegocio;
import Negocio.VeiculoNegocio;
import Negocio.VendaNegocio;

public class InternalVendaVeiculo extends javax.swing.JInternalFrame {

    public InternalVendaVeiculo() {
        initComponents();
        FieldDataVenda.setText("");
        FieldNomeVendedor.setText("");
        
        IClienteNegocio clienteNegocio = new ClienteNegocio();
        ArrayList<Cliente> listaCliente = clienteNegocio.listaClienteTodos();
        
        ComboBoxCliente.addItem("");
        
        for (Cliente cliente : listaCliente) {
        	ComboBoxCliente.addItem(cliente.getIdCliente() + " | " + cliente.getNome());
		}
        
        
        IVeiculoNegocio veiculoNegocio = new VeiculoNegocio();
        ArrayList<Veiculo> listaVeiculo = veiculoNegocio.listaVeiculoTodos();
        
        ComboBoxVeiculo.addItem("");
        
        for (Veiculo veiculo : listaVeiculo) {
        	ComboBoxVeiculo.addItem(veiculo.getIdveiculo() + " | " + veiculo.getModeloVeiculo());
		}
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        FieldDataVenda = new javax.swing.JTextField();
        FieldNomeVendedor = new javax.swing.JTextField();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        ComboBoxVeiculo = new javax.swing.JComboBox<>();
        btSalvar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Venda Veículo");

        jLabel2.setText("Data Venda");

        jLabel3.setText("Cliente");

        jLabel4.setText("Vendedor");

        jLabel5.setText("Veiculo");

        FieldDataVenda.setText("dd/mm/aa");

        FieldNomeVendedor.setText("Digite o vendedor");

        ComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboBoxVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(FieldDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addComponent(FieldNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btSalvar)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(FieldDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FieldNomeVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboBoxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btSalvar)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
        if(FieldDataVenda.getText() == "" || FieldNomeVendedor.getText() == "") {
        	
        	JOptionPane.showMessageDialog(null, "Informar campos data da venda e nome do vendedor");
        }
        else 
        {
        	Venda venda = new Venda();
        	venda.setDatavenda(FieldDataVenda.getText());
            venda.setNomeVendedor(FieldNomeVendedor.getText());
            //ComboBoxVeiculo.getSelectedItem().toString();
            
            String [] arrayCliente = new String[2];
            arrayCliente = ComboBoxCliente.getSelectedItem().toString().split("|");
            venda.setIdCliente(Integer.parseInt(arrayCliente[0]));

            
            String [] arrayVeiculo = new String[2];
            arrayVeiculo = ComboBoxVeiculo.getSelectedItem().toString().split("|");
            venda.setIdVeiculo(Integer.parseInt(arrayVeiculo[0]));
            
            
            
            //Salvar
            
            IVendaNegocio vendaNegocio = new VendaNegocio();
            boolean isSucesso = vendaNegocio.inserirVenda(venda) == 1 ? true: false;
            
            if(isSucesso) {
            	JOptionPane.showMessageDialog(null, "Venda Cadastrada com Sucesso!");
            	FieldDataVenda.setText("");
            	FieldNomeVendedor.setText("");
            	
            	 IClienteNegocio clienteNegocio = new ClienteNegocio();
                 ArrayList<Cliente> listaCliente = clienteNegocio.listaClienteTodos();
                 
                 ComboBoxCliente.addItem("");
                 
                 for (Cliente cliente : listaCliente) {
                 	ComboBoxCliente.addItem(cliente.getIdCliente() + " | " + cliente.getNome());
         		}
                 
                 
                 IVeiculoNegocio veiculoNegocio = new VeiculoNegocio();
                 ArrayList<Veiculo> listaVeiculo = veiculoNegocio.listaVeiculoTodos();
                 
                 ComboBoxVeiculo.addItem("");
                 
                 for (Veiculo veiculo : listaVeiculo) {
                 	ComboBoxVeiculo.addItem(veiculo.getIdveiculo() + " | " + veiculo.getModeloVeiculo());
         		}
                 
            	
            }else {
            	JOptionPane.showMessageDialog(null, "Venda Não Cadastrada!");
            }
           
		}

    }//GEN-LAST:event_btSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCliente;
    private javax.swing.JComboBox<String> ComboBoxVeiculo;
    private javax.swing.JTextField FieldDataVenda;
    private javax.swing.JTextField FieldNomeVendedor;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
