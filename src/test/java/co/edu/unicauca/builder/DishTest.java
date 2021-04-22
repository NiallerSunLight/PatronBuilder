/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.builder;
import co.unicauca.restaurant.DishApp.ItalianDish;
import co.unicauca.restaurant.DishApp.ItalianDishBuilder;
import co.unicauca.restaurant.DishApp.OrientalDish;
import co.unicauca.restaurant.DishApp.OrientalDishBuilder;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Size;
import co.unicauca.restaurant.services.DishBuilder;
import co.unicauca.restaurant.services.DishDirector;
import java.text.ParseException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


/**
 *
 * @author Eliana Andrea Araujo Camayo  cod: 104616021725
 * @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
 */
public class DishTest {
    
    /**
     *
     */
    public DishTest()
    {
        
    }
/**
     * Test para el plato Oriental 
     * @throws java.text.ParseException
     */
    @Test
    public void Oriental()throws ParseException
    {
        System.out.println("Oriental Dish");
        //Elementos del plato
        OrientalDish platoOriental;
        platoOriental = new OrientalDish("Arroz Oriental", "Arroz Estilo Oriental", "", "", 5500d, new ArrayList(), Size.ALL);
        platoOriental.addPart(new Dish("ShopSuey","","",5000d, new ArrayList(), Size.ALL));
        
        DishBuilder orientalBuilder = new OrientalDishBuilder();
        orientalBuilder.setDish(platoOriental);
       
        DishDirector director = new DishDirector(orientalBuilder);
        //director.create();
        Dish dish = director.getDish();
        assertEquals(10500, dish.getPrice());     
   }
   
   /**
     * Test para el plato Italian
     * @throws java.text.ParseException
     */
    @Test
    public void Italian()throws ParseException
    {
        System.out.println("Italian Dish");
        //Elementos del palto
        ItalianDish platoItalian;
        platoItalian = new ItalianDish();
        platoItalian = new ItalianDish("Pasta", "Pasta Estilo Italiano", "", "", 3000d, new ArrayList(), Size.ALL);
        platoItalian.addPart(new Dish("Carpaccio","","",4000d, new ArrayList(), Size.HALF));
        platoItalian.addPart(new Dish("Rissotto","","",4500d, new ArrayList(), Size.ALL));
        DishBuilder ItalianBuilder = new ItalianDishBuilder();
        ItalianBuilder.setDish(platoItalian);
       
        DishDirector director = new DishDirector(ItalianBuilder);
        
        Dish dish = director.getDish();
        assertEquals(9500, dish.getPrice());    

   }
}
