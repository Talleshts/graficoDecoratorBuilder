/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.builder;

import com.ufes.decorator.IGrafico;
import java.util.Map;

/**
 *
 * @author talle
 */
public class GraficoDiretor {
    
    private Map<String, Double> dadosListados;

    public GraficoDiretor(Map<String, Double> dadosListados) {
        this.dadosListados = dadosListados;
    }

    public IGrafico criar(GraficoBuilder builder) throws CloneNotSupportedException {
        builder.criaDados(dadosListados);
        builder.criaGrafico();
        builder.alteraOrientacao();
        builder.insereLegenda();
        return builder.getGrafico();
    }

    
}
