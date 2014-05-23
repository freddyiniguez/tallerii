package edu.uv.model.dao;
import edu.uv.model.pojos.CarreraAcademia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class CarreraAcademiaDAO extends AbstractDao {
    public void create(CarreraAcademia c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(CarreraAcademia c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(CarreraAcademia.class);
    }
    public CarreraAcademia find(int id) throws DataAccessLayerException {
        return (CarreraAcademia) super.find(CarreraAcademia.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(CarreraAcademia.class,id);
    }
 }