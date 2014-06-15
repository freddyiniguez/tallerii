package edu.uv.model.dao;
import edu.uv.model.pojos.Usuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UsuariosDAO extends AbstractDao {
    public void create(Usuarios c) throws DataAccessLayerException {
        super.save(c);
    }
    public void update(Usuarios c) throws DataAccessLayerException {
        super.update(c);
    }
    public List findAll() throws DataAccessLayerException {
        return super.findAll(Usuarios.class);
    }
    public List findAllby(String cc,String ee) throws DataAccessLayerException {
        return super.findAllby(Usuarios.class, cc,ee);
    }
    public Usuarios find(int id) throws DataAccessLayerException {
        return (Usuarios) super.find(Usuarios.class, id);
    }
    public void delete(int id) throws DataAccessLayerException {
        super.delete(Usuarios.class,id);
    }
 }