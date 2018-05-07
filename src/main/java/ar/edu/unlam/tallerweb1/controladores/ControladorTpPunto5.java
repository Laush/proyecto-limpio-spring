package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ControladorTpPunto5{
	
	
		@RequestMapping(value="/tpPunto5/primerOperando/{3}/segundoOperando/{6}",method=RequestMethod.GET)
		public ModelAndView irAlaVistaOperacion(
				@PathVariable("primerOperando") int operando1,
				@PathVariable("segundoOperando") int operando2,
		        @PathVariable("resultadoOperacion") String resultado){
			
			//String message="El resultado de sumar," + operando1 +"y" +operando2 + "da" + resultado;
			
			// resolucion con las operaciones
			switch () {
 			case "sumar": 
 						ModelMap  model=new ModelMap();
 						model.put("resultadoOperacion",resultado);
 						model.put("primerOperando",operando1);
 						model.put("segundoOperando",operando2);
 						//Integer r=operando1+operando2;
 						//model.put("res", r);
					
			return new ModelAndView ("mensajeOperacion",model);
			return new ModelAndView ("sumar",model);
			
 			case "restar": 
					ModelMap  model2=new ModelMap();
					model.put("resultadoOperacion",resultado);
					model.put("primerOperando",operando1);
					model.put("segundoOperando",operando2);
					//Integer r=operando1-operando2;
					//model.put("res", r);
			
			return new ModelAndView ("mensajeOperacion",model2);
			return new ModelAndView ("restar",model2);
		
 			case "dividir": 
 				if(operando2!=0) {
				ModelMap  model3=new ModelMap();
				model.put("resultadoOperacion",resultado);
				model.put("primerOperando",operando1);
				model.put("segundoOperando",operando2);
				//Integer r=operando1/operando2;
				//model.put("res", r);
		
				return new ModelAndView ("mensajeOperacion",model3);
				return new ModelAndView ("dividir",model3);
			} else{
				    String msj2 = "El operador2 no debe ser 0";
					ModelMap errorDiv = new ModelMap();
					errorDiv.put("errorDiv", msj2);
		        
		           }
 				
 			case "multiplicar": 
						ModelMap  model4=new ModelMap();
						model.put("resultadoOperacion",resultado);
						model.put("primerOperando",operando1);
						model.put("segundoOperando",operando2);
						//Integer r=operando1*operando2;
						//model.put("res", r);
				
		return new ModelAndView ("mensajeOperacion",model4);
		return new ModelAndView ("multiplicar",model4);
      }
					
   }

}		