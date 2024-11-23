package pe.edu.i202330948.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202330948.entity.Country;

public class JPARemove {

    public static void main(String[] args) {

        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // obtener pais
        Country country = em.find(Country.class, "ZZZ");

        // eliminar pais
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

    }

}
