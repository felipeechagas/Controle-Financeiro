/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.entidades.Categoria;
import com.br.utils.Singleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Desenvolvimento Classe Dao com metodos de conexão com o banco de dados
 * @author Felipe Chagas
 */
public class CategoriaDao {
    
    private EntityManager em;
    
    public CategoriaDao(){
        em = Singleton.getConection();
    }
    
    public void inserir(Categoria cat){
        em.getTransaction().begin(); /** inicia a transação */
        em.persist(cat);
        em.getTransaction().commit(); /** encerra a transação */
    }
    
    public void alterar(Categoria cat){
        em.getTransaction().begin(); /** inicia a transação */
        em.merge(cat);
        em.getTransaction().commit(); /** encerra a transação */
    }
    
    public void excluir(Categoria cat){
        em.getTransaction().begin(); /** inicia a transação */
        em.remove(cat);
        em.getTransaction().commit(); /** encerra a transação */
    }
    
    public List getLista(String cat){
        em.getTransaction().begin(); /** inicia a transação */
        Query query = em.createQuery("SELECT e FROM categoria e where e.descricao LIKE:likes");
        query.setParameter("likes", "%" + cat.trim() + "%");
        List<Categoria> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }
    
    public List getListaFiltro(String cat){
        em.getTransaction().begin(); /** inicia a transação */
        Query query = em.createQuery("SELECT e FROM categoria e where e.tipo =:likes");
        query.setParameter("likes",cat);
        List<Categoria> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }
}
