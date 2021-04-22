
package co.unicauca.restaurant.domain;

import java.util.List;

/**
 *
 * @author Eliana Andrea Araujo Camayo  cod: 104616021725
 * @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
 */
public class Dish {

    /**
     *
     */
    protected String name;

    /**
     *
     */
    protected String despcripcion;

    /**
     *
     */
    protected String imagen;

    /**
     *
     */
    protected double price;

    /**
     *
     */
    protected List<Dish> partes;

    /**
     *
     */
    protected Size size;

    /**
     *
     */
    public Dish() {
    }

    /**
     *
     * @param name
     * @param despcripcion
     * @param imagen
     * @param price
     * @param partes
     * @param size
     */
    public Dish(String name, String despcripcion, String imagen, double price, List<Dish> partes, Size size) {
        this.name = name;
        this.despcripcion = despcripcion;
        this.imagen = imagen;
        this.price = price;
        this.partes = partes;
        this.size = size;
    }

    
    
    
    /**
     * @return the price
     */
    public double getPrice() {
        price = this.price;
        for(Dish each: partes){
            price = price + each.getPrice();
        }
        if(size==Size.HALF) price = 0.5*price;
        if(size==Size.ALL) price = 1*price;
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDespcripcion() {
        return despcripcion;
    }

    /**
     *
     * @param despcripcion
     */
    public void setDespcripcion(String despcripcion) {
        this.despcripcion = despcripcion;
    }

    /**
     *
     * @return
     */
    public String getImagen() {
        return imagen;
    }

    /**
     *
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     *
     * @return
     */
    public List<Dish> getPartes() {
        return partes;
    }

    /**
     *
     * @param partes
     */
    public void setPartes(List<Dish> partes) {
        this.partes = partes;
    }

    /**
     *
     * @return
     */
    public Size getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(Size size) {
        this.size = size;
    }
    
    
}
