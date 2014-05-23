package edu.uv.model.dao;
import edu.uv.model.pojos.Imparte;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ImparteDAO extends AbstractDao {
    public void create(Imparte c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Imparte c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Imparte.class);
    }
    public Imparte find(int id) throws DataAccessLayerException {
        return (Imparte) super.find(Imparte.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Imparte.class,id);
    }
 }