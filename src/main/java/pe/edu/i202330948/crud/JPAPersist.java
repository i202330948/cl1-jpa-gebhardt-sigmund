package pe.edu.i202330948.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202330948.entity.City;
import pe.edu.i202330948.entity.Country;
import pe.edu.i202330948.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {

        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // crear el país imaginario
        Country country = new Country("ZZZ", "Tibecuador", "South America", "Caribbean", 9833517.0,
                1776, 331002651, 78.9, 600.0, 230051.0, "Tibecuador",
                "Federal Republic", "Pikachu", 50, "ZZ", null, null);

        // crear las ciudades
        City city1 = new City("CiudadA", "Distrito1", 500000, country);
        City city2 = new City("CiudadB", "Distrito2", 400000, country);
        City city3 = new City("CiudadC", "Distrito3", 300000, country);

        // agregar ciudades al país
        country.setCity(Arrays.asList(city1, city2, city3));

        // crear las lenguas
        CountryLanguage language1 = new CountryLanguage("IdiomaA", "T", 78.5, country);
        CountryLanguage language2 = new CountryLanguage("IdiomaB", "F", 30.2, country);

        // agregar lenguas al país
        country.setCountryLanguages(Arrays.asList(language1, language2));

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        System.out.println("País, ciudades y lenguajes persistidos exitosamente.");

    }

}
