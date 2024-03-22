/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tp1customeromega.jsf;

import org.primefaces.model.FilterMeta;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import mg.itu.tp1customeromega.entity.Customer;
import mg.itu.tp1customeromega.service.CustomerManager;

/**
 * Backing bean pour la page JSF customerList
 * @author Dina
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
    private List<Customer> customerList;
    
    @Inject
    private CustomerManager customerManager;
    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }
    
    /**
     * Retourne la liste des clients pour affichage dans une DataTable
     * @return 
     */
    public List<Customer> getCustomers(){
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }
    
    public List<Customer> customFilter(List<Customer> customers, Map<String, FilterMeta> filters) {
        customers.sort(Comparator.comparing(Customer::getState)
                                  .thenComparing(Customer::getCity));

        return customers;
    }
}
