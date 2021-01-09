
package com.petra.controwell.model;

/**
 *
 * @author Angello Morales
 */
public class UnidadesMedicion {
    private final String unidadPresion;
    private final String unidadCaudal;
    private final String unidadTemperatura;
    private final String unidadVolumen;
    private final String unidadPresionDif;
    private final String unidadCaudalGas;

    public UnidadesMedicion(String unidadPresion, String unidadCaudal, String unidadTemperatura, String unidadVolumen, String unidadPresionDif,String unidadCaudalGas) {
        this.unidadPresion = unidadPresion;
        this.unidadCaudal = unidadCaudal;
        this.unidadTemperatura = unidadTemperatura;
        this.unidadVolumen = unidadVolumen;
        this.unidadPresionDif=unidadPresionDif;
        this.unidadCaudalGas=unidadCaudalGas;
    }

    public String getUnidadPresion() {
        return unidadPresion;
    }

    public String getUnidadCaudal() {
        return unidadCaudal;
    }

    public String getUnidadTemperatura() {
        return unidadTemperatura;
    }

    public String getUnidadVolumen() {
        return unidadVolumen;
    }

    public String getUnidadPresionDif() {
        return unidadPresionDif;
    }

    public String getUnidadCaudalGas() {
        return unidadCaudalGas;
    }
    
}
