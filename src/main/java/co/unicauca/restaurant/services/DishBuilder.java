
package co.unicauca.restaurant.services;

import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.accces.IProductRepository;

/**
 *
 * @author Eliana Andrea Araujo Camayo  cod: 104616021725
 * @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
 */
public abstract class DishBuilder {
    
    /**
     *
     */
    protected Dish myDish;

    /**
     *
     */
    protected IProductRepository myRepository;
    
    Dish getDish() {
        return myDish;
    }
    
    /**
     *
     * @param myDish
     */
    public void setDish(Dish myDish)
    {
        this.myDish = myDish;
    }

    /**
     *
     * @return
     */
    public abstract DishBuilder init();
    
    /**
     *
     */
    public abstract void setName();
    
    //public abstract void setMultimedia();

    /**
     *
     * @return
     */

    public abstract DishBuilder setCore();

    /**
     *
     * @return
     */
    public abstract boolean addPart();
    
    /**
     *
     */
    public abstract void saveDish();
    
}
