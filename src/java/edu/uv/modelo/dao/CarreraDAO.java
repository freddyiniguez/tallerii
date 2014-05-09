package edu.uv.modelo.dao;

import edu.uv.modelo.dao.NewHibernateUtil;
import edu.uv.modelo.pojos.Carrera;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author alex
 */
public class CarreraDAO {
    public void CarreraDAO(){
    }
    public void ingresarCarrera(Carrera c){
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx=null;
        try {
            sf = NewHibernateUtil.getSessionFactory();
            sesion = sf.openSession();
            tx = sesion.beginTransaction();
            sesion.save(c);
            tx.commit();
            sesion.close();
        }
        catch (Exception ex){
            tx.rollback();
            throw new RuntimeException ("No se pudo agregar la carrera");
        }
    }
    public String buscaCarrera(int idcarrera){
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Carrera c= (Carrera)sesion.get(Carrera.class, idcarrera);
        sesion.close();
        if (c!=null){
            return "La carrera de identificador" +c.getIdcarrera()+" tiene por nombre "+c.getNombreCarrera();
        }
        else
            return "La carrera " + idcarrera+" no está registrada";
    }
    public List<Carrera> verCarreras(){
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Carrera");
        List <Carrera> lista = query.list();
        sesion.close();
        return lista;
    }
 }
