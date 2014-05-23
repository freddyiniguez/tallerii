package edu.uv.model.dao;
import edu.uv.model.pojos.Unidades;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UnidadesDAO extends AbstractDao {
    public void create(Unidades c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Unidades c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Unidades.class);
    }
    public Unidades find(int id) throws DataAccessLayerException {
        return (Unidades) super.find(Unidades.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Unidades.class,id);
    }
 }