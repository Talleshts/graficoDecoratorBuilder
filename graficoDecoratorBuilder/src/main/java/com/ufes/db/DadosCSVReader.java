
package com.ufes.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DadosCSVReader {

    private String filePath;

    public DadosCSVReader(String filePath) {
        this.filePath = filePath;  // Atualizando o membro filePath com o valor fornecido
    }

    public DadosCSVReader() {
        // Construtor padrão vazio
    }

    public List<String[]> lerDadosCSV() {
        try {
            if (filePath == null) {
                throw new IllegalArgumentException("O caminho do arquivo CSV não foi definido.");
            }

            return Files.lines(Paths.get(filePath))
                        .map(line -> line.split(","))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
