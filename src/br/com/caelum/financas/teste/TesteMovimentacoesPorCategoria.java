/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class TesteMovimentacoesPorCategoria {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Categoria categoria = new Categoria();
        categoria.setId(1);
        
        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
        
        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);
        
        List<Movimentacao> resultados = query.getResultList();
        
        for (Movimentacao m : resultados) {
            System.out.println("Descricao: " + m.getDescricao());
            System.out.println("Conta.id: " + m.getConta().getId());
            
        }
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
