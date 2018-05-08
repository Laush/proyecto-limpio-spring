package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControladorTpPunto5{/*
	
	//http://localhost:8080/proyecto-limpio-spring/operacion/sumar/operador1/4/operador2/5
	@RequestMapping(value="/Operacion/{operacion}/operador1/{operador1}/operador2/{operador2}",method=RequestMethod.GET)
	public ModelAndView irAlaVistaOperacion (@PathVariable String operacion,@PathVariable Integer operador1,@PathVariable Integer operador2) {
				
		switch (operacion) {
			case "sumar": 
				ModelMap model = new ModelMap();
				model.put("valor1", operador1);
				model.put("valor2", operador2);
				return new ModelAndView ("sumar",model);
					
			case "restar":
				ModelMap model2 = new ModelMap();
				model2.put("valor1", operador1);
				model2.put("valor2", operador2);
				return new ModelAndView ("restar",model2);
								
			case "dividir":
				if(operador2!=0) {
					ModelMap model3 = new ModelMap();
					model3.put("valor1", operador1);
					model3.put("valor2", operador2);
					
					return new ModelAndView ("dividir",model3);
				}else {
					String msj2 = "El operador2 no debe ser 0";
					ModelMap errorDiv = new ModelMap();
					errorDiv.put("errorDiv", msj2);
					
					return new ModelAndView ("dividir",errorDiv);
				}
				
			case "multiplicar":
				ModelMap model4 = new ModelMap();
				model4.put("valor1", operador1);
				model4.put("valor2", operador2);
				return new ModelAndView ("multiplicar",model4);
			}
				
				
			String error = "Debe ingresar una operacion valida ";
				
			ModelMap modelError = new ModelMap();
			modelError.put("msj", error);
			
			return new ModelAndView ("error",modelError);
	
		}
	
	/*
	@RequestMapping(path = "/redirect", method = RequestMethod.GET)
	public ModelAndView irARedirect() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("redirect",modelo);
	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView redireccionar() {
				
		return new ModelAndView(new RedirectView("redirect") ) ; // (vista,mapa)

	}
	*/	

}