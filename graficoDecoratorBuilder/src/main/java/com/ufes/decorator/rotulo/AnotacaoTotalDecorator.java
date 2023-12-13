package com.ufes.decorator.rotulo;

import com.ufes.decorator.IGrafico;

/**/
public final class AnotacaoTotalDecorator extends RotuloDecorator {

    public AnotacaoTotalDecorator(IGrafico grafico, boolean visivel) throws CloneNotSupportedException {
        super(grafico, visivel);
        setAnotacoes(visivel);
    }

    @Override
    public void alteraRotulo(boolean visivel) {
        renderer.setBaseItemLabelGenerator(new TotalLabelGenerator(visivel));
    }

}
