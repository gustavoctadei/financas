/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class TesteTodasAsMovimentacoesDasContas {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        //String jpql = "select c from Conta c";
        
        //Com a consulta desta forma, a consulta traz as movimentações já carregadas dentro do objeto do classe Conta
        //String jpql = "select distinct c from Conta c join fetch c.movimentacoes ";
        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes ";
        Query query = em.createQuery(jpql);
        
        List<Conta> todasAsContas = query.getResultList();
        
        for (Conta c : todasAsContas) {
            System.out.println("Titular: " + c.getTitular());
            System.out.println("Movimentacoes: ");
            System.out.println(c.getMovimentacoes());
        }
        
        em.getTransaction().commit();
        em.close();
    }
    
}
