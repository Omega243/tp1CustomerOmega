/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tp1customeromega.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tp1customeromega.entity.Customer;
import jakarta.transaction.Transactional;

/**
 * Façade pour gérer les Customers.
 * @author Dina
 */
/**
 * Gère la persistance des Customers.
 */
@RequestScoped
public class CustomerManager {
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {  
      Query query = em.createNamedQuery("Customer.findAll");
      return query.getResultList();  
    } 
    
    @Transactional
    public Customer update(Customer customer) {
      return em.merge(customer);
    }   
    
    @Transactional
    public void persist(Customer customer) {
      em.persist(customer);
    }  
    
    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
    
}
