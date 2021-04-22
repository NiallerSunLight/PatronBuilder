package co.unicauca.restaurant.services;

import co.unicauca.restaurant.domain.Dish;


/**
 *
 * @author Eliana Andrea Araujo Camayo  cod: 104616021725
 * @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
 * 
 */ 

public class DishDirector {
  
  private DishBuilder builder;

    /**
     *
     * @param builder
     */
    public DishDirector(DishBuilder builder) {
    this.builder = builder;
  }

    /**
     *
     * @return
     */
    public Dish getDish() {
    return builder.getDish();
  }

    /**
     *
     */
    public void create() {
    boolean masPartes = true;
    builder.init();
    builder.setName();
    builder.setCore();
    while(masPartes){
        masPartes = builder.addPart();
    }
    builder.saveDish();
}
}
