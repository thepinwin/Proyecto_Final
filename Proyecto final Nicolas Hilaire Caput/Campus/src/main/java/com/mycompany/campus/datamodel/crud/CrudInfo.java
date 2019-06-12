/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.crud;

import com.mycompany.campus.datamodel.HibernateUtil;
import com.mycompany.campus.datamodel.entities.Curso;
import com.mycompany.campus.datamodel.entities.CursoInfo;
import com.mycompany.campus.datamodel.entities.CursoTema;
import com.mycompany.campus.datamodel.entities.Info;
import com.mycompany.campus.datamodel.entities.Tema;
import java.io.File;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB 2
 */
public class CrudInfo {

    public void creatInfo(int idCurso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        CursoInfo info1 = new CursoInfo();

        info1.setIdCurso(idCurso);
        info1.setTexto("info");

        CursoInfo info2 = new CursoInfo();

        info2.setIdCurso(idCurso);
        info2.setTexto("apre");

        session.save(info1);
        session.save(info2);

        session.getTransaction().commit();

        session.close();
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

    public void info(CursoInfo idCuTe, int idCurso, String texto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Info info = new Info();

        info.setIdCurso(idCurso);
        info.setIdCursoInfo(idCuTe);
        info.setTexto(texto);

        session.save(info);

        session.getTransaction().commit();

        session.close();
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

    public void dropInfoCur(CursoInfo info) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();


        session.delete(info);

        session.getTransaction().commit();

        session.close();
    }

    public void dropInfo(int info) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Info infos = (Info) session.load(Info.class, info);

        session.delete(infos);

        session.getTransaction().commit();

        session.close();
    }
}
