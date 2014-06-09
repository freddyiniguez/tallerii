package edu.uv.model.dao;
import edu.uv.model.pojos.Pregunta;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class PreguntaDAO extends AbstractDao {
    public void create(Pregunta c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Pregunta c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Pregunta.class);
    }
    public Pregunta find(int id) throws DataAccessLayerException {
        return (Pregunta) super.find(Pregunta.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Pregunta.class,id);
    }
    public List costumQuery(String q) throws DataAccessLayerException {
        return super.costumQuery(Pregunta.class,q);
    }
 }