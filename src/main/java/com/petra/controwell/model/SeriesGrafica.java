
package com.petra.controwell.model;

/**
 *
 * @author Lenovo
 */
public class SeriesGrafica {
    private String nombreColumnaBD;
    private String nombreSerie;
    private boolean ejePrincipal;
    
    public static final boolean EJE_PRINCIPAL=true;
    public static final boolean EJE_SECUNDARIO=false;

    public SeriesGrafica(String nombreColumnaBD, String nombreSerie, boolean eje) {
        this.nombreColumnaBD = nombreColumnaBD;
        this.nombreSerie = nombreSerie;
        this.ejePrincipal = eje;
    }

    public String getNombreColumnaBD() {
        return nombreColumnaBD;
    }

    public void setNombreColumnaBD(String nombreColumnaBD) {
        this.nombreColumnaBD = nombreColumnaBD;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public boolean isEjePrincipal() {
        return ejePrincipal;
    }

    public void setEjePrincipal(boolean ejePrincipal) {
        this.ejePrincipal = ejePrincipal;
    }
    
    
    
    
    
    
}
