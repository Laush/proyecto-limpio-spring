package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorOperacion {
	
	//http://localhost:8080/proyecto-limpio-spring/operacion/sumar/2/8
	@RequestMapping("/operacion/{operacionDeseada}/{primerOperando}/{segundoOperando}")
	public ModelAndView realizarOperacion(@PathVariable("operacionDeseada") String operacionDeseada, 
									@PathVariable("primerOperando") Integer primerOperando, 
									@PathVariable("segundoOperando") Integer segundoOperando) {
		
		ModelMap modelo = new ModelMap();
		modelo.put("operacionDeseada", operacionDeseada);
		modelo.put("primerOperando", primerOperando);
		modelo.put("segundoOperando", segundoOperando);
		
		//suma
		if(operacionDeseada.equalsIgnoreCase("sumar")) {
			Integer resultado = primerOperando + segundoOperando;
			modelo.put("resultado", resultado);
			return new ModelAndView("resultado-operacion", modelo);
		}
		//multiplicacion
		if(operacionDeseada.equalsIgnoreCase("multiplicar")) {
			Integer resultado = primerOperando * segundoOperando;
			modelo.put("resultado", resultado);
			return new ModelAndView("resultado-operacion", modelo);
		}
        //resta
		if(operacionDeseada.equalsIgnoreCase("restar")) {
			Integer resultado = primerOperando - segundoOperando;
			modelo.put("resultado", resultado);
			return new ModelAndView("resultado-operacion", modelo);
		}
		//division
		if(operacionDeseada.equalsIgnoreCase("dividir") & segundoOperando!=0) {
			Integer resultado = primerOperando / segundoOperando;
			modelo.put("resultado", resultado);
			return new ModelAndView("resultado-operacion", modelo);
		} //si el segundo operando es cero da el mismo error que si la operacion fuera incorrecta
		
		
		//Si la operación indicada no existe, muestro pantalla de error
		return new ModelAndView("error", modelo);
}
	

}
