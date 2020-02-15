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
public class TesteConta {
    
    public static void main(String[] args) {
        Conta conta = new Conta();
        
//        conta.setId(1);
//        conta.setTitular("Gustavo");
//        conta.setAgencia("12345-6");
//        conta.setBanco("NUBANK");
//        conta.setNumero("4567");
        
        EntityManager em = new JPAUtil().getEntityManager();
        
        
        em.getTransaction().begin();
        //em.persist(conta);
        
        //Agora vamos remover a conta
        
        conta = em.find(Conta.class, 1);
        em.remove(conta);
        
        ///////////////////////////////
        em.remove(conta);
        em.getTransaction().commit();
        
        em.close();
    }
    
}
