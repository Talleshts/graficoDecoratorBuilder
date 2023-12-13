package com.ufes.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**/
public final class GraficoView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public GraficoView() {
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2.8);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        this.setTitle("Gráfico");
        this.pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        decoratorsPanel = new javax.swing.JPanel();
        Titulo = new javax.swing.JCheckBox();
        legenda = new javax.swing.JCheckBox();
        eixos = new javax.swing.JCheckBox();
        rotulosProporcional = new javax.swing.JCheckBox();
        rotulosTotal = new javax.swing.JCheckBox();
        corBarrasGrupo = new javax.swing.JCheckBox();
        grade = new javax.swing.JCheckBox();
        rotulosTotalPercentual = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        comboBoxTipoBarra = new javax.swing.JComboBox<>();
        btnDesfazer = new javax.swing.JButton();
        btnRestaurarPadrao = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        decoratorsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elementos Gráficos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        decoratorsPanel.setPreferredSize(new java.awt.Dimension(250, 450));

        Titulo.setText("Título");

        legenda.setText("Legenda");

        eixos.setText("Título dos eixos");

        rotulosProporcional.setText("Rótulo de Dados (%)");

        rotulosTotal.setText("Rótulo de Dados - Valor");
        rotulosTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotulosTotalActionPerformed(evt);
            }
        });

        corBarrasGrupo.setText("Cor das Barras - Por grupo");

        grade.setText("Grade");
        grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeActionPerformed(evt);
            }
        });

        rotulosTotalPercentual.setText("Rótulo de Dados - Valor (%)");

        jLabel1.setText("Gráficos Padrão:");

        comboBoxTipoBarra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barras Verticais", "Barras Horizontais" }));

        javax.swing.GroupLayout decoratorsPanelLayout = new javax.swing.GroupLayout(decoratorsPanel);
        decoratorsPanel.setLayout(decoratorsPanelLayout);
        decoratorsPanelLayout.setHorizontalGroup(
            decoratorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoratorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(decoratorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(decoratorsPanelLayout.createSequentialGroup()
                        .addGroup(decoratorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotulosTotalPercentual)
                            .addComponent(Titulo)
                            .addComponent(legenda)
                            .addComponent(eixos)
                            .addComponent(rotulosProporcional)
                            .addComponent(rotulosTotal)
                            .addComponent(corBarrasGrupo)
                            .addComponent(grade))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(decoratorsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(comboBoxTipoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        decoratorsPanelLayout.setVerticalGroup(
            decoratorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decoratorsPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(legenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eixos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotulosProporcional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rotulosTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotulosTotalPercentual)
                .addGap(3, 3, 3)
                .addComponent(corBarrasGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(grade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(decoratorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxTipoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        getContentPane().add(decoratorsPanel);

        btnDesfazer.setText("Desfazer");
        btnDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesfazerActionPerformed(evt);
            }
        });
        getContentPane().add(btnDesfazer);

        btnRestaurarPadrao.setText("Restaurar Padrão");
        getContentPane().add(btnRestaurarPadrao);

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeActionPerformed

    private void btnDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesfazerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDesfazerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rotulosTotalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_rotulosTotalActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_rotulosTotalActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Titulo;
    private javax.swing.JButton btnDesfazer;
    private javax.swing.JButton btnRestaurarPadrao;
    private javax.swing.JComboBox<String> comboBoxTipoBarra;
    private javax.swing.JCheckBox corBarrasGrupo;
    private javax.swing.JPanel decoratorsPanel;
    private javax.swing.JCheckBox eixos;
    private javax.swing.JCheckBox grade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox legenda;
    private javax.swing.JCheckBox rotulosProporcional;
    private javax.swing.JCheckBox rotulosTotal;
    private javax.swing.JCheckBox rotulosTotalPercentual;
    // End of variables declaration//GEN-END:variables

    public JCheckBox getTitulo() {
        return Titulo;
    }

    public JCheckBox getCorBarrasGrupo() {
        return corBarrasGrupo;
    }

    public JPanel getDecoratorsPanel() {
        return decoratorsPanel;
    }

    public JCheckBox getEixos() {
        return eixos;
    }

    public JCheckBox getGrade() {
        return grade;
    }

    public JCheckBox getLegenda() {
        return legenda;
    }

    public JCheckBox getRotulosPercentual() {
        return rotulosProporcional;
    }

    public JCheckBox getRotulosTotal() {
        return rotulosTotal;
    }

    public JComboBox<String> getComboBoxTipoBarra() {
        return comboBoxTipoBarra;
    }

    public JButton getBtnDesfazer() {
        return btnDesfazer;
    }

    public JButton getBtnRestaurarPadrao() {
        return btnRestaurarPadrao;
    }

    public JCheckBox getRotulosTotalPercentual() {
        return rotulosTotalPercentual;
    }

    public void setTitulo(JCheckBox Titulo) {
        this.Titulo = Titulo;
    }

}
