package edu.uv.model.dao;

import edu.uv.model.pojos.Personal;
import java.util.List;

public class PersonalDAO extends AbstractDao {

    public void create(Personal c) throws DataAccessLayerException {
        super.save(c);
    }

    public void update(Personal c) throws DataAccessLayerException {
        super.update(c);
    }

    public List findAll() throws DataAccessLayerException {
        return super.findAll(Personal.class);
    }

    public List findAllby(String cc, String ee) throws DataAccessLayerException {
        return super.findAllby(Personal.class, cc, ee);
    }

    public Personal find(int id) throws DataAccessLayerException {
        return (Personal) super.find(Personal.class, id);
    }

    public void delete(int id) throws DataAccessLayerException {
        super.delete(Personal.class, id);
    }
}