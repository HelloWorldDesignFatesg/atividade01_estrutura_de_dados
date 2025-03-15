/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Spindola
 */
public class Palavras {
    private String texto;
    private Integer frequencia;

    public Palavras(String texto) {
        this.texto = texto;
        this.frequencia = 1; // Inicia com frequência 1
    }

    public void incrementarFrequencia() {
        this.frequencia++; // Incrementa a frequência
    }

    public String getTexto() {
        return texto;
    }

    public Integer getFrequencia() {
        return frequencia;
    }
}
