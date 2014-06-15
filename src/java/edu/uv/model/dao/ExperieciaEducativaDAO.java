package edu.uv.model.dao;
import edu.uv.model.pojos.ExperieciaEducativa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ExperieciaEducativaDAO extends AbstractDao {
    public void create(ExperieciaEducativa c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(ExperieciaEducativa c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(ExperieciaEducativa.class);
    }
    public List findAllby(String cc,String ee) throws DataAccessLayerException {
        return super.findAllby(ExperieciaEducativa.class, cc,ee);
    }
    public ExperieciaEducativa find(int id) throws DataAccessLayerException {
        return (ExperieciaEducativa) super.find(ExperieciaEducativa.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(ExperieciaEducativa.class,id);
    }
 }