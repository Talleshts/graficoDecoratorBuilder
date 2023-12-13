package com.ufes.decorator.tituloEixos;

import com.ufes.decorator.GraficoDecorator;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import com.ufes.decorator.IGrafico;

/**/
public class EixosDecorator extends GraficoDecorator {

    public EixosDecorator(IGrafico grafico, boolean comEixos) throws CloneNotSupportedException {
        super(grafico);
        novoGrafico = (JFreeChart) elementoDecorado.getGrafico().clone();
        CategoryPlot plot = novoGrafico.getCategoryPlot();

        if (!comEixos) {
            plot.getDomainAxis().setLabel("");
            plot.getRangeAxis().setLabel("");
        } else {
            EixosPresenter eixoPresenter = new EixosPresenter(grafico);
            plot.getDomainAxis().setLabel(eixoPresenter.getEixoX());
            plot.getRangeAxis().setLabel(eixoPresenter.getEixoY());
        }

    }

    @Override
    public JFreeChart getGrafico() {
        return novoGrafico;
    }

}
