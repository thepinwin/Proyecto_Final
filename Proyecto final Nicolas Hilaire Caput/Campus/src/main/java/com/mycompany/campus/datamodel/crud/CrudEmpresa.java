/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.campus.datamodel.crud;

import com.mycompany.campus.datamodel.HibernateUtil;
import com.mycompany.campus.datamodel.entities.Profesor;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB 2
 */
public class CrudEmpresa {

    public void newEmpresa(String nombre, String correo, String contra, String comunidad, String cif) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Profesor prof = new Profesor(nombre, correo, getMD5(contra), comunidad, cif);

        session.save(prof);

        session.getTransaction().commit();

        session.close();
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
}
