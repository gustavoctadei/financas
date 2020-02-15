/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteBuscaConta {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        
        em.getTransaction().begin();
        
        //O método find traz o Objeto conta em estado Managed, ou seja, ele sincroniza e persiste automaticamente no banco
        //todas as alterações realizadas no Objeto
        Conta conta = em.find(Conta.class, 1);
        
        conta.setTitular("João");
        conta.setAgencia("45678-9");
        
        System.out.println(conta.getTitular());
        
        em.getTransaction().commit();
        em.close(); //Somente após fechar o EM que o Objeto pára de ser Managed
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        EntityManager em2 = new JPAUtil().getEntityManager();
        em2.getTransaction().begin();
        
        conta.setTitular("Gustavo"); //Neste momento, esta instância de conta é Detached, não Managed
        
        //em2.persist(conta); //Isso gerará uma exceção, visto que esta conta não está mais sendo Manageada pelo JPA
        
        em2.merge(conta); //Transformar a instância em Managed novamente
        
        em2.getTransaction().commit();
        em2.close();
    }
    
}
