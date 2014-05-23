/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uv.model.dao;
import edu.uv.model.pojos.Carrera;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author alex
 */

public class CarreraDAO extends AbstractDao {
    public void create(Carrera c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Carrera c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Carrera.class);
    }
    public Carrera find(int id) throws DataAccessLayerException {
        return (Carrera) super.find(Carrera.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Carrera.class,id);
    }
 }