package org.example.test;

import org.example.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testAuthor2 {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        manager.getTransaction().begin();
        Author a = manager.find(Author.class, 1L);
        if (a!=null){
            System.out.println(a);
        }else{
            System.out.println("No encontrado");
        }
        manager.getTransaction().commit();
        manager.close();

    }
}
