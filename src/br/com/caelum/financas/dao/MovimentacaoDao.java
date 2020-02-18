/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gustavo
 */
public class MovimentacaoDao {
    
    private EntityManager em;

    public MovimentacaoDao(EntityManager em) {
        this.em = em;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipo, Conta conta) {
        String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta "
                + "and m.tipo = :pTipo "
                + "group by day(m.data), month(m.data), year(m.data)";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        
        List<Double> medias = (List<Double>) query.getResultList();
        return medias;
    }

}
