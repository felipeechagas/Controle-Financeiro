/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.br.telas;

import com.br.dao.CategoriaDao;
import com.br.dao.MovimentacaoDao;
import com.br.entidades.Categoria;
import com.br.entidades.Movimentacao;
import com.br.utils.Msg;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe Chagas
 */
public class TelaMovimentacaoCadastro extends javax.swing.JDialog {

    /**
     * Creates new form TelaMovimentacaoCadastro
     */
    private boolean inserir;
    private boolean despesa;
    private Movimentacao movimentacao;
    private TelaMovimentacao pai;
    private List<Categoria> listaCategoria = new ArrayList<>();

    public TelaMovimentacaoCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        movimentacao = new Movimentacao();
        atualizaCombo();
    }

    public TelaMovimentacaoCadastro(TelaMovimentacao parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pai = parent;
        movimentacao = new Movimentacao();
        atualizaCombo();
    }
    
    protected void atualizaCombo(){
        try {
            cbCategoria.removeAllItems();
            cbCategoria.addItem("<Selecione>");
            if (isDespesa()){
                listaCategoria = new CategoriaDao().getListaFiltro("DESPESA");
            }else{
                listaCategoria = new CategoriaDao().getListaFiltro("RENDA");
            }
            
            for(Categoria c: listaCategoria){
                cbCategoria.addItem(c.getDescricao());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(this, "Erro ao atualizar combo Movimentacao!\nErro: "+e.getMessage());
        }
    }

    protected void preencherCampos(Movimentacao cat) {
        movimentacao = cat;
        txData.setDate(movimentacao.getData());
        txObservacao.setText(movimentacao.getObservacao());
        txValor.setText(movimentacao.getValor()+"");
        cbCategoria.setSelectedItem(movimentacao.getIdCategoria().getDescricao());
    }

    private Movimentacao getMovimentacao() {
        movimentacao.setData(txData.getDate());
        movimentacao.setDataCadastro(new Date());
        movimentacao.setIdCategoria(listaCategoria.get(cbCategoria.getSelectedIndex()-1));
        movimentacao.setObservacao(txObservacao.getText());
        movimentacao.setValor(Double.parseDouble(txValor.getText().replace(",", ".")));
        return movimentacao;
    }

    //Validar para não salvar em branco
    private boolean verificaCampos() {
        boolean verifica = false;
        String msg = "Campos Obrigatórios\n";
        if (txObservacao.getText().trim().equals("") || txObservacao.getText().isEmpty()) {
            verifica = true;
            msg += "Descrição: \n";
            txObservacao.requestFocus();
        }
        if (verifica) {
            Msg.erro(this, msg);
        }
        return verifica;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txObservacao = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txValor = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txData = new org.jdesktop.swingx.JXDatePicker();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Movimentação Cadastro");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/application_delete.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/br/imagens/accept.png"))); // NOI18N
        jButton3.setText("Salvar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        jLabel1.setText("Observação:");

        jLabel2.setText("Categoria:");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAGAR", "RECEBER", " " }));

        jLabel3.setText("Valor:");

        txValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txValor.setText("0,00");
        txValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txValorFocusGained(evt);
            }
        });
        txValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txValorMouseClicked(evt);
            }
        });

        jLabel4.setText("Data:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txValor, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txData, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txObservacao))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Botão Salvar:
        if (!verificaCampos()) {
            if (isInserir()) {
                new MovimentacaoDao().inserir(getMovimentacao());
                Msg.informacao(this, "Salvo com Sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            } else {
                new MovimentacaoDao().alterar(getMovimentacao());
                Msg.informacao(this, "Alterado com Sucesso!");
                this.pai.atualizaTabela();
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txValorFocusGained
        // TODO add your handling code here:
        txValor.selectAll();
    }//GEN-LAST:event_txValorFocusGained

    private void txValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txValorMouseClicked
        // TODO add your handling code here:
        txValor.selectAll();
    }//GEN-LAST:event_txValorMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMovimentacaoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaMovimentacaoCadastro dialog = new TelaMovimentacaoCadastro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXDatePicker txData;
    private javax.swing.JTextField txObservacao;
    private javax.swing.JFormattedTextField txValor;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the inserir
     */
    public boolean isInserir() {
        return inserir;
    }

    /**
     * @param inserir the inserir to set
     */
    public void setInserir(boolean inserir) {
        this.inserir = inserir;
    }

    /**
     * @return the despesa
     */
    public boolean isDespesa() {
        return despesa;
    }

    /**
     * @param despesa the despesa to set
     */
    public void setDespesa(boolean despesa) {
        this.despesa = despesa;
    }
}
