/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteMovimentacaoConta {
    
    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        Movimentacao movimentacao = em.find(Movimentacao.class, 2);
        Conta conta = movimentacao.getConta();
        
        System.out.println(conta.getTitular());
        
        System.out.println(conta.getMovimentacoes().size());
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
