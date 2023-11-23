package org.example.test;

import org.example.model.Author;
import org.example.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class testContact2 {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf= Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        Contact c = manager.find(Contact.class, 1L);
        System.out.println(c);
        //list();
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
