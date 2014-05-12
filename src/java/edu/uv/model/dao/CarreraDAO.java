/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uv.model.dao;
import edu.uv.model.pojos.Carrera;
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
    public void ingresarCarrera(Carrera c){
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx=null;
        try {
            sf = HibernateUtil.getSessionFactory();
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
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Carrera c= (Carrera)sesion.get(Carrera.class, idcarrera);
        sesion.close();
        if (c!=null){
            return "La carrera de identificador" +c.getIdCarrera()+" tiene por nombre "+c.getNombreCarrera();
        }
        else
            return "La carrera " + idcarrera+" no está registrada";
    }
    public List<Carrera> verCarreras(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Query query = sesion.createQuery("from Carrera");
        List <Carrera> lista = query.list();
        sesion.close();
        return lista;
    }
 }