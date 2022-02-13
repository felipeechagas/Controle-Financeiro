/*
 *
 *
 */
package com.br.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * Classe de Mensagens para feedback do que está acontecendo no sistema
 * @author Felipe Chagas
 */
public class Msg {
    
    public static void alert(Component frame, String msg){
        JOptionPane.showMessageDialog(frame, msg,"Alerta",JOptionPane.WARNING_MESSAGE);
    }
    
    public static void informacao(Component frame, String msg){
        JOptionPane.showMessageDialog(frame, msg,"Informação",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void erro(Component frame, String msg){
        JOptionPane.showMessageDialog(frame, msg,"Erro",JOptionPane.ERROR_MESSAGE);
    }
    
    public static boolean confirmar(Component frame, String msg){
        Object[] options = {"Sim", "Não"};
        int option = JOptionPane.showOptionDialog(frame, msg,"CONFIRMAR",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if (option == JOptionPane.YES_OPTION){
            return true;
        } else{
            return false;
        }
    }
}
