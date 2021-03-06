package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void pruebaConexion() {
		assertThat(getSession().isConnected()).isTrue();
	}

	/* 12-4-18 */
	@Test
	@Transactional
	@Rollback(false)
	public void agregarUsuario() {

		Usuario usuario = new Usuario();
		usuario.setEmail("laush_x4@hotmail.com");
		getSession().save(usuario);

		Usuario usuarioNuevo = getSession().get(Usuario.class, 1L);

		assertThat(usuarioNuevo.getId()).isEqualTo(1L);
		System.out.println("El usuario tiene id ------" + usuarioNuevo.getEmail());
	}

	@Test // agregamos una calle y numero
	@Transactional
	@Rollback(false)
	public void agregarDireccion() {

		Direccion dir = new Direccion();
		dir.setCalle("ocampo");
		dir.setNumero("2020");
		getSession().save(dir);

		Direccion dirNuevo = getSession().get(Direccion.class, 1L);

		assertThat(dirNuevo.getId()).isEqualTo(1L);
		System.out.println("Id ------" + dirNuevo.getId());
		System.out.println("La direccion es ------" + dirNuevo.getCalle());
		System.out.println("numero ------" + dirNuevo.getNumero());
	}
/*
	@Test // agregar farmacias
	@Transactional
	@Rollback(false)
	public void agregarFarmacia() {
		Farmacia far = new Farmacia();
		far.setNombre("Pigmento");
		far.setTelefono("44612323");
		far.setDiaDeTurno("Martes");
		getSession().save(far);
		Farmacia farNuevo = getSession().get(Farmacia.class, 1L);
		assertThat(farNuevo.getId()).isEqualTo(1L);
		System.out.println("Id ------" + farNuevo.getId());
		System.out.println("El nombre es ------" + farNuevo.getNombre());
		System.out.println("El telefono es ------" + farNuevo.getTelefono());
		System.out.println("Dia de turno: ------" + farNuevo.getDiaDeTurno());
	}
*/
	//Punto 2::buscar todas las farmacias de turno los dias martes
	
	@Test 
    @Transactional @Rollback(false) 
	@SuppressWarnings("unchecked")
    public void todasLasFarmaciasConDiadeTurnoLosMartes(){
    	
    	Farmacia far1 = new Farmacia();
    	far1.setNombre("Pigmento");
    	far1.setDiaDeTurno("Martes");
    	getSession().save(far1);
    	
    	Farmacia far2 = new Farmacia();
    	far2.setNombre("FArmacity");
    	far2.setDiaDeTurno("Martes");
    	getSession().save(far2);
   
    	
      	Farmacia far3 = new Farmacia();
    	far3.setNombre("Vilelas");
    	far3.setDiaDeTurno("Viernes");
    	getSession().save(far3);
    		
    	Session session=getSession(); 
    	
    	List<Farmacia> lista=
    	session.createCriteria(Farmacia.class) //seria como el from
        .add(Restrictions.eq("diaDeTurno","Martes")) //seria como el where
        .list();
    	
    	System.out.println("<<Punto 2>>" );
    	for(Farmacia far4:lista){
     //comparar con un assert that k todos sean martes  		
    	System.out.println("Farmacia: "+ far4.getNombre() + " Dia de turno:" + far4.getDiaDeTurno());	
   	
    	}
     
    }

	//Punto 3 - listar todas las farmacias de una calle
	@Test 
    @Transactional @Rollback(false) 
	@SuppressWarnings("unchecked")
    public void todasLasFarmaciasDeUnaCalle(){
    	
		//creo las farmacias y las direcciones
    	Farmacia far1 = new Farmacia();
    	far1.setNombre("Pigmento");
    	
    	Farmacia far2 = new Farmacia();
    	far2.setNombre("Vilela");
    			
    	Direccion dir1= new Direccion();
    	dir1.setCalle("ocampo");
    	
    	Direccion dir2= new Direccion();
    	dir2.setCalle("peru");
    	Session session=getSession(); 
    	 
    	far1.setDireccion(dir1);
    	far2.setDireccion(dir2);
 	
    	session.save(far1);
    	session.save(far2);	
    	session.save(dir1);	
    	session.save(dir2);

    	List<Farmacia> lista;
    	lista=session.createCriteria(Farmacia.class) //seria como el from
    	.createAlias("dir","calleBuscada")
        .add(Restrictions.eq("calleBuscada.calle","ocampo")) //seria como el where
        .list();
    	
    	System.out.println("<<Punto 3>>" );
    	for(Farmacia listado:lista){
    		
    	System.out.println("FArmacia:" + listado.getNombre() + " Calle: "+ listado.getDireccion().getCalle());
    	
    	//assertEquals("ocampo",listado.getDireccion().getCalle());
   	
    	}
    	
	}
    	
   // Punto 4-​ ​Hacer​ ​con​ ​junit​ ​un​ ​test​ ​que​ ​busque​ ​todas​ ​las​ ​farmacias​ ​de​ ​un​ ​barrio::  
    	
    	@Test
    	@Transactional @Rollback(true)
    	@SuppressWarnings("unchecked")
    	public void todasLasFarmaciasDeUnBarrio(){
    		
    		// Creación de las farmacias y los barrios
    		
    		Barrio bar1= new Barrio();
    		bar1.setNombre("San Justo");
    		getSession().save(bar1);
    		
    		Barrio bar2= new Barrio();
    		bar2.setNombre("Mataderos");
    		getSession().save(bar2);
    		
    		Direccion dir1= new Direccion();
        	dir1.setCalle("ocampo");
        	dir1.setBarrio(bar1);
        	getSession().save(dir1);
        	
        	Direccion dir2= new Direccion();
        	dir2.setCalle("peru");
        	dir2.setBarrio(bar1);
        	getSession().save(dir2);
        	
        	Direccion dir3= new Direccion();
        	dir3.setCalle("alberdi");
        	dir3.setBarrio(bar2);
        	getSession().save(dir3);
    		    		
    		Farmacia far1= new Farmacia();
    		far1.setNombre("Pigmento");
    		far1.setDireccion(dir1);
    		getSession().save(far1);
    		
    		Farmacia far2= new Farmacia();
    		far2.setNombre("Vilela");
    		far2.setDireccion(dir2);
    		getSession().save(far2);
    		
    		Farmacia far3= new Farmacia();
    		far3.setNombre("Farmacity");
    		far3.setDireccion(dir3);
    		getSession().save(far3);
    		
    		    			 
    		List<Farmacia> lista=
    				getSession().createCriteria(Farmacia.class) //seria como el from
    				.createAlias("dir", "dir")
    				.createAlias("dir.barrio","barrio")
        	        .add(Restrictions.eq("barrio.nombre","Mataderos")) //seria como el where
                    .list();
        	
        	System.out.println("<<Punto 4>>" );
        	for(Farmacia listado:lista){
        		
        	System.out.println("Farmacia:" + listado.getNombre() + " Barrio: "+ listado.getNombre());
    		
    	}
    }
       	
      	
 /* Punto 5- Usando path variables, hacer un action que reciba una operación y sus
   dos operandos y que lleve a una vista que muestra la siguiente frase “El resultado 
   de​ sumar 3 y​ 6 da​ 9​ ”.En caso que no pueda realizarse la operación se​ ​debe​ 
   ​llevar​ ​a​ ​otra​ ​vista​ ​diferente​ ​donde​ ​se​ ​muestra​ ​un​ ​mensaje​ ​descriptivo. */
    	
    	
    	
    		
	
	
}