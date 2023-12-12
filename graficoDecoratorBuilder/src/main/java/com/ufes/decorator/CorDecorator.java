/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import java.awt.Color;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;

/**
 *
 * @author tallesh
 */
public class CorDecorator implements  IGraficoDecorator{
    private final Color color;

    public CorDecorator(Color color) {
        this.color = color;
    }

    @Override
    public JFreeChart decorate(JFreeChart grafico) {
        CategoryPlot plot = (CategoryPlot) grafico.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, color);
        return grafico;
    }
    
}
