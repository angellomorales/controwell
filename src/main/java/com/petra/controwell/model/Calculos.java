package com.petra.controwell.model;

import javax.swing.JOptionPane;

import com.petra.controwell.model.data.Balance;

/**
 *
 * @author Angello Morales
 */
public class Calculos {

    private double balanceOil;
    private double balanceAgua;
    private double balanceDiluyente;
    private double balanceAguaDiluyente;
    private double totalNsv;
	private double totalAgua;
	private double totalNsvDiluyente;
	private double totalAguaDiluyente;
	
	

    public Calculos() {
		this.totalNsv = 0;
		this.totalAgua = 0;
		this.totalNsvDiluyente = 0;
		this.totalAguaDiluyente = 0;
	}

	public double formatearDecimales(double numero, Integer numeroDecimales) {
        return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
    }

//    Metodos anteriores para calcular con tablas de aforo en cm
//    public double calcularTOV(double decimal, double volumen, double incrementoSiguiente) {
//        double tov = decimal * 10 * incrementoSiguiente + volumen;
//        return tov;
//    }
//
//    public double calcularFW(double decimal, double volumen, double incrementoSiguiente) {
//        double fw = decimal * 10 * incrementoSiguiente + volumen;
//        return fw;
//    }

    public double calcularCtsh(double tempFluido, double tempAmbiente, double tempBase, String material) {
        double coefMaterial = 0;
        switch (material) {
            case "Mild Carbon":
                coefMaterial = 0.0000062;
                break;
            case "304 Stainless":
                coefMaterial = 0.0000096;
                break;
            case "316 Stainless":
                coefMaterial = 0.00000883;
                break;
            case "17-4PH Stainless":
                coefMaterial = 0.000006;
                break;
            case "N/A":
                coefMaterial = 1;
                break;
            default:
                throw new AssertionError();
        }
        double ctsh = formatearDecimales(1 + (2 * coefMaterial * (((formatearDecimales(((7 * tempFluido) + tempAmbiente) / 8, 0))) - tempBase)) + (Math.pow(coefMaterial, 2) * Math.pow(((formatearDecimales(((7 * tempFluido) + tempAmbiente) / 8, 0)) - tempAmbiente), 2)), 5);
        return ctsh;
    }

    public double calcularGOV(double tov, double fw, double ctsh) {
        double gov = 0;
        if (fw > 0) {
            if (tov >= fw) {
                gov = (tov - fw) * ctsh;
            } else {
                JOptionPane.showMessageDialog(null, "Revise los niveles ingresados");
            }
        } else {
            gov = tov * ctsh;
        }

        return gov;
    }

    public double calcularCTL(double api, double tempFluido, String tipoFluido) {
        double ctl = 0;
        double k0 = 0, k1 = 0, k2 = 0;
        //'CTL para crudo

        double RD = 141.5 / (api + 131.5); // gravedad especifica
        double d = RD * 999.016; // densidad en kg/m3

        if (tempFluido < -58 || tempFluido > 302) {
            JOptionPane.showMessageDialog(null, "Temperatura fuera de rango");
        } else {
            double d60 = d;
            if (d60 < 610.6 || d60 > 1163.5) {
                JOptionPane.showMessageDialog(null, "API fuera de rango");
            } else {
                //constantes K0, K1 y K2
                if (("crudo".equals(tipoFluido))) {
                    k0 = 341.0957;
                    k1 = 0;
                    k2 = 0;
                } else if (("lubricante".equals(tipoFluido))) {
                    k0 = 0;
                    k1 = 0.34878;
                    k2 = 0;
                } else if ((("refinado".equals(tipoFluido)) && (d60 < 770.352))) {
                    k0 = 192.4571;
                    k1 = 0.2438;
                    k2 = 0;
                } else if ((("refinado".equals(tipoFluido)) && (d60 < 787.5195))) {
                    k0 = 1489.067;
                    k1 = 0;
                    k2 = -0.0018684;
                } else if ((("refinado".equals(tipoFluido)) && (d60 < 838.3127))) {
                    k0 = 330.301;
                    k1 = 0;
                    k2 = 0;
                } else if ((("refinado".equals(tipoFluido)) && (d60 < 1163.5))) {
                    k0 = 103.872;
                    k1 = 0.2701;
                    k2 = 0;
                }
                double tC90 = (tempFluido - 32) / 1.8;//'conversion ITS80 to IPTS-68 Basis
                double r = tC90 / 630;
                double DT = (-0.148759 + (-0.267408 + (1.08076 + (1.269056 + (-4.089591 + (-1.871251 + (7.438081 + (-3.536296) * r) * r) * r) * r) * r) * r) * r) * r;
                double TC68 = tC90 - DT;
                double TF68 = TC68 * 1.8 + 32;
                double a = 0.01374979547 / 2 * ((k0 / d60 + k1) / d60 + k2);
                double b = (2 * k0 + k1 * d60) / (k0 + (k1 + k2 * d60) * d60);
                double dr = d60 * (1 + (Math.exp(a * (1 + 0.8 * a)) - 1) / (1 + a * (1 + 1.6 * a) * b));// ' densidad base convertida a IPTS-68 60'F  (kg/m3)
                double a60 = (k0 / dr + k1) / dr + k2;// 'Thermal expansion factor at 60'F
                double DTr = TF68 - 60.0068749;
                double vcfc = Math.exp(-a60 * DTr * (1 + 0.8 * a60 * (DTr + 0.01374979547)));// 'CTL
                ctl = formatearDecimales(vcfc, 5);
            }
        }
        return ctl;
    }

    public double calcularGSV(double gov, double ctl) {
        double gsv = gov * ctl;
        return gsv;
    }

    public double calcularCSW(double sYw) {
        double csw = (sYw >= 0 && sYw <= 100) ? formatearDecimales((1 - sYw / 100), 5) : 0;
        return csw;
    }

    public double calcularNSV(double csw, double gsv) {
        double nsv = formatearDecimales(gsv * csw, 2);
        return nsv;
    }

    public double calcularAgua(double csw, double gsv, double fw) {
        double agua = formatearDecimales(fw + gsv - (gsv * csw), 2);
        return agua;
    }

    public double getDecimal(double numero) {
        double decimal = numero % 1;
        return decimal;
    }

    public int getEntero(double numero) {
        int entero = (int) (numero - getDecimal(numero));
        return entero;
    }

    public double getBalanceOil() {
        return balanceOil;
    }

    public void setBalanceOil(double balanceOil) {
        this.balanceOil = balanceOil;
    }

    public double getBalanceAgua() {
        return balanceAgua;
    }

    public void setBalanceAgua(double balanceAgua) {
        this.balanceAgua = balanceAgua;
    }

    public double getBalanceDiluyente() {
        return balanceDiluyente;
    }

    public void setBalanceDiluyente(double balanceDiluyente) {
        this.balanceDiluyente = balanceDiluyente;
    }

    public double getBalanceAguaDiluyente() {
        return balanceAguaDiluyente;
    }

    public void setBalanceAguaDiluyente(double balanceAguaDiluyente) {
        this.balanceAguaDiluyente = balanceAguaDiluyente;
    }
    

    public double getTotalNsv() {
		return totalNsv;
	}

	public void setTotalNsv(double totalNsv) {
		this.totalNsv = totalNsv;
	}

	public double getTotalAgua() {
		return totalAgua;
	}

	public void setTotalAgua(double totalAgua) {
		this.totalAgua = totalAgua;
	}

	public double getTotalNsvDiluyente() {
		return totalNsvDiluyente;
	}

	public void setTotalNsvDiluyente(double totalNsvDiluyente) {
		this.totalNsvDiluyente = totalNsvDiluyente;
	}

	public double getTotalAguaDiluyente() {
		return totalAguaDiluyente;
	}

	public void setTotalAguaDiluyente(double totalAguaDiluyente) {
		this.totalAguaDiluyente = totalAguaDiluyente;
	}

	public boolean calcularBalance(Balance bal) {
        this.setBalanceOil(bal.getIniciales() + bal.getRecibo() - bal.getEntrega() - bal.getConsumo() - bal.getDrenaje() - bal.getFinales() - bal.getTransferencia() - bal.getInyeccion());
        this.setBalanceAgua(bal.getInicialesAgua() + bal.getReciboAgua() - bal.getEntregaAgua() - bal.getConsumoAgua() - bal.getDrenajeAgua() - bal.getFinalesAgua() - bal.getTransferenciaAgua() - bal.getInyeccionAgua());
        this.setBalanceDiluyente(bal.getInicialesDiluyente() + bal.getReciboDiluyente() - bal.getEntregaDiluyente() - bal.getConsumoDiluyente() - bal.getDrenajeDiluyente() - bal.getFinalesDiluyente() - bal.getTransferenciaDiluyente() - bal.getInyeccionDiluyente());
        this.setBalanceAguaDiluyente(bal.getInicialesAguaDiluyente() + bal.getReciboAguaDiluyente() - bal.getEntregaAguaDiluyente() - bal.getConsumoAguaDiluyente() - bal.getDrenajeAguaDiluyente() - bal.getFinalesAguaDiluyente() - bal.getTransferenciaAguaDiluyente() - bal.getInyeccionAguaDiluyente());
        this.setBalanceOil(this.formatearDecimales(this.getBalanceOil(), 2));
        this.setBalanceAgua(this.formatearDecimales(this.getBalanceAgua(), 2));
        this.setBalanceDiluyente(this.formatearDecimales(this.getBalanceDiluyente(), 2));
        this.setBalanceAguaDiluyente(this.formatearDecimales(this.getBalanceAguaDiluyente(), 2));
        return this.getBalanceOil() <= 0.5 && this.getBalanceAgua() <= 0.5 && this.getBalanceOil() >= -0.5 && this.getBalanceAgua() >= -0.5 && bal.getAceiteProducido() >= 0 && bal.getAguaProducida() >= 0 && this.getBalanceDiluyente() <= 0.5 && this.getBalanceAguaDiluyente() <= 0.5 && this.getBalanceDiluyente() >= -0.5 && this.getBalanceAguaDiluyente() >= -0.5;
    }

}
