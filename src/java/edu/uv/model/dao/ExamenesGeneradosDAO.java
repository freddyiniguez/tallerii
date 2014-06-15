package edu.uv.model.dao;
import edu.uv.model.pojos.ExamenesGenerados;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ExamenesGeneradosDAO extends AbstractDao {
    public void create(ExamenesGenerados c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(ExamenesGenerados c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(ExamenesGenerados.class);
    }
    public List findAllby(String cc,String ee) throws DataAccessLayerException {
        return super.findAllby(ExamenesGenerados.class, cc,ee);
    }
    public ExamenesGenerados find(int id) throws DataAccessLayerException {
        return (ExamenesGenerados) super.find(ExamenesGenerados.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(ExamenesGenerados.class,id);
    }
 }