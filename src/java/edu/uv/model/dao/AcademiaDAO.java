package edu.uv.model.dao;
import edu.uv.model.pojos.Academia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AcademiaDAO extends AbstractDao {
    public void create(Academia c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Academia c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Academia.class);
    }
    public List findAllby(String cc,String ee) throws DataAccessLayerException {
        return super.findAllby(Academia.class, cc,ee);
    }
    public Academia find(int id) throws DataAccessLayerException {
        return (Academia) super.find(Academia.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Academia.class,id);
    }
 }