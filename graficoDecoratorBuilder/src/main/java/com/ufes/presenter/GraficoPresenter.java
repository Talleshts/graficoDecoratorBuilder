package com.ufes.presenter;

import com.ufes.builder.GraficoBarraHorizontalBuilder;
import com.ufes.builder.GraficoBarraVerticalBuilder;
import com.ufes.builder.GraficoDiretor;
import com.ufes.decorator.rotulo.PercentualDecorator;
import com.ufes.decorator.rotulo.AnotacaoTotalDecorator;
import com.ufes.decorator.rotulo.AnotacaoTotalProporcionalDecorator;
import com.ufes.decorator.cor.CorBarrasDecorator;
import com.ufes.decorator.tituloEixos.EixosDecorator;
import com.ufes.decorator.GradesDecorator;
import com.ufes.decorator.LegendaDecorator;
import com.ufes.decorator.titulo.TituloDecorator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import com.ufes.decorator.IGrafico;
import com.ufes.decorator.OrientacaoDecorator;
import com.ufes.model.CarregaDadosModel;
import com.ufes.model.GraficoBarraModel;
import com.ufes.view.GraficoView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import org.jfree.chart.plot.PlotOrientation;

/**/
public final class GraficoPresenter {

    private GraficoView view;
    private IGrafico grafico;
    private JPanel painelGrafico;
    private int tipoGrafico;
    private CarregaDadosModel carregaDados;
    private GraficoDiretor diretor;

    public GraficoPresenter() throws CloneNotSupportedException, IOException {
        carregaDados = new CarregaDadosModel("src/main/java/com/ufes/db/pessoas.csv", ",", "sexo");
        view = new GraficoView();
        painelGrafico = new JPanel();
        view.add(painelGrafico);
        tipoGrafico = 0;
        plotaGraficoInicial();

        view.getTitulo().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addTitulo();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha:" + e.getMessage());
                }
            }
        });

        view.getLegenda().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addLegenda();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha:" + e.getMessage());
                }
            }
        });

        view.getEixos().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addTituloEixos();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha:" + e.getMessage());
                }
            }
        });
        view.getRotulosPercentual().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    addRotuloPercentual();
                    view.getRotulosTotal().setSelected(false);
                    view.getRotulosTotalPercentual().setSelected(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getRotulosTotal().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addRotuloTotal();
                    view.getRotulosPercentual().setSelected(false);
                    view.getRotulosTotalPercentual().setSelected(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getRotulosTotalPercentual().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {
                    addRotuloTotalPercential();
                    view.getRotulosPercentual().setSelected(false);
                    view.getRotulosTotal().setSelected(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }

            }
        });

        view.getCorBarrasGrupo().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addCores();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getGrade().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    addGrades();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });

        view.getComboBoxTipoBarra().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    acionaBuilder();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });
        view.getBtnDesfazer().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    desfazer();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }

            }
        });
        view.getBtnRestaurarPadrao().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnRestaurarPadrao();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha: " + e.getMessage());
                }
            }
        });
        adicionaNotificadores();

        view.setVisible(true);

    }

    private void adicionaNotificadores() {

        for (int i = 0; i < view.getDecoratorsPanel().getComponentCount(); i++) {
            if (view.getDecoratorsPanel().getComponent(i).toString().contains("JCheckBox")) {
                ((JCheckBox) view.getDecoratorsPanel().getComponent(i)).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent evt) {
                        try {
                            checkAcionado(((JCheckBox) evt.getSource()).getText());
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                    "Falha ao adicionar Checkbox ao Zelador: " + e.getMessage());
                        }
                    }
                });
            }
        }

    }

    private void checkAcionado(String nomeCheck) {

        for (int i = 0; i < view.getDecoratorsPanel().getComponentCount(); i++) {
            if (view.getDecoratorsPanel().getComponent(i).toString().contains("JCheckBox")) {
                if (view.getDecoratorsPanel().getComponent(i).toString().contains(nomeCheck)) {

                    Zelador.getInstance().addCheckeds(this.criaMemento());
                }
            }
        }
    }

    void restauraMemento(DesfazerMemento memento) {
        Map<String, Boolean> opcoes = memento.getOpcoes();

        for (int i = 0; i < view.getDecoratorsPanel().getComponentCount(); i++) {
            if (view.getDecoratorsPanel().getComponent(i).toString().contains("JCheckBox")) {

                String rotulo = ((JCheckBox) view.getDecoratorsPanel().getComponent(i)).getText();
                boolean selecionado = opcoes.get(rotulo);

                ((JCheckBox) view.getDecoratorsPanel().getComponent(i)).setSelected(selecionado);
            }
        }
    }

    DesfazerMemento criaMemento() {

        Map<String, Boolean> opcoes = new HashMap<>();

        for (int i = 0; i < view.getDecoratorsPanel().getComponentCount(); i++) {
            Component comp = view.getDecoratorsPanel().getComponent(i);

            if (comp.toString().contains("JCheckBox")) {
                String textoRotulo = ((JCheckBox) comp).getText();
                boolean selecionado = ((JCheckBox) comp).isSelected();
                opcoes.put(textoRotulo, selecionado);
            }
        }
        return new DesfazerMemento(opcoes);
    }

    private void plotaGraficoInicial() throws CloneNotSupportedException, IOException {

        diretor = new GraficoDiretor(carregaDados.getDadosListados());
        grafico = diretor.criar(new GraficoBarraVerticalBuilder());
        atualizaTela(grafico);
    }

    void atualizaTela(IGrafico grafico) {
        painelGrafico.removeAll();
        painelGrafico.add(new ChartPanel(grafico.getGrafico()));
        painelGrafico.updateUI();
        view.pack();
    }

    private void addTitulo() throws CloneNotSupportedException {
        grafico = new TituloDecorator(grafico, view.getTitulo().isSelected());

        atualizaTela(grafico);
    }

    private void addLegenda() throws CloneNotSupportedException {
        grafico = new LegendaDecorator(grafico, view.getLegenda().isSelected());

        atualizaTela(grafico);
    }

    private void setOrientacao(PlotOrientation orientacao) throws CloneNotSupportedException {
        grafico = new OrientacaoDecorator(grafico, orientacao);
        atualizaTela(grafico);
    }

    private void addTituloEixos() throws CloneNotSupportedException {
        grafico = new EixosDecorator(grafico, view.getEixos().isSelected());
        atualizaTela(grafico);
    }

    private void addGrades() throws CloneNotSupportedException {
        grafico = new GradesDecorator(grafico, view.getGrade().isSelected());
        atualizaTela(grafico);
    }

    private void addRotuloPercentual() throws CloneNotSupportedException {
        grafico = new PercentualDecorator(grafico, view.getRotulosPercentual().isSelected());
        atualizaTela(grafico);
    }

    private void addRotuloTotalPercential() throws CloneNotSupportedException {
        grafico = new AnotacaoTotalProporcionalDecorator(grafico, view.getRotulosTotalPercentual().isSelected());
        atualizaTela(grafico);

    }

    private void addRotuloTotal() throws CloneNotSupportedException {
        grafico = new AnotacaoTotalDecorator(grafico, view.getRotulosTotal().isSelected());
        atualizaTela(grafico);
    }

    private void addCores() throws CloneNotSupportedException {
        if (!view.getCorBarrasGrupo().isSelected()) {
            ArrayList<Color> cores = new ArrayList();
            cores.add(Color.decode(GraficoBarraModel.CORINICIAL1));
            cores.add(Color.decode(GraficoBarraModel.CORINICIAL2));
            grafico = new CorBarrasDecorator(grafico, cores);
        } else {
            grafico = new CorBarrasDecorator(grafico, null);
        }
        atualizaTela(grafico);

    }

    private void acionaBuilder() throws CloneNotSupportedException {
        int tipo = view.getComboBoxTipoBarra().getSelectedIndex();
        if (tipo != tipoGrafico) {
            tipoGrafico = tipo;
            painelGrafico.removeAll();
            if (tipo == 0) {
                this.grafico = diretor.criar(new GraficoBarraVerticalBuilder());
            } else {
                this.grafico = diretor.criar(new GraficoBarraHorizontalBuilder());
            }
            atualizaTela(grafico);
        }
    }

    private void desfazer() {
        grafico = grafico.remover();
        try {
            restauraMemento(Zelador.getInstance().getCheckeds());
        } catch (Exception e) {
        }

        atualizaTela(grafico);
    }

    private void btnRestaurarPadrao() throws CloneNotSupportedException, IOException {
        plotaGraficoInicial();
    }

    GraficoView getView() {
        return view;
    }

    void setGrafico(IGrafico grafico) {
        this.grafico = grafico;
    }

    IGrafico getGrafico() {
        return grafico;
    }

}
