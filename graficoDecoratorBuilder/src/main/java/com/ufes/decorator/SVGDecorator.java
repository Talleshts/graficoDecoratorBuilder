/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.decorator;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author tallesh
 */
public class SVGDecorator implements IGraficoDecorator{
    
     private String filePath;
     
      public SVGDecorator(String filePath) {
        this.filePath = filePath;
    }
      
    @Override
    public JFreeChart decorate(JFreeChart grafico) {
        //JFreeSVG.save(grafico, new File(filePath), 800, 600);
        return grafico;
    }
    
}
