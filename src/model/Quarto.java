/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author julio.nogueira
 */
public class Quarto {
    private int idQuarto;
    private String descricaoQuarto;
    private int tipo;
    private int capacidade;

    /**
     * @return the idQuarto
     */
    public int getIdQuarto() {
        return idQuarto;
    }

    /**
     * @param idQuarto the idQuarto to set
     */
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    /**
     * @return the descricaoQuarto
     */
    public String getDescricaoQuarto() {
        return descricaoQuarto;
    }

    /**
     * @param descricaoQuarto the descricaoQuarto to set
     */
    public void setDescricaoQuarto(String descricaoQuarto) {
        this.descricaoQuarto = descricaoQuarto;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    
}
