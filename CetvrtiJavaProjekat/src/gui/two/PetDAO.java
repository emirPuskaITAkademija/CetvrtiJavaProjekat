/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.two;

import advanced.konsultacije.Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupa2
 */
public class PetDAO implements Dao<Pet>{

    @Override
    public void save(Pet entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pet> getAll() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(0, "Bird"));
        pets.add(new Pet(0, "Cat"));
        pets.add(new Pet(0, "Dog"));
        pets.add(new Pet(0, "Pig"));
        pets.add(new Pet(0, "Rabbit"));
        return pets;
    }

    @Override
    public Pet get(int primaryKey) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pet entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pet entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
