/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
