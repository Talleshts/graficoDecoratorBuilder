package com.ufes.decorator;

import org.jfree.chart.JFreeChart;

/**/
public class GradesDecorator extends GraficoDecorator {

    public GradesDecorator(IGrafico grafico, boolean gridlines) throws CloneNotSupportedException {
        super(grafico);
        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();

        novoGrafico.getCategoryPlot().setDomainGridlinesVisible(gridlines);
        novoGrafico.getCategoryPlot().setRangeGridlinesVisible(gridlines);
    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
