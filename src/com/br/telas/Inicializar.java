/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.telas;

import com.br.utils.Msg;
import com.br.utils.Singleton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

/**
 *
 * @author Felipe Chagas
 */
public class Inicializar {
    
    private static Progress p;
    
    public static void main(String[] args) {
        
        try {
            
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new JFrame());
        } catch (Exception e) {
            e.printStackTrace();
            Msg.erro(null, "Erro ao Aplicar o Tema");
        }
        
        p = new Progress(new JFrame(), "Aguarde, Inicializando o Sistema!");
        
        SwingWorker worker = new SwingWorker(){
            @Override
            protected Object doInBackground() throws Exception{
                
                p.gerarJanela();
                Singleton.setConection();
                return null;
            }
            
            @Override
            protected void done(){
                p.fechar();
                new TelaPrincipal().setVisible(true);
            }
            
        };
        worker.execute();
        
    }
}
