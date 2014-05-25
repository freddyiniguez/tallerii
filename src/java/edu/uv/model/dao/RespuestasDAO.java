package edu.uv.model.dao;
import edu.uv.model.pojos.Respuestas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RespuestasDAO extends AbstractDao {
    public void create(Respuestas c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Respuestas c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Respuestas.class);
    }
    public Respuestas find(int id) throws DataAccessLayerException {
        return (Respuestas) super.find(Respuestas.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Respuestas.class,id);
    }
 }