
package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Definicion de la tabla moto y con la característica de que es serializable
 * @author Flia Ramirez Palacio
 */
@Entity
@Table(name = "motorbike")
public class Motorbike implements Serializable{
    
        
    /**
     * Definicion del campo id o identificador como un valor entero, es una llave primaria que hace unico el registro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    /**
     * Definicion del campo nombre como un campo de texto, puede identificar la referencia
     */
    private String name;
    
    /**
     * Definicion del campo marca como un campo de texto, ejemplo: AKT, Suzuki
     */
    private String brand;
    
    /**
     * Definicion del campo año de lanzamiento como un valor entero
     */
    private Integer year;
    
    /**
     * Definicion del campo descripcion como un campo de texto, ejemplo nombre comercial del modelo, ejemplo: 1990, 2001
     */
    private String description;    
    
    /**
     * Relacion de múltiples motos para una categoria
     */
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("motorbikes")
    private Categoria category;

    /**
     * Relacion de una moto con multiples mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})
    private List<Mensaje> messages;

    /**
     * Relacion de una moto con múltiples reservas
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike", "client"})
    private List<Reservaciones> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
   
}
