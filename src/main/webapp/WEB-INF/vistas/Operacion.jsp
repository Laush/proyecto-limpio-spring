<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

 <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<title>Operaci�n: ${operacionValida}</title>
				<h1>${operacionValida}</h1>
				<h2>El resultado de sumar ${operando1} y ${operando2} da ${resultado}</h2>
				
				<title>Error</title>
				<h1>Error: Operaci�n Inv�lida</h1>
				<h2>La operaci�n ${operacionInvalida} no es v�lida</h2>
				
<h3 class="form-signin-heading">Vista operacion</h3>
				
</body>
</html>