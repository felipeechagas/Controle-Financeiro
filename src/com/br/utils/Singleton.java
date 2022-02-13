/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 *Permitir o sistema estabelecer única conexão somente quando iniciar o sistema
 */
package com.br.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {
    
    private static EntityManager conection;
    private static EntityManagerFactory emf;

    /**
     * @return the conection
     */
    public static EntityManager getConection() {
        if(conection==null){
            setConection();
        }
        return conection;
    }

    /**Permite a aplicação estabelecer a conexão */
    public static void setConection() {
        emf = Persistence.createEntityManagerFactory("JPA");
        conection = emf.createEntityManager();
    }
}
