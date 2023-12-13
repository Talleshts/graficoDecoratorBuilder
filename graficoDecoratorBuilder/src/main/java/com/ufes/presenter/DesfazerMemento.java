package com.ufes.presenter;

import java.util.HashMap;
import java.util.Map;

public class DesfazerMemento {

    private Map<String, Boolean> opcoes = new HashMap<>();

    DesfazerMemento(Map<String, Boolean> opcoes) {
        this.opcoes = opcoes;
    }

    Map<String, Boolean> getOpcoes() {
        return opcoes;
    }

}