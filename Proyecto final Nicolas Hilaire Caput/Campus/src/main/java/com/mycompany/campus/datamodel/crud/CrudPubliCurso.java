/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.crud;

import com.mycompany.campus.datamodel.HibernateUtil;
import com.mycompany.campus.datamodel.entities.Curso;
import com.mycompany.campus.datamodel.entities.CursoInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB 2
 */
public class CrudPubliCurso {
    
     public void publicar(int idCurso) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Curso curso = (Curso) session.get(Curso.class, idCurso);

        curso.setPublicado((short)1);
        
        session.update(curso);

        session.getTransaction().commit();

        session.close();
    }
}
