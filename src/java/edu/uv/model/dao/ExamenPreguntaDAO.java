/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uv.model.dao;

import edu.uv.model.pojos.ExamenPregunta;
import java.util.List;

/**
 *
 * @author Arriaga Bellido
 */
public class ExamenPreguntaDAO extends AbstractDao {
    public void create(ExamenPregunta c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(ExamenPregunta c) throws DataAccessLayerException {
        super.update(c);
    }
    public List preguntasExamen(String idEx){
        return super.preguntasExamen(idEx);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(ExamenPregunta.class);
    }
    public List findAllby(String cc,String ee) throws DataAccessLayerException {
        return super.findAllby(ExamenPregunta.class, cc,ee);
    }
    public ExamenPregunta find(int id) throws DataAccessLayerException {
        return (ExamenPregunta) super.find(ExamenPregunta.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(ExamenPregunta.class,id);
    }
    
 }