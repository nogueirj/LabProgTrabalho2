/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author julio.nogueira
 */
public class Perfil {
    private int idPerfil;
    private String desPerfil;
    private boolean status;
    private int idPermissao;

    /**
     * @return the idPerfil
     */
    public int getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @return the desPerfil
     */
    public String getDesPerfil() {
        return desPerfil;
    }

    /**
     * @param desPerfil the desPerfil to set
     */
    public void setDesPerfil(String desPerfil) {
        this.desPerfil = desPerfil;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the idPermissao
     */
    public int getIdPermissao() {
        return idPermissao;
    }

    /**
     * @param idPermissao the idPermissao to set
     */
    public void setIdPermissao(int idPermissao) {
        this.idPermissao = idPermissao;
    }
    
    
}
