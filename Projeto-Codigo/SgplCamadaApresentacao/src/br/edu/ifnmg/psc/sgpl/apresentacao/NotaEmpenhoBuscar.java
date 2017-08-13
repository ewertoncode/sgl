/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.sgpl.apresentacao;

import br.edu.ifnmg.psc.sgpl.aplicacao.NotaEmpenho;
import br.edu.ifnmg.psc.sgpl.aplicacao.Pedido;
import br.edu.ifnmg.psc.sgpl.aplicacao.Repositorio;
import br.edu.ifnmg.psc.sgpl.persistencia.NotaEmpenhoDao;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ewertoncardoso
 */
public class NotaEmpenhoBuscar extends javax.swing.JInternalFrame {

    /**
     * Creates new form NotaEmpenhoBuscar
     */
    public NotaEmpenhoBuscar(Repositorio<NotaEmpenho> repositorio) {
        
        initComponents();
        List<NotaEmpenho> listagem = repositorio.Buscar(null);        
        preencheTabela(listagem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotas = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("SGPL - Notas de empenho");

        jLabel1.setText("Buscar por:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pago", "Não Pago" }));

        jButton1.setText("Buscar");

        tblNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblNotas);

        jButton2.setText("Marcar como pago");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            NotaEmpenhoDao notaEmpenhoDao = new NotaEmpenhoDao();
            
            NotaEmpenho notaEmpenho = notaEmpenhoDao.Abrir(retornaIdSelecionado());
            
            notaEmpenho.setPago(true);
            
            if(notaEmpenhoDao.Salvar(notaEmpenho)) {
                JOptionPane.showMessageDialog(rootPane, "Alterado com sucesso!");
                List<NotaEmpenho> listagem = notaEmpenhoDao.Buscar(null);        
                preencheTabela(listagem);
                
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaEmpenhoBuscar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(NotaEmpenhoBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNotas;
    // End of variables declaration//GEN-END:variables


    public int retornaIdSelecionado() {
        int linha = tblNotas.getSelectedRow();
        int id = Integer.parseInt( tblNotas.getModel().getValueAt(linha, 0).toString() );
        return id;
    }


    public void preencheFiltro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void preencheTabela(List<NotaEmpenho> listagem) {
        DefaultTableModel modelo = new DefaultTableModel();
        
        // Informa quais as colunas da tabela        
        modelo.addColumn("Id");        
        modelo.addColumn("Número da nota");               
        modelo.addColumn("Valor"); 
        modelo.addColumn("Pago?");   
        
        
        // Adiciona as linhas da tabela        
        for(NotaEmpenho n : listagem){                        
            
            Vector linha = new Vector();
            linha.add(n.getId());      
            linha.add(n.getNumeroNota());
            linha.add(n.getValor());
            
            String pago = "Não";
            
            if(n.isPago())
                pago = "Sim";
            
            linha.add(pago);
                                    
            modelo.addRow(linha);
        }
        
        tblNotas.setModel(modelo);    
    }
}
