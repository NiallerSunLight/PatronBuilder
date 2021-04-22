
package co.unicauca.restaurant.accces;
import co.unicauca.restaurant.domain.Dish;
import co.unicauca.restaurant.domain.Size;
import java.util.ArrayList;
import java.util.List;

/**
* Implementación por defecto. El framewok contenedor de CDI (Contexts and
* Dependency Injection) carga la implementación por defecto.
*
* @author Eliana Andrea Araujo Camayo  cod: 104616021725
* @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
*/

public class OrientalRepositoryImplArrays implements IProductRepository
{

/**
* Por simplicidad los datos se cargan en un array.
*/
    public static List<Dish> listDish;
    
    /**
     *
     */
    public OrientalRepositoryImplArrays(){
        listDish = new ArrayList<>();
        initialize();
    }
    
    private void initialize() {
        listDish.add(new Dish("Shop Suey", "", "",5000d, new ArrayList<>(),Size.ALL));
        listDish.add(new Dish("Arroz Oriental", "", "", 5500d, new ArrayList<>(),Size.ALL));
        listDish.add(new Dish("Pasta con Verduras", "", "", 5000d, new ArrayList<>(),Size.ALL));
        listDish.add(new Dish("Pollo Agridulce", "", "", 5800d, new ArrayList<>(),Size.ALL));
        listDish.add(new Dish("Cerdo Tropical", "", "", 6900d, new ArrayList<>(),Size.ALL));
        listDish.add(new Dish("Res Teriyaki", "", "", 6200d, new ArrayList<>(),Size.ALL));
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Dish> findAll() {
        return listDish;
    }

    /**
     *
     * @param nombre
     * @return
     */
    @Override
    public Dish findById(String nombre) {
        for(Dish prod:listDish){
            if (prod.getName().equals(nombre)) {
                return prod;
            }
        }
        return null;
    }

    /**
     *
     * @param newDish
     * @return
     */
    @Override
    public boolean create(Dish newDish) {
        Dish prod = this.findById(newDish.getName());
        if (prod != null) {
                //Ya existe
                return false;
        }
        listDish.add(newDish);
        return true;
    }

    /**
     *
     * @param newDish
     * @return
     */
    @Override
    public boolean update(Dish newDish) {
        Dish prod = this.findById(newDish.getName());
        if (prod != null) {
            prod.setName(newDish.getName());
            prod.setPrice(newDish.getPrice());
        return true;
        }
    return false;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public boolean delete(String name){
        for (Dish prod : listDish) {
                if (prod.getName().equals(name)) {
                    listDish.remove(prod);
                    return true;
                }
        }
        return false;
    }
}
