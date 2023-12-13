package com.ufes.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class OrientacaoDecorator extends GraficoDecorator {

    public OrientacaoDecorator(IGrafico grafico, PlotOrientation orientacao) throws CloneNotSupportedException {
        super(grafico);
       if (elementoDecorado != null && elementoDecorado.getGrafico() != null) {
            novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();
            novoGrafico.getCategoryPlot().setOrientation(orientacao);
        } else {
            // Lide com o caso em que elementoDecorado é nulo ou seu gráfico é nulo
            // Lançar exceção, imprimir mensagem de erro ou tomar outra ação apropriada.
            throw new IllegalArgumentException("O elemento decorado ou seu gráfico é nulo");
        }
    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
