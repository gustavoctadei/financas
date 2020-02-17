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
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteJPARelacionamento {
    
    public static void main(String[] args) {
        
        Conta conta = new Conta();
        conta.setAgencia("0102");
        conta.setBanco("Itau");
        conta.setNumero("1234");
        conta.setTitular("Leonardo");
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));
        
        movimentacao.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(conta);
        em.persist(movimentacao);
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
