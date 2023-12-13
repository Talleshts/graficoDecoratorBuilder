package com.ufes.builder;

import com.ufes.decorator.LegendaDecorator;
import com.ufes.decorator.OrientacaoDecorator;
import org.jfree.chart.plot.PlotOrientation;

public class GraficoBarraVerticalBuilder extends GraficoBuilder {

    @Override
    public void alteraOrientacao() throws CloneNotSupportedException {
        grafico = new OrientacaoDecorator(grafico, PlotOrientation.VERTICAL);
    }

    @Override
    public void insereLegenda() throws CloneNotSupportedException {
        grafico = new LegendaDecorator(grafico, true);
    }

}
