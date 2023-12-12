/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.model;

import com.ufes.decorator.IGraficoDecorator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesh
 */
public class GraficoModel {
    private List<IGraficoDecorator> decorators = new ArrayList<>();
    private CategoryDataset dataset;

    public void setDataset(CategoryDataset dataset) {
        this.dataset = dataset;
    }

    public void addDecorator(IGraficoDecorator decorator) {
        decorators.add(decorator);
    }

    public JFreeChart getChart() {
        JFreeChart grafico = ChartFactory.createBarChart(
                "Bar Chart",
                "Category",
                "Value",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        for (IGraficoDecorator decorator : decorators) {
            grafico = decorator.decorate(grafico);
        }

        return grafico;
    }    
}
