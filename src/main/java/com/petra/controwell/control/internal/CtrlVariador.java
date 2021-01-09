package com.petra.controwell.control.internal;

import com.petra.controwell.model.data.Variador;
import com.petra.controwell.model.data.querys.ConsultasVariador;
import com.petra.controwell.model.utilities.Utilities;

public class CtrlVariador {
	 //vista

    //modelo BD
    public Variador variador;
    public ConsultasVariador variadorC;

    //modelo
    //controlador
    public Utilities ctrlUtilities;
    //variables

	public CtrlVariador(Variador variador, ConsultasVariador variadorC, Utilities ctrlUtilities) {
		this.variador = variador;
		this.variadorC = variadorC;
		this.ctrlUtilities = ctrlUtilities;
	}
    
    

}
