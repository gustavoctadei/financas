/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.util;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class PopulaMovimentacoesComCategoria {

    public static void main(String[] args) {

//        Categoria categoria1 = new Categoria("Viagem");
//        Categoria categoria2 = new Categoria("Negocios");
        Conta conta = new Conta();
        conta.setId(2);
//        
//        Movimentacao movimentacao1 = new Movimentacao();
//        movimentacao1.setData(Calendar.getInstance());
//        movimentacao1.setDescricao("Viagem à SP");
//        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
//        movimentacao1.setValor(new BigDecimal("100.0"));
//        movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
        Movimentacao movimentacao1 = new Movimentacao();
        movimentacao1.setData(Calendar.getInstance());
        movimentacao1.setDescricao("Restaurante");
        movimentacao1.setTipo(TipoMovimentacao.SAIDA);
        movimentacao1.setValor(new BigDecimal("80.0"));
//        movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao1.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();

        Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 3);

        movimentacao2.setData(Calendar.getInstance());
        movimentacao2.setDescricao("Cinema");
        movimentacao2.setTipo(TipoMovimentacao.SAIDA);
        movimentacao2.setValor(new BigDecimal("100.0"));
        //movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao2.setConta(conta);

        Movimentacao movimentacao3 = new Movimentacao();

        amanha.add(Calendar.DAY_OF_MONTH, 5);

        movimentacao3.setData(Calendar.getInstance());
        movimentacao3.setDescricao("Café da Manhã");
        movimentacao3.setTipo(TipoMovimentacao.SAIDA);
        movimentacao3.setValor(new BigDecimal("40.0"));
        //movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao3.setConta(conta);

        Movimentacao movimentacao4 = new Movimentacao();

        //Calendar amanha = Calendar.getInstance();
        amanha.add(Calendar.DAY_OF_MONTH, 2);

        movimentacao4.setData(Calendar.getInstance());
        movimentacao4.setDescricao("Lanche");
        movimentacao4.setTipo(TipoMovimentacao.SAIDA);
        movimentacao4.setValor(new BigDecimal("20.0"));
        //movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));

        movimentacao4.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(movimentacao1);
        em.persist(movimentacao2);
        em.persist(movimentacao3);
        em.persist(movimentacao4);

        em.getTransaction().commit();
        em.close();

    }

}
