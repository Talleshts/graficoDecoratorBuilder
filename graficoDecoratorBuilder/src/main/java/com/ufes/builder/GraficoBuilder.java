/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.builder;

import com.ufes.decorator.IGrafico;
import com.ufes.decorator.rotulo.AnotacaoTotalDecorator;
import com.ufes.model.GraficoBarraModel;
import java.util.ArrayList;
import java.util.Map;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author talle
 */
public abstract class GraficoBuilder {
    protected IGrafico grafico;
    protected DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public final void criaDados(Map<String, Double> dadosSumarizados) {
        ArrayList<String> categorias = new ArrayList<>(dadosSumarizados.keySet());

        for (int i = 0; i < categorias.size(); i++) {
            dataset.addValue(dadosSumarizados.get(categorias.get(i)), categorias.get(i).split(",")[0], categorias.get(i).split(",")[1]);
        }
    }

    public final void criaGrafico() throws CloneNotSupportedException {
        grafico = new GraficoBarraModel(dataset);
        grafico = new AnotacaoTotalDecorator(grafico, true);
    }

    public abstract void alteraOrientacao() throws CloneNotSupportedException;
    public abstract void insereLegenda() throws CloneNotSupportedException;

    public final IGrafico getGrafico() {
        return grafico;
    }
}
