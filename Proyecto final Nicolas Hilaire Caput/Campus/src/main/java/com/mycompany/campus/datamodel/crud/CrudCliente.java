/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.crud;

import com.mycompany.campus.datamodel.HibernateUtil;
import com.mycompany.campus.datamodel.entities.Cliente;
import com.mycompany.campus.datamodel.entities.ClienteCurso;
import com.mycompany.campus.datamodel.entities.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB 2
 */
public class CrudCliente {

    public void newCliente(String nombre, String apellidos, String correo, String contra) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Cliente cliente = new Cliente(nombre, apellidos, correo, getMD5(contra));

        session.save(cliente);

        session.getTransaction().commit();

        session.close();
    }

    public Cliente okUser(String correo, String pass) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Cliente WHERE mail = '" + correo + "' and contrasenya = '" + getMD5(pass) + "'";
        Query query = session.createQuery(hql);
        List<Cliente> usuarios = query.list();

        if (usuarios.isEmpty()) {

            session.close();
            return null;
        } else {

            session.close();
            return usuarios.get(0);
        }
    }

    public List<Curso> allCurs() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Curso WHERE publicado = 1";
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
    
    public List<Curso> allCursCate(String categoria) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Curso WHERE publicado = 1 and categoria = " + categoria;
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

    public List<Curso> misCursos(int idUs) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Curso c, ClienteCurso u where u.idCliente = " + idUs
                + " and c.id = u.idCurso and u.active = 1";
        Query query = session.createQuery(hql);
        List<?> cursos = query.list();
        List<Curso> cur = new ArrayList();
        for (int i = 0; i < cursos.size(); i++) {
            Object[] row = (Object[]) cursos.get(i);
            cur.add((Curso) row[0]);
        }

        if (cursos.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return cur;
        }
    }

    public List<Curso> misCursosNop(int idUs) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Curso c, ClienteCurso u where u.idCliente = " + idUs
                + " and c.id = u.idCurso and u.active is null";
        Query query = session.createQuery(hql);
        List<?> cursos = query.list();
        List<Curso> cur = new ArrayList();
        for (int i = 0; i < cursos.size(); i++) {
            Object[] row = (Object[]) cursos.get(i);
            cur.add((Curso) row[0]);
        }
        session.close();
        if (cursos.isEmpty()) {

            return null;
        } else {
            return cur;
        }
    }

    public void newCursoAddTema(int curso, int cliente, int tema, int cod) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        ClienteCurso cursos = new ClienteCurso(cliente, curso, tema, cod);

        session.save(cursos);

        session.getTransaction().commit();

        session.close();
    }

    public void updateCurso(ClienteCurso cur, int random) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        cur.setActive(null);
        cur.setRandom(random);

        session.update(cur);

        session.getTransaction().commit();

        session.close();
    }

    public void newCursoAdd(int curso, int cliente, Integer codigo) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        ClienteCurso cursos = new ClienteCurso(cliente, curso, codigo);

        session.save(cursos);

        session.getTransaction().commit();

        session.close();
    }

    public Curso oneCurso(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Curso Where id = " + id;
        Query query = session.createQuery(hql);

        Curso curso = (Curso) query.uniqueResult();
        if (curso == null) {

            session.close();
            return null;
        } else {
            session.close();
            return curso;
        }
    }

    public String profCurso(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "SELECT p.nombre FROM Curso c,  Profesor p Where (c.idProfesor = p.id and c.id = " + id + ") or (c.idEmpresa = p.id and c.id = " + id + ")";
        Query query = session.createQuery(hql);

        Object curso = (Object) query.uniqueResult();
        if (curso == null) {

            session.close();
            return null;
        } else {
            session.close();
            return (String) curso;
        }
    }

    public String haveCurso(int idCurso, int idCliente) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Curso c, ClienteCurso u, Cliente l where u.idCliente = l.id "
                + "and u.idCurso = c.id and u.idCliente = " + idCliente + " and "
                + "u.idCurso = " + idCurso;
        Query query = session.createQuery(hql);

        List<Object> listDatos = query.list();

        if (listDatos.isEmpty()) {

            session.close();
            return "false";
        } else {
            session.close();
            return "true";
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

    public CursoInfo oneInfo(String name, int curso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM CursoInfo Where texto = '" + name + "' and idCurso = " + curso;
        Query query = session.createQuery(hql);

        CursoInfo info = (CursoInfo) query.uniqueResult();
        if (info == null) {

            session.close();
            return null;
        } else {
            session.close();
            return info;
        }
    }

    public List<Info> getInfo(int idCurso, int idTema) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM Info where idCurso = " + idCurso
                + " and idCursoInfo = " + idTema;
        Query query = session.createQuery(hql);
        List<Info> info = query.list();

        if (info.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return info;
        }
    }

//    public List<RegistroCompra> getRegistro(int idCurso, int idTema) {
//
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//RegistroCompra df = new RegistroCompra();
//        
//        Session session = sessionFactory.openSession();
//
//        session.beginTransaction();
//
//        String hql = "FROM Info where idCurso = " + idCurso
//                + " and idCursoInfo = " + idTema;
//        Query query = session.createQuery(hql);
//        List<Info> info = query.list();
//
//        if (info.isEmpty()) {
//
//            session.close();
//            return null;
//        } else {
//            session.close();
//            return df;
//        }
//    }
    // Curso Entero
    public void newRegistro(int idCliente, int idCurso, int idFactura, BigDecimal precioBase, BigDecimal iva, BigDecimal precio) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        RegistroCompra regis = new RegistroCompra(idFactura, idCliente, idCurso, new Date(), precioBase, iva, precio);

        session.save(regis);

        session.getTransaction().commit();

        session.close();
    }

    // Curso por temas 
    public void newRegistros(int idCliente, int idCurso, int idFactura, int idTema, BigDecimal precioBase, BigDecimal iva, BigDecimal precio) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        RegistroCompra regis = new RegistroCompra(idFactura, idCliente, idCurso, idTema, new Date(), precioBase, iva, precio);

        session.save(regis);

        session.getTransaction().commit();

        session.close();
    }

    // Curso Entero
    public List<RegistroCompra> getRegistroList(int idCliente) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM RegistroCompra where idCliente = " + idCliente + "";
        Query query = session.createQuery(hql);
        List<RegistroCompra> info = query.list();

        if (info.isEmpty()) {
            session.close();
            return null;
        } else {
            session.close();
            return info;
        }
    }

    // Get un Tema info
    public CursoTema oneTema(int idCurso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        String hql = "FROM CursoTema where id = " + idCurso;
        Query query = session.createQuery(hql);
        List<CursoTema> temas = query.list();

        if (temas.isEmpty()) {

            session.close();
            return null;
        } else {
            session.close();
            return temas.get(0);
        }
    }

    public Cliente oneUser(String correo) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Cliente WHERE mail = '" + correo + "'";
        Query query = session.createQuery(hql);
        List<Cliente> usuarios = query.list();

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

        Cliente cli = (Cliente) session.get(Cliente.class, idUs);

        cli.setContrasenya(getMD5(pass));
        session.update(cli);

        session.getTransaction().commit();

        session.close();
    }

    public void token(String mail, String link) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Date fecha = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(fecha);

        c.add(Calendar.DATE, 2);

        Date currentDatePlusOne = c.getTime();

        Newpass pass = new Newpass(mail, link, currentDatePlusOne);

        session.save(pass);

        session.getTransaction().commit();

        session.close();
    }

    public Newpass tokenFin(String link) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM Newpass WHERE token = '" + link + "'";
        Query query = session.createQuery(hql);
        List<Newpass> usuarios = query.list();

        if (usuarios.isEmpty()) {

            session.close();
            return null;
        } else {

            session.close();
            return usuarios.get(0);
        }
    }

    public ClienteCurso active(int cod, int curso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        String hql = "FROM ClienteCurso WHERE id_curso = '" + curso + "' and "
                + "random = '" + cod + "'";
        Query query = session.createQuery(hql);
        List<ClienteCurso> usuarios = query.list();

        if (usuarios.isEmpty()) {

            session.close();
            return null;
        } else {

            session.close();
            return usuarios.get(0);
        }
    }

    public void OkActive(ClienteCurso cli) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        cli.setActive(1);

        session.update(cli);

        session.getTransaction().commit();

        session.close();
    }

}
