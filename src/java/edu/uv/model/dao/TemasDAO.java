package edu.uv.model.dao;
import edu.uv.model.pojos.Temas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class TemasDAO extends AbstractDao {
    public void create(Temas c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Temas c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Temas.class);
    }
    public Temas find(int id) throws DataAccessLayerException {
        return (Temas) super.find(Temas.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Temas.class,id);
    }
 }