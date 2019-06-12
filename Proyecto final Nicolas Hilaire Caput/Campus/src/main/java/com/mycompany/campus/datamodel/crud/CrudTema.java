/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.crud;

import com.mycompany.campus.datamodel.HibernateUtil;
import com.mycompany.campus.datamodel.entities.ClienteCurso;
import com.mycompany.campus.datamodel.entities.Curso;
import com.mycompany.campus.datamodel.entities.Tema;
import com.mycompany.campus.datamodel.entities.Profesor;
import com.mycompany.campus.datamodel.entities.CursoTema;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB 2
 */
public class CrudTema {
    
    public void newTema(int idCurso, String titulo, BigDecimal decimal) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        CursoTema tema = new CursoTema();
        
        tema.setIdCurso(idCurso);
        tema.setTitulo(titulo);
        tema.setPrecio(decimal);
        
        session.save(tema);

        session.getTransaction().commit();

        session.close();
    }
    
    public List<CursoTema> allTemas(int idCurso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM CursoTema where id_curso = "+idCurso;
        Query query = session.createQuery(hql);
        List<CursoTema> temas = query.list();

        if (temas.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return temas;
        }
    }
    public  List<Tema> getTema(int idCurso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Tema where idCurso = "+idCurso;
        Query query = session.createQuery(hql);
        List<Tema> tema = query.list();

        if (tema.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return tema;
        }
    }
    public  List<Tema> getTemas(int idCurso, int idTema) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Tema where idCurso = "+idCurso 
                + " and idCursoTema = " + idTema;
        Query query = session.createQuery(hql);
        List<Tema> tema = query.list();

        if (tema.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return tema;
        }
    }
    
    
    
    public void temaCont(CursoTema idCuTe, int idCurso, String nombre, String url) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Tema tema = new Tema();
        
        tema.setIdCurso(idCurso);
        tema.setIdCursoTema(idCuTe);
        tema.setNombre(nombre);
        tema.setUrl(url);
        
        session.save(tema);

        session.getTransaction().commit();

        session.close();
    }
    
    public CursoTema oneTema(int name, int curso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM CursoTema Where id = '"+ name + "' and id_curso = " + curso;
        Query query = session.createQuery(hql);
        
        CursoTema tema = (CursoTema) query.uniqueResult();
        if (tema == null) {

            session.close();
            return null;
        } else {
            session.close();
            return tema;
        }
    }
    
    public void dropTema(CursoTema idCuTe) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        CursoTema tema = idCuTe;
        
        session.delete(tema);
        
        session.getTransaction().commit();

        session.close();
    }
    
    public boolean deleteFile(File file){
        
        if(file.exists()){
            file.delete();
            return true;
        }else{
            return false;
        }
    }
    
    
    public void dropCurso(int cursoId){
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        Curso curso;
        curso = (Curso) session.get(Curso.class, cursoId);
        
        session.delete(curso);
        
        session.getTransaction().commit();

        session.close();
    }
    
    public Curso oneCurso(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Curso where id = "+id;
        Query query = session.createQuery(hql);
        List<Curso> cursos = query.list();

        if (cursos.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return cursos.get(0);
        }
    }
    
    public List<ClienteCurso> misTemas(int idCurso, int idCliente) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM ClienteCurso where idCurso = "+idCurso
        + " and idCliente = " + idCliente;
        Query query = session.createQuery(hql);
        List<ClienteCurso> temas = query.list();

        if (temas.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return temas;
        }
    }
}
