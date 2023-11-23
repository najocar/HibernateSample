package org.example.test;

import org.example.model.Author;
import org.example.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class testContact {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf= Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        Author a1 = new Author(1L, "Carlos Serrano", LocalDate.parse("1980-06-01"));
        Author a2 = new Author(2L, "Miguel de Cervantes", LocalDate.parse("1547-09-22"));
        a1.setContact(new Contact(1L, "666939257", "555",a1));

        manager.getTransaction().begin();
        manager.persist(a1);
        manager.persist(a2);
        manager.getTransaction().commit();
        list();
    }

    public static  void list(){
        List<Author> authors = manager.createQuery("FROM Author").getResultList();
        System.out.println("Autores: " + authors.size());
        for(Author a:authors){
            System.out.println(a);
        }
        System.out.println("*************");
    }
}
