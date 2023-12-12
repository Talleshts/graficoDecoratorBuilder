/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import java.awt.Font;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;

/**
 *
 * @author tallesh
 */
public class TituloDecorator implements IGraficoDecorator{
    private String title;
    
    public TituloDecorator(String title) {
        this.title = title;
    }
    
    @Override
    public JFreeChart decorate(JFreeChart grafico) {
        grafico.setTitle(new TextTitle(title, new Font("SansSerif", Font.BOLD, 12)));
        return grafico;
    }
    
}
