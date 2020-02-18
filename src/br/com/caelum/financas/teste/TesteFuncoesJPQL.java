/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gustavo
 */
public class TesteFuncoesJPQL {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Conta conta = new Conta();
        conta.setId(2);
        
        //MovimentacaoDao dao = new MovimentacaoDao(em); //Sem usar namedQuery
        
////        String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" +
////                " and m.tipo = :pTipo";
////        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" +
////                " and m.tipo = :pTipo";
//        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta "
//                + "and m.tipo = :pTipo "
//                + "group by day(m.data), month(m.data), year(m.data)";
//        
//        //Query query = em.createQuery(jpql);
//        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
//        query.setParameter("pConta", conta);
//        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
//        
//        //BigDecimal valor = (BigDecimal) query.getSingleResult();
//        
//        List<Double> medias = (List<Double>) query.getResultList();
        
        
        //List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta); //Sem usar namedQuery
        
        TypedQuery typedQuery =  em.createNamedQuery("MediasPorDiaETipo", Double.class); //Usando namedQuery
        typedQuery.setParameter("pConta", conta);
        typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
        
        List<Double> medias = typedQuery.getResultList();
        

        //System.out.println("A soma é: " + valor);
        System.out.println("A média é: " + medias.get(0));
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
