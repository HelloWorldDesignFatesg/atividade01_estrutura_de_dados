/*
 * Copyright (C) 2025 Spindola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Spindola
 */
public class LeitorArquivo implements ILeitorArquivo {

    @Override
    public String lerArquivo() {
        Stage stage = new Stage();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fc.showOpenDialog(stage);

        if (file != null) {
            String filePath = file.getAbsolutePath();
            System.out.println("Arquivo selecionado: " + filePath);

            try {
                String conteudo = Files.lines(Paths.get(filePath)).collect(Collectors.joining("\n"));
                return conteudo;
            } catch (IOException e) {
                e.printStackTrace();
                return "Erro ao ler o arquivo.";
            }
        } else {
            System.out.println("Nenhum arquivo foi selecionado.");
            return "Nenhum arquivo selecionado.";
        }
    }
    
    @Override
    public String lerStopwords(String caminho) {
        try {
            return Files.readString(Paths.get(caminho));
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
    }
}
