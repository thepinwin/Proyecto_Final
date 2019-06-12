/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.crud;

import com.mycompany.campus.datamodel.HibernateUtil;
import com.mycompany.campus.datamodel.entities.Categoria;
import com.mycompany.campus.datamodel.entities.ClienteCurso;
import com.mycompany.campus.datamodel.entities.Curso;
import com.mycompany.campus.datamodel.entities.Profesor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB 2
 */
public class CrudProfesor {

    public void newProfesor(String nombre, String apellidos, String correo, String contra, String comunidad, String dni) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Profesor prof = new Profesor(nombre, apellidos, correo, getMD5(contra), comunidad, dni);

        session.save(prof);

        session.getTransaction().commit();

        session.close();
    }

    public Profesor okProfe(String correo, String pass) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Profesor WHERE mail = '" + correo + "' and contrasenya = '" + getMD5(pass) + "'";
        Query query = session.createQuery(hql);
        List<Profesor> usuarios = query.list();

        if (usuarios.isEmpty()) {
            session.close();
            return null;
        } else {

            session.close();
            return usuarios.get(0);
        }

    }

    public int newCurso(String tiutlo, String descrip, String url_foto, String url_pdf, String url_video, Profesor prof, BigDecimal precio, int categoria) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        
        Categoria cat = (Categoria) session.load(Categoria.class, categoria);

        Curso cur = null;
        if (prof.getDni() != null) {
            // Profesor
            cur = new Curso(tiutlo, descrip, url_foto, url_pdf,
                    url_video, new Date(), prof.getId(), precio, (short) 0,cat);
        } else {
            // Empresa
            cur = new Curso(tiutlo, descrip, url_foto, url_pdf,
                    url_video, new Date(), precio, (short) 0, prof.getId(), cat);
        }

        session.save(cur);

        session.getTransaction().commit();

        session.close();
        return cur.getId();
    }

    public Curso oneCurso(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Curso where id = " + id;
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

    public List<Curso> allCursProf(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Curso where IdProfesor = " + id + " OR idEmpresa = " + id;
        Query query = session.createQuery(hql);
        List<Curso> cursos = query.list();

        if (cursos.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return cursos;
        }
    }
    
        public List<ClienteCurso> active(int curso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM ClienteCurso WHERE id_curso = '" + curso + "'";
        Query query = session.createQuery(hql);
        List<ClienteCurso> usuarios = query.list();

        if (usuarios.isEmpty()) {

            session.close();
            return null;
        } else {

            session.close();
            return usuarios;
        }
    }

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Profesor oneUser(String correo) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Profesor WHERE mail = '" + correo + "'";
        Query query = session.createQuery(hql);
        List<Profesor> usuarios = query.list();

        if (usuarios.isEmpty()) {

            session.close();
            return null;
        } else {

            session.close();
            return usuarios.get(0);
        }
    }
    
    public void newPass(int idUs, String pass) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Profesor cli = (Profesor) session.get(Profesor.class, idUs);

        cli.setContrasenya(getMD5(pass));
        session.update(cli);
        
        session.getTransaction().commit();

        session.close();
    }
    
     public List<Categoria> categoria() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Categoria";
        Query query = session.createQuery(hql);
        List<Categoria> cat = query.list();

        if (cat.isEmpty()) {

            session.close();
            return null;
        } else {

            session.close();
            return cat;
        }
    }
}
