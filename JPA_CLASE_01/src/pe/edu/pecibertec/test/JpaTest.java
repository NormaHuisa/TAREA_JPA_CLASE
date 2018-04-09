package pe.edu.pecibertec.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import pe.edu.cibertec.proyemp.jpa.domain.Departamento;

public class JpaTest {
	private EntityManager manager;
	
	//Constructor // Independencia
	public JpaTest (EntityManager manager){
		this.manager=manager;
	}
	
	public static void main(String[] args) {
		
		//Patron factory para obtener el EntityManager
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("myPersistenceUnit1");
		
		//Creo el entitymanager
		EntityManager em= factory.createEntityManager();
		
		//Inyecto(DI)
		JpaTest  test= new JpaTest(em);
		
		//DEFINO mi transaccion
		EntityTransaction tx= em.getTransaction();
		
		//defino ambito de transaccion
		tx.begin();
		//insert, update y delete
		test.crearEmpleado();
		tx.commit();
		
	}
	

	private void crearEmpleado() {
     Departamento lima= new Departamento("Lima");
     //lima.setNombre("Lima");
     manager.persist(lima);
		
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	

}
