
package co.unicauca.restaurant.accces;



import co.unicauca.restaurant.domain.Dish;
import java.util.List;

/**
* Interface de los servicios del repositorio
* @author Eliana Andrea Araujo Camayo  cod: 104616021725
* @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
*/

public interface IProductRepository 
{

    /**
     *
     * @return
     */
    List<Dish> findAll();

    /**
     *
     * @param nombre
     * @return
     */
    Dish findById(String nombre);

    /**
     *
     * @param newDish
     * @return
     */
    boolean create(Dish newDish);

    /**
     *
     * @param newDish
     * @return
     */
    boolean update(Dish newDish);

    /**
     *
     * @param nombre
     * @return
     */
    boolean delete(String nombre);
}
