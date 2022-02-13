/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.telas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JWindow;

/**
 *
 * @author Felipe Chagas
 */
public class Progress {

    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    private javax.swing.JLabel labelMensagem;
    private String mensagem;
    private JWindow Jwindows;
    private JFrame jframe;
    private JDialog jdialog;

    Progress(JFrame jFrame, String aguarde_Inicializando_o_Sistema) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void Progress(JFrame jframe, String mensagem) {
        this.jframe = jframe;
        this.mensagem = mensagem;
        Jwindows = new JWindow(jframe);
    }

    public void Progress(JDialog jdialog, String mensagem) {
        this.jdialog = jdialog;
        this.mensagem = mensagem;
        Jwindows = new JWindow(jdialog);
    }

    public void gerarJanela() {
        jPanel1 = new javax.swing.JPanel();
        labelMensagem = new javax.swing.JLabel();
        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();

        labelMensagem.setText(mensagem);

        jXTitledSeparator1.setToolTipText("");
        jXTitledSeparator1.setTitle("");

        jProgressBar1.setIndeterminate(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelMensagem)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(labelMensagem)
                                .addGap(30, 30, 30)
                                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(48, Short.MAX_VALUE))
        );
        
        Jwindows.add(jPanel1);
        Jwindows.pack();
        if(jframe != null){
            Jwindows.setLocationRelativeTo(jframe);
        }
        if(jdialog != null){
            Jwindows.setLocationRelativeTo(jdialog);
        }
        Jwindows.setVisible(true);
    }

    public void fechar() {
        Jwindows.dispose();
    }
}
