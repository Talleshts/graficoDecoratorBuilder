/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.view;

import com.ufes.model.GraficoModel;
import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author tallesh
 */
public class GraficoView extends ApplicationFrame {
     private GraficoModel model;
     
      public GraficoView(String title, GraficoModel model) {
        super(title);
        this.model = model;
        JFreeChart chart = model.getChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 370));
        setContentPane(chartPanel);
    }

    public void display() {
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }
}
