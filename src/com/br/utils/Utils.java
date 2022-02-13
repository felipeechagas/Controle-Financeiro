/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.utils;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;

/**
 *
 * @author Felipe Chagas
 */
public class Utils {
    public static void maximizar(JDialog dialog){
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        screen = new Dimension((int) screen.getWidth(), (int) screen.getHeight() - 40);
        dialog.setSize(screen);
        dialog.setLocationRelativeTo(null);
    }
    
    public static String convertDouble(double valor){
        return new DecimalFormat("#0,00").format(valor);
    }
    
    public static String convertData(Date date){
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
