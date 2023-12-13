package com.ufes.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public final class CarregaDadosModel {

    private final String delimitador;
    private Map<String, Double> dadosListados = new LinkedHashMap<>();

    public CarregaDadosModel(String dadosCSV, String delimitador, String campoGrupo)
            throws FileNotFoundException, IOException {
        this.delimitador = delimitador;

        if (!dadosCSV.toLowerCase().endsWith(".csv")) {
            throw new IllegalArgumentException("Informe um arquivo .CSV");
        }

        FileInputStream inputStream = new FileInputStream(dadosCSV);
        Scanner sc = new Scanner(inputStream, "UTF-8");

        String cabecalho = sc.nextLine();

        if (!existeCampo(campoGrupo, cabecalho)) {
            throw new IllegalArgumentException("Campo inexistente neste arquivo!");
        }

        dadosListados.put("Solteiro,Masculino", 0.0);
        dadosListados.put("Casado,Masculino", 0.0);
        dadosListados.put("Solteiro,Feminino", 0.0);
        dadosListados.put("Casado,Feminino", 0.0);
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            if (linha.toLowerCase().contains("solteir") && linha.toLowerCase().contains("masculino")) {
                dadosListados.put("Solteiro,Masculino", dadosListados.get("Solteiro,Masculino") + 1);
            } else if (linha.toLowerCase().contains("casad") && linha.toLowerCase().contains("masculino")) {
                dadosListados.put("Casado,Masculino", dadosListados.get("Casado,Masculino") + 1);
            } else if (linha.toLowerCase().contains("solteir") && linha.toLowerCase().contains("feminino")) {
                dadosListados.put("Solteiro,Feminino", dadosListados.get("Solteiro,Feminino") + 1);
            } else if (linha.toLowerCase().contains("casad") && linha.toLowerCase().contains("feminino")) {
                dadosListados.put("Casado,Feminino", dadosListados.get("Casado,Feminino") + 1);
            }
        }
    }

    private boolean existeCampo(String campo, String cabecalho) {
        String[] camposCabecalho = cabecalho.split(delimitador);
        for (String campoCabelhado : camposCabecalho) {
            if (campo.toLowerCase().equals(campoCabelhado)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, Double> getDadosListados() {
        return dadosListados;
    }

}
