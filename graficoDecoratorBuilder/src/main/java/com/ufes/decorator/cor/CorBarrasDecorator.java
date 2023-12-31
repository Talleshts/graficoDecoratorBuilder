package com.ufes.decorator.cor;

import com.ufes.decorator.GraficoDecorator;
import java.awt.Color;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;
import com.ufes.decorator.IGrafico;

/**/
public final class CorBarrasDecorator extends GraficoDecorator {

    public CorBarrasDecorator(IGrafico grafico, ArrayList<Color> cores) throws CloneNotSupportedException {
        super(grafico);
        setCores(cores);
    }

    public void setCores(ArrayList<Color> cores) throws CloneNotSupportedException {
        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();
        if (cores == null) {
            CoresPresenter coresPresenter = new CoresPresenter(elementoDecorado);
            cores = coresPresenter.getCores();
        }

        int i = 0;
        for (Color c : cores) {
            novoGrafico.getCategoryPlot().getRenderer().setSeriesPaint(i++, c);
        }

    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
