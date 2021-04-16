package Views;


import Entidade.Veiculo;
import Negocio.IVeiculoNegocio;
import Negocio.VeiculoNegocio;
import Negocio.VendaNegocio;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InternalConsultaVeiculos extends javax.swing.JInternalFrame {

    public InternalConsultaVeiculos() {
        initComponents();
        PopularJTable();
      
    }

     public void PopularJTable(){
         
         try {
            VeiculoNegocio veiculonegocio = new VeiculoNegocio();
            ArrayList<Veiculo> listaVeiculo = veiculonegocio.listaVeiculoTodos();
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);
            
             for (Veiculo veiculo : listaVeiculo) {
                 model.addRow(new Object[] 
                {
                   veiculo.getIdveiculo(),
                   veiculo.getModeloVeiculo(),
                   veiculo.getFabricanteVeiculo(),
                   veiculo.getDataLancamento(),
                   veiculo.getNumeroPlaca(),
                   veiculo.getCorVeiculo()
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
        jLabel1.setText("Listagem Veiculos Cadastrados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idveiculo", "modelo", "fabricante", "datalancamento", "numeroplaca", "cor"
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
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addComponent(ButtonExcluir)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ButtonExcluir))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirActionPerformed

        try {

            ((DefaultTableModel) jTable1.getModel()).removeRow(jTable1.getSelectedRow());

            String idExcluir = JOptionPane.showInputDialog("Confirme o ID do cliente que deseja Excluir!");
            int idVeiculo = Integer.parseInt(idExcluir);
            
            IVeiculoNegocio veiculoNegocio = new VeiculoNegocio();

            boolean isSucesso = veiculoNegocio.excluirVeiculo(idVeiculo);

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
