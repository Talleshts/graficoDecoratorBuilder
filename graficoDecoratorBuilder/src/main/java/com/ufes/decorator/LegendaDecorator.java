package com.ufes.decorator;

import org.jfree.chart.JFreeChart;

/**/
public class LegendaDecorator extends GraficoDecorator {

    public LegendaDecorator(IGrafico grafico, boolean visivel) throws CloneNotSupportedException {
        super(grafico);
        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();
        novoGrafico.getLegend().setVisible(visivel);
    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
