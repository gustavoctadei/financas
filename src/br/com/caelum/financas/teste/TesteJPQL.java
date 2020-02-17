/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Gustavo
 */
public class TesteJPQL {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Conta conta = new Conta();
        conta.setId(2);
        
        String jpql = "select m from Movimentacao m where m.conta = :pConta" +
                " and m.tipo = :pTipo" +
                " order by m.valor desc";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
        
        List<Movimentacao> resultados = query.getResultList();
        
        for (Movimentacao m : resultados) {
            System.out.println("Descricao: " + m.getDescricao());
            System.out.println("Conta.id: " + m.getConta().getId());
            
        }
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
