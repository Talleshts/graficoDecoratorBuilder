/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ufes.presenter;

import com.ufes.model.GraficoModel;
import com.ufes.view.GraficoView;

/**
 *
 * @author tallesh
 */
public class GraficoPresenter {
    private GraficoModel model;
    private GraficoView view;

    public GraficoPresenter(GraficoModel model, GraficoView view) {
        this.model = model;
        this.view = view;
        view.display();
    }

    public void updateView() {
        view.repaint();
    }    
}
