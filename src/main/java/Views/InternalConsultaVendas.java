package Views;

import Entidade.Venda;
import Negocio.IVendaNegocio;
import Negocio.VendaNegocio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InternalConsultaVendas extends javax.swing.JInternalFrame {

    public InternalConsultaVendas() {
        initComponents();
        PopularJTable();
      
    }

     public void PopularJTable(){
         
         try {
            VendaNegocio vendanegocio = new VendaNegocio();
            ArrayList<Venda> listaVendas = vendanegocio.listaVendaTodos();
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            
             for (Venda venda : listaVendas) {
                 model.addRow(new Object[] 
                {
                   venda.getIdvenda(),
                   venda.getDatavenda(),
                   venda.getNomeVendedor(),
                   venda.getIdCliente(),
                   venda.getIdCliente()
                }); 

             }
              
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        ButtonExcluir = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Listagem Vendas Cadastradas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idvenda", "datavenda", "nomevendedor", "idcliente", "idveiculo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Deseja excluir cadastro? ");

        ButtonExcluir.setText("Excluir");
        ButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addComponent(ButtonExcluir)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ButtonExcluir))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirActionPerformed

        try {

            ((DefaultTableModel) jTable1.getModel()).removeRow(jTable1.getSelectedRow());

            String idExcluir = JOptionPane.showInputDialog("Confirme o ID do cliente que deseja Excluir!");
            int idVenda = Integer.parseInt(idExcluir);
            
            IVendaNegocio vendaNegocio = new VendaNegocio();
            boolean isSucesso = vendaNegocio.excluirVenda(idVenda);

            if(isSucesso) {
                JOptionPane.showMessageDialog(null, "Exclusão realizada com Sucesso!");
            }else {
                JOptionPane.showMessageDialog(null, "Exclusão Não Realizada!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_ButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
