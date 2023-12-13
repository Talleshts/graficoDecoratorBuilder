package com.ufes.presenter;

import java.util.Stack;

public class Zelador {

    private final Stack<DesfazerMemento> checkeds = new Stack<>();

    private static volatile Zelador instance;
    private static Object mutex = new Object();

    private Zelador() {
    }

    public void addCheckeds(DesfazerMemento memento) {
        checkeds.add(memento);
    }

    public DesfazerMemento getCheckeds() {
        return checkeds.pop();
    }

    public static Zelador getInstance() {
        Zelador result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new Zelador();
                }
            }
        }
        return result;
    }

}
