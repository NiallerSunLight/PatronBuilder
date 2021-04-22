
package co.unicauca.restaurant.DishApp;

import co.unicauca.restaurant.accces.Factory;
import co.unicauca.restaurant.services.DishBuilder;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Size;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eliana Andrea Araujo Camayo  cod: 104616021725
 * @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
 */
public class ItalianDishBuilder extends DishBuilder
{
  ItalianDish myItalianDish;
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  List<Dish> allDish;
  List<Dish>  partes;
  
  
  private Dish read(List<Dish> myDishs, String foodPart) {
    String input = "";
    try {
        int i =1;
        System.out.println("Seleccione una "+foodPart);
       for (Dish each: myDishs)
       {
           System.out.println(""+i+". "+ each.getName() + ":"+each.getPrice());
           i++;
       }   
      System.out.println("Ingrese el código de la "+ foodPart);
      input = br.readLine();
    } catch (IOException e){
    }
    return myDishs.get(Integer.parseInt(input)-1);
  }
  
  private String read(String message) 
  {
    String input = "";
    try {
      System.out.println(message);
      input = br.readLine();
    } catch (IOException e) {
    }
    return input;
  }

    /**
     *
     * @return
     */
    @Override
    public DishBuilder init()
    {
        Factory objFactory = new Factory();
        myRepository = objFactory.getRepository("Italian");
        myDish = new ItalianDish();
        myItalianDish = (ItalianDish) myDish;
        //Obtenemos todos los productos
        allDish = myRepository.findAll();
        // Obtenemos las bases y las opciones
        partes = new ArrayList<Dish>();
        partes = allDish;
        return this ;
    }

    /**
     *
     */
    @Override
    public void setName(){
        myItalianDish.setName(read("Ingrese un nombre para el plato"));
    }
    
    /**
     *
     * @return
     */
    @Override
    public DishBuilder setCore() 
    {
        Dish prod = read(allDish, "Base");
        myItalianDish.setItalianName(prod.getName());
        myItalianDish.setDespcripcion(prod.getDespcripcion());
        String tamano = read("Presione la letra correspondiente para el tamaño Mediano (M), Completo (C)");
        if(tamano.equals("C") || tamano.equals("c")) myItalianDish.setSize(Size.ALL);
        if(tamano.equals("M") || tamano.equals("m")) myItalianDish.setSize(Size.HALF);
        else{
            myItalianDish.setSize(Size.ALL);
        }
        myItalianDish.setPrice(prod.getPrice());
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean addPart()
    {
        Dish prod = read(partes, "Parte");
        String tamano = read("Presione la letra correspondiente para el tamaño Mediano (M), Completo (C)");
        if(tamano.equals("C") || tamano.equals("c")) prod.setSize(Size.ALL);
        if(tamano.equals("M") || tamano.equals("m")) prod.setSize(Size.HALF);
        else{
            myItalianDish.setSize(Size.ALL);
        }
        myItalianDish.addPart(prod);
        return ("S".equals(read("Presione S para más partes")));
     
    }

    /**
     *
     */
    @Override
    public void saveDish(){
        myRepository.create(myDish);
    }
    
}
