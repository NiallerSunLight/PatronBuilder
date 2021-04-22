/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.restaurant.accces;

/**
 *
 * @author Eliana Andrea Araujo Camayo  cod: 104616021725
 * @author Jesus Edwin Adrada Ruiz  cod: 104617020514
 * @author Carlos Enrique Hoyos Joiro  cod: 104617020768
 */
public class Factory 
{

    /**
     *
     * @param dishType
     * @return
     */
    public IProductRepository getRepository(String dishType)
    {
        IProductRepository objDishRepository = null;
        if("Oriental".equals(dishType))
        {
            objDishRepository = new OrientalRepositoryImplArrays();
        }
        else if("Italian".equals(dishType))
        {
            objDishRepository = new ItalianRepositoryImplArrays();
        }
        return objDishRepository;
    }
  
    
}
