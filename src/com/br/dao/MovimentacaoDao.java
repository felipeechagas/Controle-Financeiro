/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.entidades.Movimentacao;
import com.br.utils.Singleton;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Desenvolvimento Classe Dao com metodos de conexão com o banco de dados
 * @author Felipe Chagas
 */
public class MovimentacaoDao {
    
    private EntityManager em;
    
    public MovimentacaoDao(){
        em = Singleton.getConection();
    }
    
    public void inserir(Movimentacao cat){
        em.getTransaction().begin(); /** inicia a transação */
        em.persist(cat);
        em.getTransaction().commit(); /** encerra a transação */
    }
    
    public void alterar(Movimentacao cat){
        em.getTransaction().begin(); /** inicia a transação */
        em.merge(cat);
        em.getTransaction().commit(); /** encerra a transação */
    }
    
    public void excluir(Movimentacao cat){
        em.getTransaction().begin(); /** inicia a transação */
        em.remove(cat);
        em.getTransaction().commit(); /** encerra a transação */
    }
    
    public List getLista(String cat){
        em.getTransaction().begin(); /** inicia a transação */
        Query query = em.createQuery("SELECT e FROM Movimentacao e ");
    //    Query query = em.createQuery("SELECT e FROM Movimentacao e where e.valor =:likes");
    //    query.setParameter("likes", "%" + cat.trim() + "%");
        List<Movimentacao> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
        
    }
    
    public List getListaData(String cat,Date data01, Date data02){
        em.getTransaction().begin(); /** inicia a transação */
        Query query = em.createQuery("SELECT e FROM Movimentacao e where e.data BETWEEN :data01 and data02");
    //    Query query = em.createQuery("SELECT e FROM Movimentacao e where e.valor =:likes");
    //    query.setParameter("likes", "%" + cat.trim() + "%");
    
        query.setParameter("data01", data01);
        query.setParameter("data02", data02);
        List<Movimentacao> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
        
    }
}
