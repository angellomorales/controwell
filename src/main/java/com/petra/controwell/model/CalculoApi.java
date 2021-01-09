/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petra.controwell.model;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author Angello Morales
 */
public class CalculoApi {

    double correccionAPI;

    /**
     * Definicion funcion calcular API corregido calcula el API corregido a la
     * temperatura dada
     *
     * @param k0 constante termino 1
     * @param k1 constante termino 1
     * @param apiI API observado
     * @param t Temperatura observada
     * @return Double API corregido
     */
    public double calcularAPI(double k0, double k1, double apiI, double t) {
        double api, deltaT, dt, hYc, rho60, rho = 0, term1, term2, term3, term4, a60, vcf60, rd;

        // Calculo de la funcion APIt
        // Redondeo de las variables de entrada
        apiI = (int) (((100 * apiI) + 5) / 10);
        apiI = apiI / 10;
        t = (int) (((100 * t) + 5) / 10);
        t = t / 10;

        // Calculo del Delta de Temperatura
        deltaT = (t - 60);

        // Conversion de la Gravedad APIt a Densidad en Kg/m3
        dt = (141.5 * (999.016 / (apiI + 131.5)));
        hYc = 1 - 0.00001278 * deltaT - 0.0000000062 * Math.pow(deltaT, 2);
        dt = (hYc * dt);

        // Inicializacion con d(60)=d(T)
        rho60 = dt;

        // Calculo iterativo de RHO(60)
        while (Math.abs(rho60 - rho) < 0.05 == false) {
            rho = rho60;

            // Calculo del Coeficiente de Expansion Termica, ALPHA(60)
            term1 = (k0 / rho);
            // MODIFICACION DE TERM1 = Int(100000000 * k0 / RHO) / 100000000
            term2 = (term1 / rho);
            // MODIFICACION DE Int(10000000000# * TERM1 / RHO) / 10000000000#
            term3 = (k1 / rho);
            a60 = (term2 + term3);
            // MODIFICACION DE a60 = Round(TERM2 + TERM3, 7)

            // Calculo del factor de correcci�n de volumen, VCF
            term1 = (a60 * deltaT);
            // MODIFICACION DE Int(100000000 * a60 * DELTAT) / 100000000
            term2 = (0.8 * term1);
            // MODIFICACION DE Int(100000000 * 0.8 * TERM1) / 100000000
            term3 = (term1 * term2);
            // MODIFICACION DE Round(TERM1 * TERM2, 8)
            term4 = -term1 - term3;
            vcf60 = Math.exp(term4);
            // MODIFICACION DE VCF60 = Round(Exp(TERM4), 6)
            rho60 = (dt / vcf60);
            // MODIFICACION DE Int(1000 * DT / VCF60)
            // MODIFICACION RHO60 = Round(RHO60, 2)
        }
        rd = (rho60 / 999.016);
        // MODIFICACION PARA GENERAR DENSIDAD RELATIVA @ 60
        api = (141.5 / rd) - 131.5;
        // MODIFICACION DE APIt = 141.5 * 999.016 / RHO60 - 131.5
        api = ((100 * api) + 5) / 10;
        BigDecimal bd = new BigDecimal(String.valueOf(api));
        BigDecimal iPart = new BigDecimal(bd.toBigInteger());
        api = iPart.doubleValue() / 10;
        return api;
    }

    public void setCorreccionAPI(double apiI, double T) {
        double k0, k1, api = 0;
        if ((T >= 0)) {
            if ((T >= 250)) {
                JOptionPane.showMessageDialog(null, "Temperatura fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
                api = 0;

                // Condicionales para determinar tabla a implementar
            } else if ((apiI >= 0)) {

                // Si la respuesta al condicional es afirmativa implementacion de tabla 5A
                if ((apiI <= 50)) {
                    // Definicion de las constantes
                    k0 = 341.0957;
                    k1 = 0;
                    api = this.calcularAPI(k0, k1, apiI, T);
                } else if ((T >= 200)) {
                    JOptionPane.showMessageDialog(null, "Temperatura fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
                    api = 0;
                } else if ((apiI <= 85)) {// Si la respuesta al condicional es afirmativa implementacion de tabla 5B

                    // Definicion de las constantes
                    k0 = 192.4571;
                    k1 = 0.2438;
                    api = this.calcularAPI(k0, k1, apiI, T);
                } else if ((apiI <= 100)) {// Si la respuesta al condicional es afirmativa implementar tabla 5A

                    k0 = 341.0957;
                    k1 = 0;
                    api = this.calcularAPI(k0, k1, apiI, T);
                } else {
                    JOptionPane.showMessageDialog(null, "Fuera de rango verificar API Leido", "Error", JOptionPane.ERROR_MESSAGE);
                    api = 0;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fuera de rango verificar API Leido", "Error", JOptionPane.ERROR_MESSAGE);
                api = 0;
            }
        }
        // Comprobacion de datos, condicionales para evitar valores negativos
        if (api <= 0) {
            JOptionPane.showMessageDialog(null, "Verificar datos", "Error", JOptionPane.ERROR_MESSAGE);
            this.correccionAPI = 0;
        }
        this.correccionAPI = api;
    }

    public double getCorreccionAPI() {
        return correccionAPI;
    }

}
