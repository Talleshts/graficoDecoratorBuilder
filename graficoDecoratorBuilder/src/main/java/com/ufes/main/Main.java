/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ufes.main;

import com.ufes.decorator.CorDecorator;
import com.ufes.decorator.SVGDecorator;
import com.ufes.decorator.TituloDecorator;
import com.ufes.model.GraficoModel;
import com.ufes.presenter.GraficoPresenter;
import com.ufes.view.GraficoView;
import java.awt.Color;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tallesh
 */
public class Main {

    public static void main(String[] args) {

        GraficoModel model = new GraficoModel();

        // Criar o decorador para o título
        TituloDecorator titleDecorator = new TituloDecorator("Customized Bar Chart");
        model.addDecorator(titleDecorator);

        // Criar o decorador para a cor
        CorDecorator colorDecorator = new CorDecorator(Color.blue);
        model.addDecorator(colorDecorator);

        // Criar o decorador para salvar em SVG
        SVGDecorator svgDecorator = new SVGDecorator("bar_chart.svg");
        model.addDecorator(svgDecorator);

        // Criar dados para o gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, "Category 1", "Series 1");
        dataset.addValue(4.0, "Category 2", "Series 1");
        dataset.addValue(3.0, "Category 3", "Series 1");
        dataset.addValue(5.0, "Category 4", "Series 1");

        model.setDataset(dataset);

        // Criar a visão
        GraficoView view = new GraficoView("Customized Bar Chart", model);

        // Criar o apresentador
        GraficoPresenter presenter = new GraficoPresenter(model, view);
    }
}
