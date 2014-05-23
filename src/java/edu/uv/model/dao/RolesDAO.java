package edu.uv.model.dao;
import edu.uv.model.pojos.Roles;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class RolesDAO extends AbstractDao {
    public void create(Roles c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Roles c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Roles.class);
    }
    public Roles find(int id) throws DataAccessLayerException {
        return (Roles) super.find(Roles.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Roles.class,id);
    }
 }